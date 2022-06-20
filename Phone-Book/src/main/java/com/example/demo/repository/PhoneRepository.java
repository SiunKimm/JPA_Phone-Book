package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BaseTimeEntity;
import com.example.demo.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

	List<Phone> findById(long telSeq);

	List<Phone> findByTelType(String telType);

	List<Phone> findByTelNo1(String telNo1);

	List<Phone> findByTelNo2(String telNo2);

	List<Phone> findByTelNo3(String telNo3);

	List<BaseTimeEntity> findByRegDtm(LocalDateTime regDtm);

	List<BaseTimeEntity> findByModDtm(LocalDateTime modDtm);
	
	Page<Phone> findByTelNo3(String telNo3, PageRequest pageRequest);

}
