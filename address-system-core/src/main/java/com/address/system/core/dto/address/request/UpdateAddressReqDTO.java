package com.address.system.core.dto.address.request;

import com.address.system.core.dto.base.BaseReqDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UpdateAddressReqDTO extends BaseReqDTO {
    @NonNull
    private String allFullAddrId;

    @NonNull
    private String allFullAddr;

    private String quId;

    private String qu;

    private String toponymId;

    private String toponym;

    private String haozuoId;

    private String haozuo;

    private String buildingId;

    private String building;

    private String seatId;

    private String seat;

    private String cellId;

    private String cell;

    private String room;

    private String sxzjdId;

    private String sxzjd;

    private String quxcunId;

    private String quxcun;

    private String dycxsx;

    private String mapX;

    private String mapY;

    //private String property;

    private String orgName;

    private String zhBs;
}

