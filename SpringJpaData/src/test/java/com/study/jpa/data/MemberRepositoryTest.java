package com.study.jpa.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.study.jpa.data.entity.Member;
import com.study.jpa.data.repository.MemberRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public class MemberRepositoryTest {
	
	@Autowired 
	MemberRepository memberRepository;
	
	@Test
	public void testMember() {
		Member member = new Member("memberA");
		Member saveMember = memberRepository.save(member);
		
		Member findMember = memberRepository.findById(saveMember.getId()).get();
		
		 assertThat(findMember.getId()).isEqualTo(member.getId());
		 assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		 assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
	}
}
