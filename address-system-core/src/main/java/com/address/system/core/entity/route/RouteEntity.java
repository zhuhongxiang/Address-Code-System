package com.address.system.core.entity.route;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "delivery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "address")
    private String address;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_tel")
    private String customerTel;

    @Column(name = "postman_id")
    private String postmanId;

    @Column(name = "postman_name")
    private String postmanName;

    @Column(name = "postman_tel")
    private String postmanTel;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_uesr")
    private String createUesr;

    @Column(name = "update_uesr")
    private String updateUesr;

    @Column(name ="ts",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)
    @Generated(GenerationTime.ALWAYS)
    private Timestamp ts;

}
