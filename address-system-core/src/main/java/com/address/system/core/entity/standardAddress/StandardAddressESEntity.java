package com.address.system.core.entity.standardAddress;


import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/*
ES上的地址表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "standard_address", shards = 1, replicas = 0)
public class StandardAddressESEntity {
    @Id
    @MultiField(mainField = @Field(name = "id", type = FieldType.Long))
    private Long id;

    @MultiField(mainField = @Field(name = "full_address_code",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String fullAddressCode;

    @MultiField(mainField = @Field(name = "full_address",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String fullAddress;

    @MultiField(mainField = @Field(name = "province_code",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Integer, suffix = "keyword") })
    private Integer provinceCode;

    @MultiField(mainField = @Field(name = "province_name",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String provinceName;

    @MultiField(mainField = @Field(name = "latitude",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Double, suffix = "keyword") })
    private String latitude;

    @MultiField(mainField = @Field(name = "longitude",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Double, suffix = "keyword") })
    private String longitude;

    @MultiField(mainField = @Field(name = "status",type = FieldType.Text), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String status;

    @MultiField(mainField = @Field(name = "create_user",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String createUser;

    @MultiField(mainField = @Field(name = "update_user",type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart"), otherFields = {
        @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String updateUser;

    @Field(name = "create_time", type = FieldType.Date, format = DateFormat.date_optional_time)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT+8")
    private Date createTime;

    @Field(name = "update_time", type = FieldType.Date, format = DateFormat.date_optional_time)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT+8")
    private Date updateTime;

    @Field(name = "ts", type = FieldType.Date, format = DateFormat.date_optional_time)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT+8")
    private Date ts;

    @MultiField(mainField = @Field(name = "yn", type = FieldType.Boolean))
    private Boolean yn;
}
