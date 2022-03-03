package com.address.system.core.dto.route.response;

import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.entity.route.RouteESEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FindAllRespDTO extends BaseRespDTO {
    private List<RouteESEntity> addrList;
}
