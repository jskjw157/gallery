package org.johnny.gallery.backend.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.johnny.gallery.backend.entity.Member;
import org.johnny.gallery.backend.repository.MemberRepository;
import org.johnny.gallery.backend.service.JwtService;
import org.johnny.gallery.backend.service.JwtServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountController {
	
	
	private final MemberRepository memberRepository;
	
	@PostMapping("/api/account/login")
	public ResponseEntity login(@RequestBody Map<String, String> params,
								HttpServletResponse res) {
		Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
		
		if(member != null) {
			JwtService jwtService = new JwtServiceImpl();
			int id =  member.getId();
			String token = jwtService.getToken("id", id);
			
			//클라이언트가(쿠키,세션스토리지) 아닌 서버사이드 쿠키에 저장.
			Cookie cokie = new Cookie("token", token);
			cokie.setHttpOnly(true); // js로 접근할수 없게 설정.
			cokie.setPath("/");
			
			res.addCookie(cokie);
			return new ResponseEntity<>(id, HttpStatus.OK);
			
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
