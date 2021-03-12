package com.serverbitboxer2.serverbitboxer2.services;

import com.serverbitboxer2.serverbitboxer2.assembler.PriceReductionAssembler;
import com.serverbitboxer2.serverbitboxer2.dao.PriceReductionDAO;
import com.serverbitboxer2.serverbitboxer2.dto.PriceReductionDTO;
import com.serverbitboxer2.serverbitboxer2.entities.PriceReduction;
import com.serverbitboxer2.serverbitboxer2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PriceReductionService implements IPriceReductionService {

    @PersistenceContext
    private EntityManager entityManager;

    //Repositories
    @Autowired
    PriceReductionDAO priceReductionDAO;

    //Assemblers
    PriceReductionAssembler priceReductionAssembler = new PriceReductionAssembler();

    @Override
    public PriceReductionDTO findByPricereductioncode(Long priceReductionCode) {
        Optional<PriceReduction> priceReduction = priceReductionDAO.findByPricereductioncode(priceReductionCode);
        if (priceReduction.isPresent()) {
            return (priceReductionAssembler.entity2DTO(priceReduction.get()));
        } else
            throw new ResourceNotFoundException("The Price Reduction with the code: " + priceReductionCode + "does not exist");

    }

    @Override
    public List<PriceReductionDTO> findAll() {
        //Gestionar lista vacia
        List<PriceReduction> pricereductions = priceReductionDAO.findAll();
        List<PriceReductionDTO> priceReductionsDTO = new ArrayList<>();
        for (PriceReduction priceReducion : pricereductions) {
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
