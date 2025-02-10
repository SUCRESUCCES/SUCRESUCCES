package kh.springboot.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.springboot.member.model.vo.Member;
import lombok.extern.slf4j.Slf4j;
@Slf4j
// 파일의 저장된 로그를 분리하기 위해 만들어진 
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser != null && loginUser.getIsAdmin().equals("N")) {
			log.debug(loginUser.getId());
		}
	}
	}

