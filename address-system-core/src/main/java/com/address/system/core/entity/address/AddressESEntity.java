package com.address.system.core.entity.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

/*
ES上的地址表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "address",type = "_doc", shards = 1, replicas = 0)
public class AddressESEntity {
    @Id
    @MultiField(mainField = @Field(name = "id", type = FieldType.Long))
    private Long id;

    @MultiField(mainField = @Field(name = "all_full_addr_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String allFullAddrId;

    @MultiField(mainField = @Field(name = "all_full_addr",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String allFullAddr;

    @MultiField(mainField = @Field(name = "qu_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String quId;

    @MultiField(mainField = @Field(name = "qu",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String qu;

    @MultiField(mainField = @Field(name = "toponym_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String toponymId;

    @MultiField(mainField = @Field(name = "toponym",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String toponym;

    @MultiField(mainField = @Field(name = "haozuo_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String haozuoId;

    @MultiField(mainField = @Field(name = "haozuo",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String haozuo;

    @MultiField(mainField = @Field(name = "building_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String buildingId;

    @MultiField(mainField = @Field(name = "building",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String building;

    @MultiField(mainField = @Field(name = "seat_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String seatId;

    @MultiField(mainField = @Field(name = "seat",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String seat;

    @MultiField(mainField = @Field(name = "cell_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String cellId;

    @MultiField(mainField = @Field(name = "cell", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String cell;

    @MultiField(mainField = @Field(name = "room", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String room;

    @MultiField(mainField = @Field(name = "sxzjd_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String sxzjdId;

    @MultiField(mainField = @Field(name = "sxzjd", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String sxzjd;

    @MultiField(mainField = @Field(name = "quxcun_id", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String quxcunId;

    @MultiField(mainField = @Field(name = "quxcun", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String quxcun;

    @MultiField(mainField = @Field(name = "dycxsx", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String dycxsx;

    @MultiField(mainField = @Field(name = "map_x", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Double, suffix = "keyword") })
    private Double mapX;

    @MultiField(mainField = @Field(name = "map_y", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Double, suffix = "keyword") })
    private Double mapY;

    @MultiField(mainField = @Field(name = "property", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String property;

    @MultiField(mainField = @Field(name = "org_name", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String orgName;

    @MultiField(mainField = @Field(name = "zh_bs", type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String zhBs;

    @MultiField(mainField = @Field(name = "is_delete", type = FieldType.Boolean))
    private Boolean isDelete;
}

