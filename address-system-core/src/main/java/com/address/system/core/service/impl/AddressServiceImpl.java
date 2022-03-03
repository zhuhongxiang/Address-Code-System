package com.address.system.core.service.impl;

import com.address.system.core.dao.AddressDao;
import com.address.system.core.dto.address.request.AddAddressReqDTO;
import com.address.system.core.dto.address.request.DeleteAddressByAllFullAddrIdReqDTO;
import com.address.system.core.dto.address.request.UpdateAddressReqDTO;
import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.entity.address.AddressESEntity;
import com.address.system.core.entity.address.AddressEntity;
import com.address.system.core.service.AddressService;
import com.address.system.core.utils.CopyUtils;
import com.address.system.core.utils.ESQueryUtils;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private AddressDao addressDao;

    //字段映射map
    private static final Map<String,String> titleMap = new HashMap<String,String>(){{
        put("id","id");
        put("allFullAddrId","all_full_addr_id");
        put("allFullAddr","ALL_FULL_ADDR");
        put("quId","qu_id");
        put("qu","qu");
        put("toponymId","toponym_id");
        put("toponym","toponym");
        put("haozuoId","haozuo_id");
        put("haozuo","haozuo");
        put("buildingId","building_id");
        put("building","building");
        put("seatId","seat_id");
        put("seat","seat");
        put("cellId","cell_id");
        put("cell","cell");
        put("room","room");
        put("sxzjdId","sxzjd_id");
        put("sxzjd","sxzjd");
        put("quxcunId","quxcun_id");
        put("quxcun","quxcun");
        put("dycxsx","dycxsx");
        put("mapX","map_x");
        put("mapY","map_y");
        put("property","property");
        put("orgName","org_name");
        put("zhBs","zh_bs");
        put("isDelete","is_delete");
    }};

    //设置分页(从第一页开始，一页显示10条)
    //注意开始是从0开始，有点类似sql中的方法limit 的查询
    private final Pageable pageable = PageRequest.of(0,10);


    /*
    创建索引，其实没多必要
     */
    @Override
    public BaseRespDTO putMapping(){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            elasticsearchRestTemplate.putMapping(AddressESEntity.class);
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespMsg(BaseRespDTO.FAIL);
            respDTO.setRespMsg(e.getMessage());
        }
        return respDTO;
    }


    /*
    针对多个字段联合查询
     */
    @Override
    public List<AddressESEntity> find(AddressESEntity addressESEntity, int pageIndex, int pageSize){
        List<AddressESEntity> entities = new ArrayList<>();
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();//构建组合查询
        //待查询的多字段匹配
        queryBuilder.must(ESQueryUtils.generateBoolQueryBuilderByEntity(addressESEntity,titleMap));
        //只找已启用的字段
        //queryBuilder.must(QueryBuilders.matchPhraseQuery("property","启用"));//约定property字段为是否数据库行是否被删除的isDelete标志
        queryBuilder.must(QueryBuilders.matchPhraseQuery("is_delete",false));
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(queryBuilder)
            .withPageable(PageRequest.of(pageIndex,pageSize))
            //.withMinScore(10)
            .withSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .build();
        elasticsearchRestTemplate.search(searchQuery, AddressESEntity.class).forEach(hit -> {
            AddressESEntity entity = hit.getContent();
            entities.add(entity);
        });
        return entities;
    }

    /*
    针对多个字段联合模糊查询
    可以高亮
     */
    @Override
    public List<AddressESEntity> findWithFuzzy(AddressESEntity addressESEntity,int pageIndex, int pageSize,String preTag,String postTag){
        List<AddressESEntity> entities = new ArrayList<>();
        //构建高亮查询
        HighlightBuilder highlightBuilder = ESQueryUtils.generateHighLightBuilderByEntity(addressESEntity,titleMap,preTag,postTag);
        //构建普通组合查询
        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        //待查询的多字段
        queryBuilder.must(ESQueryUtils.generateBoolQueryBuilderByEntityWithFuzzy(addressESEntity,titleMap));
        //设定只找已启用的字段
        //queryBuilder.must(QueryBuilders.matchPhraseQuery("property","启用"));//约定property字段为是否数据库行是否被删除的isDelete标志
        queryBuilder.must(QueryBuilders.matchPhraseQuery("is_delete",false));
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(queryBuilder)
            .withHighlightBuilder(highlightBuilder)
            .withPageable(PageRequest.of(pageIndex,pageSize))
            //.withMinScore(5)
            .withSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            .build();
        elasticsearchRestTemplate.search(searchQuery, AddressESEntity.class).forEach(hit -> {
            //解析高亮字段
            //获取当前命中的对象的高亮的字段
            AddressESEntity entity = hit.getContent();
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
    public BaseRespDTO addAddress(AddAddressReqDTO reqDto){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            AddressESEntity addressESEntity = new AddressESEntity();
            addressESEntity.setAllFullAddrId(reqDto.getAllFullAddrId());
            List<AddressESEntity> esEntites = this.find(addressESEntity, 0, 1000);
            if (esEntites.size() > 0) throw new RuntimeException("数据库已存在该数据！");
            AddressEntity entity = new AddressEntity();
            CopyUtils.copyProperties(reqDto, entity);
            entity.setProperty("启用"); //约定property字段为是否数据库行是否被删除的isDelete标志
            addressDao.save(entity);

            respDTO.setRespMsg(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        } catch(Exception e){
            e.printStackTrace();
            respDTO.setRespMsg(BaseRespDTO.FAIL);
            respDTO.setRespMsg("增加失败,错误为:" + e.getMessage());
        }
        return respDTO;
    }

    @Override
    public BaseRespDTO updateAddress(UpdateAddressReqDTO reqDto){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            //先通过es查询数据，再转换为sql数据库实体，再导入dto更新字段进行更新
            AddressESEntity addressESEntity = new AddressESEntity();
            addressESEntity.setAllFullAddrId(reqDto.getAllFullAddrId());
            List<AddressESEntity> esEntites = this.find(addressESEntity, 0, 1000);
            if (esEntites.size() <= 0) throw new RuntimeException("数据库不存在该数据！");
            if (esEntites.size() > 1) throw new RuntimeException("查询到多于一条数据!");
            AddressEntity entity = new AddressEntity();
            CopyUtils.copyProperties(esEntites.get(0), entity);
            CopyUtils.copyPropertiesIgnoreNulls(reqDto, entity); //将dto需要更新的字段导入实体类里
            addressDao.save(entity);

            respDTO.setRespMsg(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespMsg(BaseRespDTO.FAIL);
            respDTO.setRespMsg("修改失败,错误为:" + e.getMessage());
        }
        return respDTO;
    }


    @Override
    public BaseRespDTO deleteAddressBySystemId(DeleteAddressByAllFullAddrIdReqDTO reqDTO){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            //先通过es查询数据，再转换为sql数据库实体，再导入dto更新字段进行更新
            AddressESEntity addressESEntity = new AddressESEntity();
            addressESEntity.setAllFullAddrId(reqDTO.getAllFullAddrId());
            List<AddressESEntity> esEntites = this.find(addressESEntity, 0, 1000);
            if (esEntites.size() <= 0) throw new RuntimeException("数据库不存在该数据！");
            if (esEntites.size() > 1) throw new RuntimeException("查询到多于一条数据");
            AddressEntity entity = new AddressEntity();
            CopyUtils.copyProperties(esEntites.get(0), entity);
            entity.setProperty("已停用");//约定property字段为是否数据库行是否被删除的isDelete标志
            entity.setIsDelete(false);
            addressDao.save(entity);
            respDTO.setRespMsg(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespMsg(BaseRespDTO.FAIL);
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
        if (fieldName == null || fieldName.equals("")){
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
