package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_phone")
/*
 * @SequenceGenerator(name = "SQ_PHONE_TEL_SEQ", sequenceName=
 * "SQ_PHONE_TEL_SEQ", allocationSize = 1)
 */
@Getter
@Setter
public class Phone extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* SEQUENCE, generator = "SQ_FRIEND_FRND_SEQ") */
	private long telSeq;
	
	// ManyToOne 관계를 통하여 frnd_seq 로 외래키를 지정
	@ManyToOne
	@JoinColumn(name = "frnd_seq")
	private Friend friend;

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	@Column(name = "tel_type")
	private String telType;

	@Column(name = "tel_no_1")
	private String telNo1;

	@Column(name = "tel_no_2")
	private String telNo2;

	@Column(name = "tel_no_3")
	private String telNo3;

	public Phone() {
	}

	public Phone(String telType, String telNo1, String telNo2, String telNo3) {
		this.telType = telType;
		this.telNo1 = telNo1;
		this.telNo2 = telNo2;
		this.telNo3 = telNo3;
	}

}
