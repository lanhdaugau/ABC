package com.spring.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.spring.domain.Departs;
import com.spring.domain.Staffs;
import com.spring.repository.DepartRepository;
import com.spring.repository.StaffRepository;
import com.spring.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService{
	
	StaffRepository staffRepository;
	
	public StaffServiceImpl(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	} 
	
	@Autowired
	DepartRepository departRepository;
	 
	@Override
	public List<Departs> fillAllDeparts(){
		return (List<Departs>) departRepository.findAll();
	}
	@Override
	public List<Staffs> findByFullNameContaining(String fullName) {
		return staffRepository.findByFullNameContaining(fullName);
	}


	
	@Override
	public <S extends Staffs> S save(S entity) {
		return staffRepository.save(entity);
	}

	@Override
	public <S extends Staffs> Optional<S> findOne(Example<S> example) {
		return staffRepository.findOne(example);
	}

	@Override
	public List<Staffs> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public Page<Staffs> findAll(Pageable pageable) {
		return staffRepository.findAll(pageable);
	}

	@Override
	public List<Staffs> findAll(Sort sort) {
		return staffRepository.findAll(sort);
	}

	@Override
	public List<Staffs> findAllById(Iterable<Long> ids) {
		return staffRepository.findAllById(ids);
	}

	@Override
	public Optional<Staffs> findById(Long id) {
		return staffRepository.findById(id);
	}

	@Override
	public <S extends Staffs> List<S> saveAll(Iterable<S> entities) {
		return staffRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		staffRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return staffRepository.existsById(id);
	}

	@Override
	public <S extends Staffs> S saveAndFlush(S entity) {
		return staffRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Staffs> List<S> saveAllAndFlush(Iterable<S> entities) {
		return staffRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Staffs> Page<S> findAll(Example<S> example, Pageable pageable) {
		return staffRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Staffs> entities) {
		staffRepository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Staffs> entities) {
		staffRepository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Staffs> boolean exists(Example<S> example) {
		return staffRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		staffRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Staffs entity) {
		staffRepository.delete(entity);
	}

	@Override
	public <S extends Staffs, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return staffRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		staffRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		staffRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends Staffs> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}

	@Override
	public Staffs getById(Long id) {
		return staffRepository.getById(id);
	}

	@Override
	public <S extends Staffs> List<S> findAll(Example<S> example) {
		return staffRepository.findAll(example);
	}

	@Override
	public <S extends Staffs> List<S> findAll(Example<S> example, Sort sort) {
		return staffRepository.findAll(example, sort);
	}


	@Override
	public <S extends Staffs> long count(Example<S> example) {
		return staffRepository.count(example);
	}


	@Override
	public long count() {
		return staffRepository.count();
	}
	
	
		
	
}
