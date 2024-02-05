package com.example.bomo.repo;

import com.example.bomo.model.RegionalDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegionalDirectorRepository extends JpaRepository<RegionalDirector, Long> {

}
