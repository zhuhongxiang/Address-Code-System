package com.address.system.core.service.impl;

import com.address.system.core.dao.RouteDao;
import com.address.system.core.dao.RouteESRepository;
import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.dto.route.request.FindByPostmanIdDTO;
import com.address.system.core.dto.route.response.FindAllRespDTO;
import com.address.system.core.dto.route.response.FindByPostmanIdRespDTO;
import com.address.system.core.dto.route.response.FindByPostmanIdSortRespDTO;
import com.address.system.core.entity.route.RouteESEntity;
import com.address.system.core.service.RouteService;
import com.address.system.core.utils.ESQueryUtils;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("RouteService")
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteESRepository routeESRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private RouteDao routeDao;

    //字段映射map
    private static final Map<String,String> titleMap = new HashMap<String,String>(){{
        put("id","id");
        put("orderId","order_id");
        put("address","address");
        put("customerName","customer_name");
        put("customerTel","customer_tel");
        put("postmanId","postman_id");
        put("postmanName","postman_name");
        put("postmanTel","postman_tel");
        put("status","status");
    }};

    /*
    创建索引，其实没多必要
     */
    @Override
    public BaseRespDTO putMapping(){
        BaseRespDTO respDTO = new BaseRespDTO();
        try {
            elasticsearchRestTemplate.putMapping(RouteESEntity.class);
            respDTO.setRespMsg("success");
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespMsg(e.getMessage());
            respDTO.setRespCode(BaseRespDTO.FAIL);
        }
        return respDTO;
    }

    @Override
    public FindAllRespDTO findAll() {

        /*
        List<RouteEntity> result = routeDao.findAll();

        List<String> addressList = new ArrayList<>();

        for (RouteEntity routeEntity : result) {
            addressList.add(routeEntity.getAddress());
        }

        return addressList;
         */
        FindAllRespDTO respDTO = new FindAllRespDTO();

        try {
            List<RouteESEntity> result = new ArrayList<>();
            routeESRepository.findAll().forEach(entity -> result.add(entity));
            respDTO.setAddrList(result);
            respDTO.setRespMsg("success");
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
        }catch(Exception e){
            respDTO.setRespMsg("查询失败,错误为：" + e.getMessage());
            respDTO.setRespCode(BaseRespDTO.FAIL);
        }

        return respDTO;
    }

    @Override
    public FindByPostmanIdRespDTO findByPostmanId(FindByPostmanIdDTO postmanIdDTO) {
        /*
        String postmanId = postmanIdDTO.getPostmanId();

        List<RouteEntity> result = routeDao.findByPostmanId(postmanId);

        List<String> addressList = new ArrayList<>();

        for (RouteEntity routeEntity : result) {
            addressList.add(routeEntity.getAddress());
        }

        return addressList;
         */
        FindByPostmanIdRespDTO respDTO = new FindByPostmanIdRespDTO();
        RouteESEntity routeESEntity = new RouteESEntity();
        routeESEntity.setPostmanId(postmanIdDTO.getPostmanId());

        try {
            BoolQueryBuilder queryBuilder = ESQueryUtils.generateBoolQueryBuilderByEntity(routeESEntity, titleMap);
            NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                //.withPageable(PageRequest.of(pageIndex,pageSize))
                //.withMinScore(1)
                .withSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .build();
            List<RouteESEntity> result = new ArrayList<>();
            elasticsearchRestTemplate.search(searchQuery, RouteESEntity.class)
                .forEach(hit -> result.add(hit.getContent()));

            respDTO.setAddrList(result);
            respDTO.setRespMsg("success");
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
        }catch(Exception e){
            respDTO.setRespMsg("查询失败,错误为：" + e.getMessage());
            respDTO.setRespCode(BaseRespDTO.FAIL);
        }

        return respDTO;
    }

    @Override
    public FindByPostmanIdSortRespDTO findByPostmanIdSort(FindByPostmanIdDTO postmanIdDTO){

        FindByPostmanIdSortRespDTO respDTO =new FindByPostmanIdSortRespDTO();
        RouteESEntity routeESEntity = new RouteESEntity();
        routeESEntity.setPostmanId(postmanIdDTO.getPostmanId());

        //List<RouteEntity> result = new ArrayList<>();

        try {
            //result = routeDao.findByPostmanIdOrderByOrderId(postmanIdDTO.getPostmanId());
            BoolQueryBuilder queryBuilder = ESQueryUtils.generateBoolQueryBuilderByEntity(routeESEntity, titleMap);
            NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                //.withPageable(PageRequest.of(pageIndex,pageSize))
                //.withMinScore(1)
                //order_id.keyword是order_id的子字段，不分词，可用于排序和精确查找
                .withSort(SortBuilders.fieldSort("order_id.keyword").order(SortOrder.ASC))
                .withSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .build();
            List<RouteESEntity> result = new ArrayList<>();
            elasticsearchRestTemplate.search(searchQuery, RouteESEntity.class)
                .forEach(hit -> result.add(hit.getContent()));
            respDTO.setAddrSortList(result);
            respDTO.setRespMsg("success");
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
        }catch (Exception e){
            respDTO.setRespMsg("查询失败,错误为：" + e.getMessage());
            respDTO.setRespCode(BaseRespDTO.FAIL);
        }

        return respDTO;
    }
}
