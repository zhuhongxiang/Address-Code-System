package com.address.system.core.dto.address.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class FindByAllFullAddrReqDTO extends BaseReqDTO {
    @NonNull
    private String allFullAddr;
    @NonNull
    private Integer pageIndex; //当前的页面序号（0开始）
    @NonNull
    private Integer pageSize; //一页展示的条目数
    //高亮查询的前后标签
    private String preTag;
    private String postTag;
}
