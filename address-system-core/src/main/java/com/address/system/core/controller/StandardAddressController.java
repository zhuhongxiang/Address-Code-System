package com.address.system.core.controller;

import com.address.system.core.dto.address.request.*;
import com.address.system.core.dto.address.response.FindAddressRespDTO;
import com.address.system.core.dto.address.response.FindByAllFullAddrRespDTO;
import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.dto.standardAddress.request.*;
import com.address.system.core.dto.standardAddress.response.FindByAddrCodeOrNameRespDTO;
import com.address.system.core.entity.address.AddressESEntity;
import com.address.system.core.entity.standardAddress.StandardAddressESEntity;
import com.address.system.core.service.AddressService;
import com.address.system.core.service.StandardAddressService;
import com.address.system.core.utils.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standardAddress")
public class StandardAddressController {
    @Autowired
    private StandardAddressService standardAddressService;

    @RequestMapping("/init")
    public BaseRespDTO init(){
        return standardAddressService.putMapping();
    }

    /*
    根据地址或编码模糊查询
     */
    @RequestMapping("/findByAddrCodeOrName")
    public FindByAddrCodeOrNameRespDTO findByAddrCodeOrName(@RequestBody FindByAddrCodeOrNameReqDTO reqDTO){
        FindByAddrCodeOrNameRespDTO respDTO = new FindByAddrCodeOrNameRespDTO();
        StandardAddressESEntity reqEntity = new StandardAddressESEntity();
        reqEntity.setFullAddress(reqDTO.getSearchText());
        reqEntity.setFullAddressCode(reqDTO.getSearchText());
        try{
            respDTO.setFoundEntites(standardAddressService.findWithFuzzy(reqEntity,reqDTO.getPageIndex()
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
    根据编码查询
    支持模糊搜索
     */
    @RequestMapping("/findByAddrCode")
    public FindByAddrCodeOrNameRespDTO findByAddrCode(@RequestBody FindByAllFullAddrIdReqDTO reqDTO){
        FindByAddrCodeOrNameRespDTO respDTO = new FindByAddrCodeOrNameRespDTO();
        StandardAddressESEntity reqEntity = new StandardAddressESEntity();
        reqEntity.setFullAddressCode(reqDTO.getAllFullAddrId());
        try {
            respDTO.setFoundEntites(standardAddressService.findWithFuzzy(reqEntity, reqDTO.getPageIndex()
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
    public FindByAddrCodeOrNameRespDTO findByAllFullAddr(@RequestBody FindByAllFullAddrReqDTO reqDTO){
        StandardAddressESEntity reqEntity = new StandardAddressESEntity();
        reqEntity.setFullAddress(reqDTO.getAllFullAddr());
        FindByAddrCodeOrNameRespDTO respDTO = new FindByAddrCodeOrNameRespDTO();
        try {
            respDTO.setFoundEntites(standardAddressService.findWithFuzzy(reqEntity, reqDTO.getPageIndex()
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
    多字段联合查询
    没有模糊搜索
     */
    @RequestMapping("/find")
    public FindByAddrCodeOrNameRespDTO find(@RequestBody FindStandardAddressReqDTO reqDTO){
        FindByAddrCodeOrNameRespDTO respDTO = new FindByAddrCodeOrNameRespDTO();
        StandardAddressESEntity reqEntity = new StandardAddressESEntity();
        CopyUtils.copyProperties(reqDTO, reqEntity);
        try {
            respDTO.setFoundEntites(standardAddressService.find(reqEntity, reqDTO.getPageIndex(), reqDTO.getPageSize()));
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

    @RequestMapping("/addAddress")
    public BaseRespDTO addAddress(@RequestBody AddStandardAddressReqDTO reqDto){
        return standardAddressService.addAddress(reqDto);
    }

    @RequestMapping("/updateAddress")
    public BaseRespDTO updateAddress(@RequestBody UpdateStandardAddressReqDTO reqDto){
        return standardAddressService.updateAddress(reqDto);
    }

    @RequestMapping("/deleteAddressByFullAddrCode")
    public BaseRespDTO deleteAddressByAllFullAddrId(@RequestBody DeleteAddressByFullAddrCodeReqDTO reqDto){
        return standardAddressService.deleteAddressBySystemId(reqDto);
    }
}
