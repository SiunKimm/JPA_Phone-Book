package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BaseTimeEntity {
	
	// 생성 시간
	@CreatedDate
	private LocalDateTime regDtm;
	
	// 마지막 수정 시간
	@LastModifiedDate
	private LocalDateTime modDtm;

	protected BaseTimeEntity() {
	}

	public BaseTimeEntity(LocalDateTime regDtm, LocalDateTime modDtm) {
		this.regDtm = regDtm;
		this.modDtm = modDtm;
	}
	
	// 시간 포멧에 항상 T 문자가 붙어서 T 를 삭제 시키는 포멧팅 메서드 ex) 2022-06-07 T 12:00:12
	public String getRegDtmString() {
		if (regDtm != null) {
			return regDtm.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return "";
	}

	// 시간 포멧에 항상 T 문자가 붙어서 T 를 삭제 시키는 포멧팅 메서드 ex) 2022-06-07 T 12:00:12
	public String getModDtmString() {
		if (modDtm != null) {
			return modDtm.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return "";
	}
}