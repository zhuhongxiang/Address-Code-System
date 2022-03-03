package com.address.system.core.entity.standardAddress;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.elasticsearch.annotations.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/*
    mysql用的address实体类
    */
@Entity
@Table(name = "standard_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardAddressEntity {
    @Id
    @Column(name = "id", length = 20)//数据库字段名
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_address_code", length = 36)//数据库字段名
    private String fullAddressCode;

    @Column(name = "full_address", length = 300)//数据库字段名
    private String fullAddress;

    @Column(name = "province_code", length = 5)//数据库字段名
    private Integer provinceCode;

    @Column(name = "province_name", length = 50)//数据库字段名
    private String provinceName;

    @Column(name = "latitude", length = 10)//数据库字段名
    private String latitude;

    @Column(name = "longitude", length = 10)//数据库字段名
    private String longitude;

    @Column(name = "status")//数据库字段名
    private String status;

    @Column(name = "create_user", length = 50)//数据库字段名
    private String createUser;

    @Column(name = "update_user", length = 50)//数据库字段名
    private String updateUser;

    @Column(name = "create_time",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)//数据库字段名
    private LocalDateTime createTime;

    @Column(name = "update_time",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)//数据库字段名
    @Generated(GenerationTime.ALWAYS)
    private LocalDateTime updateTime;

    @Column(name ="ts",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)
    @Generated(GenerationTime.ALWAYS)
    private Timestamp ts;

    @Column(name = "yn", length = 1)
    private Boolean yn;
}
