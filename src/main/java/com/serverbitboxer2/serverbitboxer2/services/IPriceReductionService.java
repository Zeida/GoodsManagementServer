package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.dto.PriceReductionDTO;

import java.util.List;

public interface IPriceReductionService {
    PriceReductionDTO findByPricereductioncode(Long priceReductionCode);

    List<PriceReductionDTO> findAll();

    void createPriceReduction(PriceReductionDTO priceReductionDTO);

    void deletePriceReduction(Long priceReductionCode);


}
