package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.assembler.PriceReductionAssembler;
import com.serverbitboxer2.serverbitboxer2.dao.PriceReductionDAO;
import com.serverbitboxer2.serverbitboxer2.dto.PriceReductionDTO;
import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;



public class PriceReductionService implements IPriceReductionService {

    @PersistenceContext
    private EntityManager entityManager;

    //Repositories
    PriceReductionDAO priceReductionDAO;

    //Assemblers
    PriceReductionAssembler priceReductionAssembler;

    @Override
    public PriceReductionDTO findPriceReductionByCode(Long priceReductionCode) {
        return priceReductionDAO.findByPricereductioncode(priceReductionCode);
    }

    @Override
    public List<PriceReductionDTO> findAll() {
        //Gestionar lista vacia
        List<PriceReduction> pricereductions = priceReductionDAO.findAll();
        List<PriceReductionDTO> priceReductionsDTO = new ArrayList<>();
        for(PriceReduction priceReducion: pricereductions){
            priceReductionsDTO.add(priceReductionAssembler.entity2DTO(priceReducion));
        }
        return priceReductionsDTO;
    }

    @Override
    public void createPriceReduction(PriceReductionDTO priceReductionDTO) {
        priceReductionDAO.save(priceReductionAssembler.DTO2Entity(priceReductionDTO));
    }

    @Override
    public void deletePriceReduction(Long priceReductionCode) {
        priceReductionDAO.deleteByPricereductioncode(priceReductionCode);

    }
}
