package com.spring.repository;


import com.spring.domain.Records;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Records, Integer> {

}
