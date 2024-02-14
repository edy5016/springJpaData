package com.study.jpa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.data.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	

}
