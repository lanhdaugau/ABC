package com.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.spring.domain.Departs;
import com.spring.domain.Staffs;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public interface StaffService {

	<S extends Staffs> List<S> findAll(Example<S> example, Sort sort);

	<S extends Staffs> List<S> findAll(Example<S> example);

	Staffs getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Staffs> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Staffs, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Staffs entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Staffs> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Staffs> entities);

	void deleteInBatch(Iterable<Staffs> entities);

	<S extends Staffs> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Staffs> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Staffs> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Staffs> List<S> saveAll(Iterable<S> entities);

	Optional<Staffs> findById(Long id);

	List<Staffs> findAllById(Iterable<Long> ids);

	List<Staffs> findAll(Sort sort);

	Page<Staffs> findAll(Pageable pageable);

	List<Staffs> findAll();

	<S extends Staffs> Optional<S> findOne(Example<S> example);

	<S extends Staffs> S save(S entity);

	List<Staffs> findByFullNameContaining(String fullName);

	long count();

	<S extends Staffs> long count(Example<S> example);

	List<Departs> fillAllDeparts();




	
	

	
}
