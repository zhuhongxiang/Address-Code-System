package com.address.system.core.entity.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "route",type = "_doc", shards = 1, replicas = 0)
public class RouteESEntity {
    @Id
    @MultiField(mainField = @Field(name = "id", type = FieldType.Long))
    private Long id;

    @MultiField(mainField = @Field(name = "order_id",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String orderId;

    @MultiField(mainField = @Field(name = "address",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String address;

    @MultiField(mainField = @Field(name = "customer_name",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String customerName;

    @MultiField(mainField = @Field(name = "customer_tel",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String customerTel;

    @MultiField(mainField = @Field(name = "postman_id",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String postmanId;

    @MultiField(mainField = @Field(name = "postman_name",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String postmanName;

    @MultiField(mainField = @Field(name = "postman_tel",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String postmanTel;

    @MultiField(mainField = @Field(name = "status",type = FieldType.Integer))
    private Integer status;
}
