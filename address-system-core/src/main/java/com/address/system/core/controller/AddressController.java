package com.address.system.core.controller;

import com.address.system.core.dto.address.request.*;
import com.address.system.core.dto.address.response.FindAddressRespDTO;
import com.address.system.core.dto.address.response.FindByAllFullAddrIdOrAllFullAddrTextRespDTO;
import com.address.system.core.dto.address.response.FindByAllFullAddrRespDTO;
import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.entity.address.AddressESEntity;
import com.address.system.core.service.AddressService;
import com.address.system.core.utils.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /*
    根据编码查询
    支持模糊搜索
     */
    @RequestMapping("/findBySystemID")
    public FindByAllFullAddrRespDTO findByAllFullAddrId(@RequestBody FindByAllFullAddrIdReqDTO reqDTO){
        FindByAllFullAddrRespDTO respDTO = new FindByAllFullAddrRespDTO();
        AddressESEntity addressESEntity = new AddressESEntity();
        addressESEntity.setAllFullAddrId(reqDTO.getAllFullAddrId());
        try {
            respDTO.setFoundEntites(addressService.findWithFuzzy(addressESEntity, reqDTO.getPageIndex()
                , reqDTO.getPageSize(),reqDTO.getPreTag(),reqDTO.getPostTag()));
            respDTO.setCurPageIndex(reqDTO.getPageIndex());
            respDTO.setCurPageSize(reqDTO.getPageSize());
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("查询失败，错误为:" + e.getMessage());
        }
        return respDTO;
    }

    /*
    根据地址查询
    支持模糊搜索
     */
    @RequestMapping("/findByAddr")
    public FindByAllFullAddrRespDTO findByAllFullAddr(@RequestBody FindByAllFullAddrReqDTO reqDTO){
        AddressESEntity addressESEntity = new AddressESEntity();
        addressESEntity.setAllFullAddr(reqDTO.getAllFullAddr());
        FindByAllFullAddrRespDTO respDTO = new FindByAllFullAddrRespDTO();
        try {
            respDTO.setFoundEntites(addressService.findWithFuzzy(addressESEntity, reqDTO.getPageIndex()
                , reqDTO.getPageSize(),reqDTO.getPreTag(), reqDTO.getPostTag()));
            respDTO.setCurPageIndex(reqDTO.getPageIndex());
            respDTO.setCurPageSize(reqDTO.getPageSize());
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("查询失败，错误为:" + e.getMessage());
        }
        return respDTO;
    }

    /*
    根据地址或编码模糊查询
     */
    @RequestMapping("/findBySystemIdOrAddr")
    public FindByAllFullAddrIdOrAllFullAddrTextRespDTO findByAllFullAddrIdOrAllFullAddrText(@RequestBody FindByAllFullAddrIdOrAllFullAddrTextReqDTO reqDTO){
        AddressESEntity addressESEntity = new AddressESEntity();
        addressESEntity.setAllFullAddrId(reqDTO.getSearchText());
        addressESEntity.setAllFullAddr(reqDTO.getSearchText());
        FindByAllFullAddrIdOrAllFullAddrTextRespDTO respDTO = new FindByAllFullAddrIdOrAllFullAddrTextRespDTO();
        try{
            respDTO.setFoundEntites(addressService.findWithFuzzy(addressESEntity, reqDTO.getPageIndex()
                , reqDTO.getPageSize(), reqDTO.getPreTag() , reqDTO.getPostTag()));
            respDTO.setCurPageIndex(reqDTO.getPageIndex());
            respDTO.setCurPageSize(reqDTO.getPageSize());
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("查询失败，错误为:" + e.getMessage());
        }
        return respDTO;
    }


    /*
    多字段联合查询
    没有模糊搜索
     */
    @RequestMapping("/find")
    public FindAddressRespDTO find(@RequestBody FindAddressReqDTO reqDTO){
        FindAddressRespDTO respDTO = new FindAddressRespDTO();
        AddressESEntity addressESEntity = new AddressESEntity();
        CopyUtils.copyProperties(reqDTO, addressESEntity);
        try {
            respDTO.setFoundEntites(addressService.find(addressESEntity, reqDTO.getPageIndex(), reqDTO.getPageSize()));
            respDTO.setCurPageIndex(reqDTO.getPageIndex());
            respDTO.setCurPageSize(reqDTO.getPageSize());
            respDTO.setRespCode(BaseRespDTO.SUCCESS);
            respDTO.setRespMsg("success");
        }catch(Exception e){
            e.printStackTrace();
            respDTO.setRespCode(BaseRespDTO.FAIL);
            respDTO.setRespMsg("查询失败，错误为:" + e.getMessage());
        }
        return respDTO;
    }

    @RequestMapping("/init")
    public BaseRespDTO init(){
        return addressService.putMapping();
    }

    @RequestMapping("/addAddress")
    public BaseRespDTO addAddress(@RequestBody AddAddressReqDTO reqDto){
        return addressService.addAddress(reqDto);
    }

    @RequestMapping("/updateAddress")
    public BaseRespDTO updateAddress(@RequestBody UpdateAddressReqDTO reqDto){
        return addressService.updateAddress(reqDto);
    }

    @RequestMapping("/deleteAddressByAllFullAddrId")
    public BaseRespDTO deleteAddressByAllFullAddrId(@RequestBody DeleteAddressByAllFullAddrIdReqDTO reqDto){
        return addressService.deleteAddressBySystemId(reqDto);
    }
}
