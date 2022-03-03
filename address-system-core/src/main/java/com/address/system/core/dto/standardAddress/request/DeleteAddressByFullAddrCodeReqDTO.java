package com.address.system.core.dto.standardAddress.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class DeleteAddressByFullAddrCodeReqDTO extends BaseReqDTO {
    @NonNull
    private String fullAddressCode;
}
