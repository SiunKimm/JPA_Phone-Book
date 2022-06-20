package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import com.example.demo.dto.FriendDTO;


@org.springframework.stereotype.Service
public class FriendService {
	@PersistenceUnit
	EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;
	
	// DTO 사용 ( new 명령어 )
	public static void FriendDTO (EntityManager em) {
		String jpql = "SELECT new com.example.demo.dto.FriendDTO(b.frndSeq, b.frndNm) FROM Friend b";
		TypedQuery<FriendDTO> query = em.createQuery(jpql, FriendDTO.class);
		List<FriendDTO> list = query.getResultList();
		for( FriendDTO dto : list) {
			System.out.println(dto.getfrndSeq());
		}
	}
}
	
/*	public void Query() {

		String jpql = "SELECT m.frndSeq, m.frndNm FROM Friend m";
		Query query = em.createQuery(jpql);

		List<FriendDTO> list = query.getResultList();
		for( Object friend : list ) {
		      Object[] results = (Object[]) friend;
		      
		      for( Object result : results ) {
		          System.out.print ( result );
		     }
		     System.out.println();
		}
	}
}*/

//List<Friend> friendList = query.getResultList();
//for (Friend friend : friendList) {
//	System.out.println(friend.getFrndSeq());
//	System.out.println(friend.getFrndNm());
//	System.out.println(friend.getRegDtmString());
//	System.out.println(friend.getModDtmString());