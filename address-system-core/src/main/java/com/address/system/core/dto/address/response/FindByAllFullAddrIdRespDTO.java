package com.address.system.core.dto.address.response;

import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.entity.address.AddressESEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FindByAllFullAddrIdRespDTO extends BaseRespDTO {
    private List<AddressESEntity> foundEntites;
    private Integer curPageIndex;
    private Integer curPageSize;
}
