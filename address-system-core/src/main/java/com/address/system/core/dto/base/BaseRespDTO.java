package com.address.system.core.dto.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseRespDTO {
    public static String SUCCESS = "200";

    public static String FAIL = "400";

    /**
     * @Fields respCode : 响应码
     */
    protected String respCode;
    /**
     * @Fields respMsg : 响应信息
     */
    protected String respMsg;
}
