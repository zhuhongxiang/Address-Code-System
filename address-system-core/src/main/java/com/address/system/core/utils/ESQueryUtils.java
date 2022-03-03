package com.address.system.core.utils;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Map;
import java.util.Optional;

/*
构建es查询语句的通用类
 */
public class ESQueryUtils {
    /*
    将查询entity中不为空的属性字段放入查询语句中
    有字段映射
     */
    public static <T> BoolQueryBuilder generateBoolQueryBuilderByEntity(T entity, Map<String,String> titleMap){
        /*组合查询BoolQueryBuilder
         * must(QueryBuilders)   :AND
         * mustNot(QueryBuilders):NOT
         * should:               :OR
         */
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();//构建组合查询
        final BeanWrapper e = new BeanWrapperImpl(entity);
        PropertyDescriptor[] pds = e.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            String title = titleMap.get(pd.getName());
            Object srcValue = e.getPropertyValue(pd.getName());
            if (srcValue == null || title == null || title.equals("")) continue;
            queryBuilder.must(QueryBuilders.matchPhraseQuery(title,String.valueOf(srcValue)));
        }
        return queryBuilder;
    }

    /*
    将查询entity中不为空的属性字段放入查询语句中
    没有字段映射
     */
    public static <T> BoolQueryBuilder generateBoolQueryBuilderByEntity(T entity){
        /*组合查询BoolQueryBuilder
         * must(QueryBuilders)   :AND
         * mustNot(QueryBuilders):NOT
         * should:               :OR
         */
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();//构建组合查询
        final BeanWrapper e = new BeanWrapperImpl(entity);
        PropertyDescriptor[] pds = e.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            String title = pd.getName();
            Object srcValue = e.getPropertyValue(pd.getName());
            if (srcValue == null || title == null || title.equals("")) continue;
            queryBuilder.must(QueryBuilders.matchPhraseQuery(title,String.valueOf(srcValue)));
        }
        return queryBuilder;
    }

    /*
   将查询entity中不为空的属性字段放入查询语句中
   有字段映射
   带模糊查询
    */
    public static <T> BoolQueryBuilder generateBoolQueryBuilderByEntityWithFuzzy(T entity, Map<String,String> titleMap){
        /*组合查询BoolQueryBuilder
         * must(QueryBuilders)   :AND
         * mustNot(QueryBuilders):NOT
         * should:               :OR
         */
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();//构建组合查询
        final BeanWrapper e = new BeanWrapperImpl(entity);
        PropertyDescriptor[] pds = e.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            String title = titleMap.get(pd.getName());
            Object srcValue = e.getPropertyValue(pd.getName());
            if (srcValue == null || title == null || title.equals("")) continue;
            queryBuilder.should(QueryBuilders.matchPhraseQuery(title,String.valueOf(srcValue)));
            //queryBuilder.should(QueryBuilders.matchPhrasePrefixQuery(title,String.valueOf(srcValue)));
            queryBuilder.should(QueryBuilders.fuzzyQuery(title,String.valueOf(srcValue)).fuzziness(Fuzziness.AUTO));
        }
        return queryBuilder;
    }

    /*
  将查询entity中不为空的属性字段放入查询语句中
  无字段映射
  带模糊查询
   */
    public static <T> BoolQueryBuilder generateBoolQueryBuilderByEntityWithFuzzy(T entity){
        /*组合查询BoolQueryBuilder
         * must(QueryBuilders)   :AND
         * mustNot(QueryBuilders):NOT
         * should:               :OR
         */
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();//构建组合查询
        final BeanWrapper e = new BeanWrapperImpl(entity);
        PropertyDescriptor[] pds = e.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            String title = pd.getName();
            Object srcValue = e.getPropertyValue(pd.getName());
            if (srcValue == null || title == null || title.equals("")) continue;
            queryBuilder.should(QueryBuilders.matchPhraseQuery(title,String.valueOf(srcValue)));
            //queryBuilder.should(QueryBuilders.matchPhrasePrefixQuery(title,String.valueOf(srcValue)));
            queryBuilder.should(QueryBuilders.fuzzyQuery(title,String.valueOf(srcValue)).fuzziness(Fuzziness.AUTO));
        }
        return queryBuilder;
    }

    /*
    构建多字段高亮查询
    有字段映射
     */
    public static <T> HighlightBuilder generateHighLightBuilderByEntity(T entity,Map<String,String> titleMap,String preTag,String postTag){

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(true); //如果该属性中有多个关键字 则都高亮
        highlightBuilder.preTags(Optional.ofNullable(preTag).orElse(""));
        highlightBuilder.postTags(Optional.ofNullable(postTag).orElse(""));

        final BeanWrapper e = new BeanWrapperImpl(entity);
        PropertyDescriptor[] pds = e.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            String title = titleMap.get(pd.getName());
            Object srcValue = e.getPropertyValue(pd.getName());
            if (srcValue == null || title == null || title.equals("")) continue;
            highlightBuilder.field(title);
        }

        return highlightBuilder;
    }

    /*
    构建多字段高亮查询
    无字段映射
     */
    public static <T> HighlightBuilder generateHighLightBuilderByEntity(T entity,String preTag,String postTag){

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(true); //如果该属性中有多个关键字 则都高亮
        highlightBuilder.preTags(Optional.ofNullable(preTag).orElse(""));
        highlightBuilder.postTags(Optional.ofNullable(postTag).orElse(""));

        final BeanWrapper e = new BeanWrapperImpl(entity);
        PropertyDescriptor[] pds = e.getPropertyDescriptors();
        for(PropertyDescriptor pd : pds) {
            String title = pd.getName();
            Object srcValue = e.getPropertyValue(pd.getName());
            if (srcValue == null || title == null || title.equals("")) continue;
            highlightBuilder.field(title);
        }

        return highlightBuilder;
    }

}
