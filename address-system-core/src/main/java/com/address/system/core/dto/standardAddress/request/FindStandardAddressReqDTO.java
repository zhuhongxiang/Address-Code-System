package com.address.system.core.dto.standardAddress.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class FindStandardAddressReqDTO extends BaseReqDTO {

    private String fullAddressCode;

    private String fullAddress;

    private Integer provinceCode;

    private String provinceName;

    private String latitude;

    private String longitude;

    private String status;

    @NonNull
    private Integer pageIndex; //当前的页面序号（0开始）
    @NonNull
    private Integer pageSize; //一页展示的条目数
}
