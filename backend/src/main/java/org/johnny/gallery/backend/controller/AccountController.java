package org.johnny.gallery.backend.controller;

import java.util.Map;

import org.johnny.gallery.backend.entity.Member;
import org.johnny.gallery.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@PostMapping("/api/account/login")
	public int login(@RequestBody Map<String, String> params) {
		Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
		
		if(member != null) {
			return member.getId();
		}
		
		return 0;
	}
}
