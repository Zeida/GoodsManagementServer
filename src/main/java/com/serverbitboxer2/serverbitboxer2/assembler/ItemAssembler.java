package com.serverbitboxer2.serverbitboxer2.assembler;

import com.serverbitboxer2.serverbitboxer2.dto.ItemDTO;
import com.serverbitboxer2.serverbitboxer2.entities.Item;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemAssembler {
    private final ModelMapper modelMapper = new ModelMapper();

    public ItemDTO entity2DTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

    public Item DTO2Entity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }

}
