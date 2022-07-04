package com.spring.service.impl;

import java.util.List;
import java.util.Optional;

import com.spring.domain.Records;
import com.spring.repository.RecordRepository;
import com.spring.service.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecordServiceImpl implements RecordService{
	@Autowired
	RecordRepository recordRepository;

	
	@Override
	public Records save(Records entity) {
		return recordRepository.save(entity);
	}

	@Override
	public List<Records> saveAll(List<Records>  entities) {
		return (List<Records>) recordRepository.saveAll(entities);
	}


	@Override
	public Optional<Records> findById(Integer id) {
		return recordRepository.findById(id);
	}

	
	@Override
	public boolean existsById(Integer id) {
		return recordRepository.existsById(id);
	}

	
	@Override
	public List<Records>  findAll() {
		return (List<Records>) recordRepository.findAll();
	}

	
	@Override
	public Iterable<Records> findAllById(Iterable<Integer> ids) {
		return recordRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return recordRepository.count();
	}


	@Override
	public void deleteById(Integer id) {
		recordRepository.deleteById(id);
	}


	@Override
	public void delete(Records entity) {
		recordRepository.delete(entity);
	}

	
	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		recordRepository.deleteAllById(ids);
	}

	
	@Override
	public void deleteAll(Iterable<? extends Records> entities) {
		recordRepository.deleteAll(entities);
	}

	
	@Override
	public void deleteAll() {
		recordRepository.deleteAll();
	}
	
	
	
}
