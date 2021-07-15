package com.max.psicologia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.max.psicologia.entity.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {

}
