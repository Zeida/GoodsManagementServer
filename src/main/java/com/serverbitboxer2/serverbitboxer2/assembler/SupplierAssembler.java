package com.serverbitboxer2.serverbitboxer2.assembler;

import com.serverbitboxer2.serverbitboxer2.dto.SupplierDTO;
import com.serverbitboxer2.serverbitboxer2.entities.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierAssembler {
    private ModelMapper modelMapper = new ModelMapper();

    private SupplierDTO entity2DTO(Supplier supplier){
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    private Supplier DTO2Entity(SupplierDTO supplierDTO){
        return modelMapper.map(supplierDTO, Supplier.class);
    }

}
