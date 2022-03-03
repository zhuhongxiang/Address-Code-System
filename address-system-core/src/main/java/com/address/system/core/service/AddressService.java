package com.address.system.core.service;

import com.address.system.core.dto.address.request.AddAddressReqDTO;
import com.address.system.core.dto.address.request.DeleteAddressByAllFullAddrIdReqDTO;
import com.address.system.core.dto.address.request.UpdateAddressReqDTO;
import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.entity.address.AddressESEntity;

import java.util.List;

public interface AddressService {
    BaseRespDTO putMapping();

    BaseRespDTO addAddress(AddAddressReqDTO reqDto);

    BaseRespDTO updateAddress(UpdateAddressReqDTO reqDto);

    List<AddressESEntity> find(AddressESEntity addressESEntity, int pageIndex, int pageSize);

    List<AddressESEntity> findWithFuzzy(AddressESEntity addressESEntity,int pageIndex, int pageSize,String preTag,String postTag);

    BaseRespDTO deleteAddressBySystemId(DeleteAddressByAllFullAddrIdReqDTO reqDTO);
}
