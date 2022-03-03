package com.address.system.core.dto.standardAddress.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.elasticsearch.search.DocValueFormat;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class AddStandardAddressReqDTO extends BaseReqDTO {

    @NonNull
    private String fullAddressCode;

    @NonNull
    private String fullAddress;

    private Integer provinceCode;

    private String provinceName;

    private String latitude;

    private String longitude;

    private String status;
}

