package com.example.bomo.repo;

import com.example.bomo.model.TerritorialManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerritorialManagerRepository extends JpaRepository<TerritorialManager, Long> {

}
