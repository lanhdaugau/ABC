package com.spring.repository;

import com.spring.domain.Departs;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartRepository extends CrudRepository<Departs, String>{
	
}
