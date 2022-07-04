package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.domain.Departs;
import com.spring.domain.Records;

import org.springframework.stereotype.Service;

@Service
public interface RecordService  {

	void deleteAll();

	void deleteAll(Iterable<? extends Records> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Records entity);

	void deleteById(Integer id);

	long count();

	Iterable<Records> findAllById(Iterable<Integer> ids);

	List<Records> findAll();

	boolean existsById(Integer id);

	Optional<Records> findById(Integer id);

	List<Records> saveAll(List<Records>  entities);

	Records save(Records entity);

	
	
}
