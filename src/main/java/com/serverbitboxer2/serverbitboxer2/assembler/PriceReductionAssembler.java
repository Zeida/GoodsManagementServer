package com.serverbitboxer2.serverbitboxer2.assembler;

import com.serverbitboxer2.serverbitboxer2.dto.PriceReductionDTO;
import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceReductionAssembler {

    private ModelMapper modelMapper = new ModelMapper();

    public PriceReductionDTO entity2DTO(PriceReduction priceReduction){
        return modelMapper.map(priceReduction, PriceReductionDTO.class);
    }

    public PriceReduction DTO2Entity(PriceReductionDTO priceReductionDTO){
        return modelMapper.map(priceReductionDTO, PriceReduction.class);
    }

}
