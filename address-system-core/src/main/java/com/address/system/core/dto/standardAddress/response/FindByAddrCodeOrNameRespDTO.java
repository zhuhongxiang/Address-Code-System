package com.address.system.core.dto.standardAddress.response;

import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.entity.standardAddress.StandardAddressESEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FindByAddrCodeOrNameRespDTO extends BaseRespDTO {
    private List<StandardAddressESEntity> foundEntites;
    private Integer curPageIndex;
    private Integer curPageSize;
}
