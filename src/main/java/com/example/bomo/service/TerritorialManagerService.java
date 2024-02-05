package com.example.bomo.service;

import com.example.bomo.model.TerritorialManager;
import com.example.bomo.repo.TerritorialManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class TerritorialManagerService {

    private final TerritorialManagerRepository territorialManagerRepository;


    public TerritorialManagerService(
            TerritorialManagerRepository territorialManagerRepository) {
        this.territorialManagerRepository = territorialManagerRepository;

    }


    @Transactional
    public List<TerritorialManager> getAllTerritorialManagers() {
        return territorialManagerRepository.findAll();
    }

    @Transactional
    public Optional<TerritorialManager> getTerritorialManagerById(Long id) {
        return territorialManagerRepository.findById(id);
    }

    @Transactional
    public void saveTerritorialManager(TerritorialManager territorialManager) {
        territorialManagerRepository.save(territorialManager);
    }


    @Transactional
    public void deleteTerritorialManagerById(Long id) {
        territorialManagerRepository.deleteById(id);
    }


}
