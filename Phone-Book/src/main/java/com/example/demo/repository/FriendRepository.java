package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BaseTimeEntity;
import com.example.demo.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {

	List<Friend> findById(long frndSeq);

	List<Friend> findByFrndNm(String frndNm);

	List<BaseTimeEntity> findByRegDtm(LocalDateTime regDtm);

	List<BaseTimeEntity> findByModDtm(LocalDateTime modDtm);
	
	// frndNm 필드에 매개변수 frndNm 의 값이 포함되어 있는 엔티티를 조회하는 메서드
	Page<Friend> findByFrndNmContainsIgnoreCase(String frndNm, PageRequest pageRequest);
	
	// 3번재 번호가 동일한 엔티티 조회
	Page<Friend> findByPhonesTelNo3(String telNo3, PageRequest pageRequest);

}
