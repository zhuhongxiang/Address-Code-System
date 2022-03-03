package com.address.system.core.service;


import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.dto.standardAddress.request.AddStandardAddressReqDTO;
import com.address.system.core.dto.standardAddress.request.DeleteAddressByFullAddrCodeReqDTO;
import com.address.system.core.dto.standardAddress.request.UpdateStandardAddressReqDTO;
import com.address.system.core.entity.standardAddress.StandardAddressESEntity;

import java.util.List;

public interface StandardAddressService {
    BaseRespDTO putMapping();

    List<StandardAddressESEntity> find(StandardAddressESEntity standardAddressESEntity, int pageIndex, int pageSize);

    List<StandardAddressESEntity> findWithFuzzy(StandardAddressESEntity standardAddressESEntity,int pageIndex, int pageSize,String preTag,String postTag);

    BaseRespDTO addAddress(AddStandardAddressReqDTO reqDto);

    BaseRespDTO updateAddress(UpdateStandardAddressReqDTO reqDto);

    BaseRespDTO deleteAddressBySystemId(DeleteAddressByFullAddrCodeReqDTO reqDTO);
}
