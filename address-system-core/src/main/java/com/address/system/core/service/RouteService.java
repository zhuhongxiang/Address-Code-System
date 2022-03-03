package com.address.system.core.service;

import com.address.system.core.dto.base.BaseRespDTO;
import com.address.system.core.dto.route.request.FindByPostmanIdDTO;
import com.address.system.core.dto.route.response.FindAllRespDTO;
import com.address.system.core.dto.route.response.FindByPostmanIdRespDTO;
import com.address.system.core.dto.route.response.FindByPostmanIdSortRespDTO;

import java.util.List;

public interface RouteService {
    BaseRespDTO putMapping();
    FindAllRespDTO findAll();
    FindByPostmanIdRespDTO findByPostmanId(FindByPostmanIdDTO postmanId);
    FindByPostmanIdSortRespDTO findByPostmanIdSort(FindByPostmanIdDTO postmanIdDTO);
}
