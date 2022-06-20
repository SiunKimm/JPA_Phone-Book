package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_friend")
/*
 * @SequenceGenerator(name = "SQ_FRIEND_FRND_SEQ", sequenceName =
 * "SQ_FRIEND_FRND_SEQ", allocationSize = 1)
 */
// setter 메서드 사용 지양 - 변경되지 않는 인스턴스에 대해서도 setter로 접근이 가능하기 때문에
// 불변하지 않다는 것 -> Constructor 또는 Builder
@Getter
@Setter
@NoArgsConstructor
public class Friend extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* SEQUENCE, generator = "SQ_FRIEND_FRND_SEQ") */
	private long frndSeq;
	
	// 외래키가 걸린 데이터를 삭제하기 위하여 Phone Entity 포함시킴, Cascade 설정 = 영속성 전이 옵션, orphan = 자식 엔티티 제거
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "friend", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Phone> phones;

	@Column(name = "frnd_nm")
	private String frndNm;
	
	@Builder
	public Friend(String frndNm) {
		this.frndNm = frndNm;
	}
	
}

	// 롬복 사용시 Constructor, Argument 사용 주의

	// @Formula("(select count(*) from tb_phone where frnd_seq = frnd_seq)") private
	
