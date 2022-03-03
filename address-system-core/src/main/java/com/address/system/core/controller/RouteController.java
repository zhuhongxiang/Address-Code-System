package com.address.system.core.controller;


import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.dto.route.request.FindByPostmanIdDTO;
import com.address.system.core.dto.route.response.FindAllRespDTO;
import com.address.system.core.dto.route.response.FindByPostmanIdRespDTO;
import com.address.system.core.dto.route.response.FindByPostmanIdSortRespDTO;
import com.address.system.core.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/route" , produces = "application/json;charset=UTF-8")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping("/init")
    public BaseRespDTO init(){
        return routeService.putMapping();
    }

    @RequestMapping("/findAll")
    public FindAllRespDTO findAllAddress( ){
      return routeService.findAll();
    }

    @RequestMapping("/findByPostmanId")
    public FindByPostmanIdRespDTO findByAllAddressByPostmanId(@RequestBody FindByPostmanIdDTO reqDTO){
        return routeService.findByPostmanId(reqDTO);
    }

    @RequestMapping("/findByPostmanIdSort")
    public FindByPostmanIdSortRespDTO findByAllAddressByPostmanIdSort(@RequestBody FindByPostmanIdDTO reqDTO){
        return routeService.findByPostmanIdSort(reqDTO);
    }

}

