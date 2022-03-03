package com.address.system.core.service.impl;


import com.address.system.core.dao.StandardAddressDao;
import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.dto.standardAddress.request.AddStandardAddressReqDTO;
import com.address.system.core.dto.standardAddress.request.DeleteAddressByFullAddrCodeReqDTO;
import com.address.system.core.dto.standardAddress.request.UpdateStandardAddressReqDTO;
import com.address.system.core.entity.standardAddress.StandardAddressESEntity;
import com.address.system.core.entity.standardAddress.StandardAddressEntity;
import com.address.system.core.service.StandardAddressService;
import com.address.system.core.utils.CopyUtils;
import com.address.system.core.utils.ESQueryUtils;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service("StandardAddressService")
public class StandardAddressServiceImpl implements StandardAddressService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private StandardAddressDao standardAddressDao;

    //字段映射map
    private static final Map<String,String> TITLE_MAP = new HashMap<String,String>(){{
        put("id","id");
        put("fullAddressCode","full_address_code");
        put("fullAddress","full_address");
        put("proviceCode","provice_code");
        put("provinceName","province_name");
        put("latitude","latitude");
        put("longitude","longitude");
        put("status","status");
        put("createUser","create_user");
        put("updateUser","update_user");
        put("createTime","create_time");
        put("updateTime","update_time");
        put("ts","ts");
        put("yn","yn");
    }};

    /*
    创建索引，其实没多必要
     */
    @Override
    public BaseRespDTO putMapping(){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            elasticsearchRestTemplate.putMapping(StandardAddressESEntity.class);
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg(e.getMessage());
        }
        return respDTO;
    }

    /*
   针对多个字段联合查询
    */
    @Override
    public List<StandardAddressESEntity> find(StandardAddressESEntity standardAddressESEntity, int pageIndex, int pageSize){
        List<StandardAddressESEntity> entities = new ArrayList<>();
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();//构建组合查询
        //待查询的多字段匹配
        queryBuilder.must(ESQueryUtils.generateBoolQueryBuilderByEntity(standardAddressESEntity, TITLE_MAP));
        //只找已启用的字段
        queryBuilder.must(QueryBuilders.matchPhraseQuery("yn",true));
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(queryBuilder)
            .withPageable(PageRequest.of(pageIndex,pageSize))
            //.withMinScore(10)
            .withSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .build();
        elasticsearchRestTemplate.search(searchQuery, StandardAddressESEntity.class).forEach(hit -> {
            StandardAddressESEntity entity = hit.getContent();
            entities.add(entity);
        });
        return entities;
    }

    /*
    针对多个字段联合模糊查询
    可以高亮
     */
    @Override
    public List<StandardAddressESEntity> findWithFuzzy(StandardAddressESEntity standardAddressESEntity,int pageIndex, int pageSize,String preTag,String postTag){
        List<StandardAddressESEntity> entities = new ArrayList<>();
        //构建高亮查询
        HighlightBuilder highlightBuilder = ESQueryUtils.generateHighLightBuilderByEntity(standardAddressESEntity, TITLE_MAP,preTag,postTag);
        //构建普通组合查询
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        //待查询的多字段
        queryBuilder.must(ESQueryUtils.generateBoolQueryBuilderByEntityWithFuzzy(standardAddressESEntity, TITLE_MAP));
        //设定只找已启用的字段
        queryBuilder.must(QueryBuilders.matchPhraseQuery("yn",true));
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(queryBuilder)
            .withHighlightBuilder(highlightBuilder)
            .withPageable(PageRequest.of(pageIndex,pageSize))
            //.withMinScore(5)
            .withSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .build();
        elasticsearchRestTemplate.search(searchQuery, StandardAddressESEntity.class).forEach(hit -> {
            //解析高亮字段
            //获取当前命中的对象的高亮的字段
            StandardAddressESEntity entity = hit.getContent();
            Map<String, List<String>> highlightFields = hit.getHighlightFields();
            if (!highlightFields.isEmpty()) {
                // 反射调用set方法将高亮内容设置进去
                try {
                    for (Map.Entry<String, List<String>> entry : highlightFields.entrySet()) {
                        String setMethodName = parSetMethodName(entry.getKey());
                        Class<?> Clazz = entity.getClass();
                        Method setMethod = Clazz.getMethod(setMethodName, String.class);
                        setMethod.invoke(entity, entry.getValue().get(0));
                    }
                } catch (Exception e) {
                    throw new RuntimeException("反射报错" + e.getMessage());
                }
            }
            entities.add(entity);
        });
        return entities;
    }
    @Override
    public BaseRespDTO addAddress(AddStandardAddressReqDTO reqDto){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            StandardAddressESEntity addressESEntity = new StandardAddressESEntity();
            addressESEntity.setFullAddressCode(reqDto.getFullAddressCode());
            List<StandardAddressESEntity> esEntites = this.find(addressESEntity, 0, 1000);
            if (esEntites.size() > 0) {
                throw new RuntimeException("数据库已存在该数据！");
            }
            StandardAddressEntity entity = new StandardAddressEntity();
            CopyUtils.copyProperties(reqDto, entity);
            entity.setCreateTime(LocalDateTime.now());
            entity.setYn(true); //约定property字段为是否数据库行是否被删除的isDelete标志
            standardAddressDao.save(entity);

            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        } catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("增加失败,错误为:" + e.getMessage());
        }
        return respDTO;
    }

    @Override
    public BaseRespDTO updateAddress(UpdateStandardAddressReqDTO reqDto){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            //先通过es查询数据，再转换为sql数据库实体，再导入dto更新字段进行更新
            StandardAddressESEntity addressESEntity = new StandardAddressESEntity();
            addressESEntity.setFullAddressCode(reqDto.getFullAddressCode());
            List<StandardAddressESEntity> esEntites = this.find(addressESEntity, 0, 1000);
            if (esEntites.size() <= 0) {
                throw new RuntimeException("数据库不存在该数据！");
            }
            if (esEntites.size() > 1) {
                throw new RuntimeException("查询到多于一条数据!");
            }
            StandardAddressEntity entity = new StandardAddressEntity();
            CopyUtils.copyProperties(esEntites.get(0), entity);
            CopyUtils.copyPropertiesIgnoreNulls(reqDto, entity); //将dto需要更新的字段导入实体类里
            standardAddressDao.save(entity);

            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("修改失败,错误为:" + e.getMessage());
        }
        return respDTO;
    }


    @Override
    public BaseRespDTO deleteAddressBySystemId(DeleteAddressByFullAddrCodeReqDTO reqDTO){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            //先通过es查询数据，再转换为sql数据库实体，再导入dto更新字段进行更新
            StandardAddressESEntity addressESEntity = new StandardAddressESEntity();
            addressESEntity.setFullAddressCode(reqDTO.getFullAddressCode());
            List<StandardAddressESEntity> esEntites = this.find(addressESEntity, 0, 1000);
            if (esEntites.size() <= 0) {
                throw new RuntimeException("数据库不存在该数据！");
            }
            if (esEntites.size() > 1) {
                throw new RuntimeException("查询到多于一条数据");
            }
            System.out.println(esEntites.get(0));
            StandardAddressEntity entity = new StandardAddressEntity();
            CopyUtils.copyProperties(esEntites.get(0), entity);
            entity.setYn(false);
            standardAddressDao.save(entity);

            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("删除失败,错误为:" + e.getMessage());
        }
        return respDTO;
    }

    /**
     * 根据字段名，获取Set方法名
     * @param fieldName 字段名
     * @return  Set方法名
     */
    private static String parSetMethodName(String fieldName){
        if (fieldName == null || "".equals(fieldName)){
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_'){
            startIndex = 1;
        }
        return "set" + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
            + fieldName.substring(startIndex + 1);
    }
}
