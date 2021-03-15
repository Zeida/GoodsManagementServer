package com.serverbitboxer2.serverbitboxer2.assembler;

import com.serverbitboxer2.serverbitboxer2.dto.ItemDTO;
import com.serverbitboxer2.serverbitboxer2.entities.Item;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemAssembler {
    private ModelMapper modelMapper = new ModelMapper();

    public ItemDTO entity2DTO(Item item) {
        ItemDTO itemDTO= modelMapper.map(item, ItemDTO.class);
        return itemDTO;
    }

    public Item DTO2Entity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);

    }

}
