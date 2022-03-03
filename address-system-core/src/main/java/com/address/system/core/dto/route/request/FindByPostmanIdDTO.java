package com.address.system.core.dto.route.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class FindByPostmanIdDTO extends BaseReqDTO {
    @NonNull
    private String postmanId;
}
