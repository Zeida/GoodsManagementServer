package com.serverbitboxer2.serverbitboxer2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverbitboxer2.serverbitboxer2.dto.PriceReductionDTO;
import com.serverbitboxer2.serverbitboxer2.services.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceReductionController {
    @Autowired
    private PriceReductionService priceReductionService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/pricereduction/{pricereductioncode}")
    public PriceReductionDTO findByPricereductioncode(@PathVariable(name = "pricereductioncode") String priceReductionCode) {
        PriceReductionDTO priceReductionDTO = priceReductionService.findByPricereductioncode(priceReductionCode);
        if (priceReductionDTO == null) {
            throw new RuntimeException("The Price Reduction with code: " + priceReductionCode + " does not exist");

        }
        return priceReductionDTO;
    }

    @GetMapping("/pricereductions")
    public List<PriceReductionDTO> findAll() {
        return priceReductionService.findAll();
    }

    @PostMapping(value = "/pricereduction/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createPriceReduction(@RequestBody String priceReduction) throws JsonProcessingException {
        PriceReductionDTO priceReductionDTO = objectMapper.readValue(priceReduction, PriceReductionDTO.class);
        priceReductionService.createPriceReduction(priceReductionDTO);
    }

    @DeleteMapping("pricereduction/{pricereductioncode}/delete")
    public void deletePriceReduction(@PathVariable(name = "pricereductioncode") String priceReductionCode) {
        PriceReductionDTO priceReductionDTO = priceReductionService.findByPricereductioncode(priceReductionCode);
        if (priceReductionDTO == null) {
            throw new RuntimeException("The Price Reduction with code: " + priceReductionCode + " does not exist");
        }
        priceReductionService.deletePriceReduction(priceReductionCode);
    }
}
