package com.spring.repository;

import java.util.List;

import com.spring.domain.Staffs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface StaffRepository extends JpaRepository<Staffs, Long>{
	List<Staffs> findByFullNameContaining(String fullName);
	
	Long countByDepartsId(String departId);
	
	Long countByGender(boolean gender);
	
	
}
