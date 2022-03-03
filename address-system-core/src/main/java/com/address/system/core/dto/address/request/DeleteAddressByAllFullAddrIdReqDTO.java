package com.address.system.core.dto.address.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class DeleteAddressByAllFullAddrIdReqDTO extends BaseReqDTO {
    @NonNull
    private String allFullAddrId;
}
