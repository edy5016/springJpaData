package com.study.jpa.data.repository;

import org.springframework.stereotype.Repository;

import com.study.jpa.data.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberJpaRepository {
	@PersistenceContext
	private EntityManager em;

	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	public Member find(Long id) {
		return em.find(Member.class, id);
	}
}
