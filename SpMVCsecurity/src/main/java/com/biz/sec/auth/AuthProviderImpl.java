package com.biz.sec.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.biz.sec.controller.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * Spring security의 authentication-manager 에서 사용할
 * authentication-provider 클래스 Customizing 수행하기
 */
@Slf4j
public class AuthProviderImpl implements AuthenticationProvider 
{

	// spring security를 통하여 login을 수행했을때 호출되는 method
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException 
	{
		// 사용자 ID를 추출하기
		// String userName = authentication.getPrincipal().toString(); 
		// String userName = (String) authentication.getPrincipal();
		String userName = authentication.getName();
		boolean bUser = userName.equals("admin");
		bUser |= userName.equals("user");
		bUser |= userName.equals("guest");
		
		// 사용자 ID 검사
		if(bUser == false)
		{
			String msg = String.format("[%s] 사용자 아이디를 확인하세요", userName);
			/* 
			 * throw new Exception(message) 
			 * throw : 강제로 exception을 발생시켜라
			 * 
			 * Spring security login이 진행되는 도중에
			 * 어떤 문제가 발생을 하면
			 * 메시지를 만들고 강제로 exception을 발생시키면
			 * spring security에게 메시지를 전달하는 효과가 나탄다.
			 * 
			 * authenticate() method는 실행을 멈추고 spring security가 메시지를 수신하여 다시 login 화면을 열고 메시지를 보여준다.
			 */
			// throw new InternalAuthenticationServiceException(msg);
			throw new UsernameNotFoundException(msg);
		}
		
		// 로그인 클라이언트 비밀번호 추출하기
		String password = authentication.getCredentials().toString();
		if(password.equals("1234") == false)
		{
			throw new BadCredentialsException("비밀번호를 확인해 주세요");
		}
		
		UserVO userVO = new UserVO();
		log.debug(userVO.toString());
		
		
		if(userVO.isEnabled() == false)
			{ throw new DisabledException("사용자 정보를 사용할수 없습니다"); }
		
		
		if(userVO.isAccountNonExpired() == false)
			{ throw new LockedException("사용자 계정이 잠겨 있습니다 관리자에게 문의하세요"); }
		
		
		if(userVO.isAccountNonExpired() == false)
			{ throw new AccountExpiredException("사용자 계정이 만료되었습니다."); } 

		if(userVO.isCredentialsNonExpired() == false)
			{ throw new CredentialsExpiredException("사용자 계정의 권한이 없습니다."); }
		
		
		// ROLE 정보 테스트 값 생성
		// 사용자 ID에 부여된 ROLE List를 만들어서 추가하고
		// JSP 등에서 사용해 보자
		List<GrantedAuthority> authList = new ArrayList<>();
		
		if(userName.equals("admin") == true)
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		if(userName.equals("user") == true)
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		if(userName.equals("guest") == true)
			authList.add(new SimpleGrantedAuthority("ROLE_GUEST"));
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(new UserVO(), null, authList);
		return token;
	}
	
	// 현재 만들어진 AuthProviderImpl을 spring security에서 사용가능하도록 설정
	// return 값을 true로 하여 사용가능한 상태로 전환
	@Override
	public boolean supports(Class<?> authentication) 
	{
		return true;
	}
	
}
       