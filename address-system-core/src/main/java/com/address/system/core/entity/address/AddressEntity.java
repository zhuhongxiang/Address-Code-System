package com.address.system.core.entity.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.sql.Timestamp;

/*
mysql用的address实体类
 */
@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    @Id
    @Column(name = "id", length = 6)//数据库字段名
    private Long id;

    @Column(name = "all_full_addr_id", length = 36, nullable = false)//数据库字段名
    private String allFullAddrId;

    @Column(name = "all_full_addr", length = 300, nullable = false)
    private String allFullAddr;

    @Column(name = "qu_id", length = 6)
    private String quId;

    @Column(name = "qu", length = 120)
    private String qu;

    @Column(name = "toponym_id", length = 36)
    private String toponymId;

    @Column(name = "toponym", length = 120)
    private String toponym;

    @Column(name = "haozuo_id", length = 4000)
    private String haozuoId;

    @Column(name = "haozuo", length = 100)
    private String haozuo;

    @Column(name = "building_id", length = 36)
    private String buildingId;

    @Column(name = "building", length = 120)
    private String building;

    @Column(name = "seat_id", length = 36)
    private String seatId;

    @Column(name = "seat", length = 120)
    private String seat;

    @Column(name = "cell_id", length = 36)
    private String cellId;

    @Column(name = "cell", length = 60)
    private String cell;

    @Column(name = "room", length = 120)
    private String room;

    @Column(name = "sxzjd_id", length = 9)
    private String sxzjdId;

    @Column(name = "sxzjd", length = 120)
    private String sxzjd;

    @Column(name = "quxcun_id", length = 12)
    private String quxcunId;

    @Column(name = "quxcun", length = 120)
    private String quxcun;

    @Column(name = "dycxsx", length = 3)
    private String dycxsx;

    @Column(name = "map_x",length = 10)
    private String mapX;

    @Column(name = "map_y",length = 10)
    private String mapY;

    @Column(name = "property", length = 30)
    private String property;

    @Column(name = "org_name", length = 120)
    private String orgName;

    @Column(name = "zh_bs", length = 3)
    private String zhBs;

    @Column(name = "create_user", length = 50)
    private String createUesr;

    @Column(name = "update_user", length = 50)
    private String updateUesr;

    @Column(name = "is_delete", length = 1)
    private Boolean isDelete;

    @Column(name ="ts",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)
    @Generated(GenerationTime.ALWAYS)
    private Timestamp ts;
}
