package com.example.demo.dto;

import com.example.demo.entity.BaseTimeEntity;

import lombok.Data;

@Data
// @NoArgsConstructor
public class FriendDTO extends BaseTimeEntity {
	
	private long frndSeq;
	private String frndNm;
	
	public FriendDTO() {}
	
	public FriendDTO(long frndSeq, String frndNm) {
		this.frndSeq = frndSeq;
		this.frndNm = frndNm;
	}
	
	public long getfrndSeq() {
		return frndSeq;
	}
	public void setfrndSeq(long frndSeq) {
		this.frndSeq = frndSeq;
	}
	public String getFrndNm() {
		return frndNm;
	}
	public void setFrndNm(String frndNm) {
		this.frndNm = frndNm;
	}
	
	/*
	public LocalDateTime getregDtm() {
		return regDtm;
	}
	public void setregDtm(LocalDateTime regDtm) {
		this.regDtm = regDtm;
	}
	
	public LocalDateTime getmodDtm() {
		return modDtm;
	}
	public void setmodDtm(LocalDateTime modDtm) {
		this.modDtm = modDtm;
	}
	*/
	
	}
