package com.biz.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biz.hello.service.HelloService;
import com.biz.hello.service.HelloServiceimpl;
import com.biz.hello.service.ScoreService;

/*
 *  @RestController
 *  SpingFrameWork 4.x 이상에서 지원되는 새로운 Controller
 *  
 *  @Autowired
 *  SpringFramework 프로젝트에서 @Annotation으로 설정된 클래스들을 객체로 생성한
 *  컨테이너가 있으며
 *  
 *  컨테이너에 저장된 객체를 찾아서 선언된 객체에 주입하여 초기화, 사용할수 있도록 만들어준다.
 *  객체를 생성하기 위해서 생성자를 만들 필요가 없어진다.
 */
@RestController
public class HelloRestController 
{
	@Autowired
	private HelloServiceimpl hServcie;
	
	@Autowired
	private ScoreService sSservice;
	
	@Autowired
	private HomeController hController;
	
	
	/*
	 * Spring 프로젝트에서는 외부의 클래스를 객체로 만들때
	 * 직접 new 생성자를 사용하여 만들지 않는다.
	 * 직접 new 생성자를 사용하여 만들지 않는다.
	 * 
	 * 프로젝트가 시작될때 @Annotation이 붙어있는 모든 클래스는 이미 객체로 생성되어
	 * Container에 저장되있다.
	 * 
	 * 다른 클래스를 객체로 생성하여 사용이 필요한 곳이 있으면
	 * container에서 객체를 꺼내서 직접 주입해 준다.
	 * 
	 * DI(Dependency Inject) : 의종성 주입, 필요한곳에 주입, 필요한곳에 가져다 주기
	 * Ioc(Inversion of Control) : 제어의 역전 이라고 한다.
	 * 
	    - Spring frameWork 에서 권장하는 생성자 -
		public HelloRestController(HelloService hService, ScoreService Sservice) 
		{	
			this.hServcie = hServcie;
			this.sSservice = sSservice;
		}
		
		- 표준 자바코드에서 사용하는 (기본) 생성자 -
		public HelloRestController() 
		{
			hServcie = new HelloServiceimpl();
			sSservice = new ScoreService();
		}
	*/
	
	@RequestMapping(value = "/rest") // localhost:8080/hello/rest 라고 요청을 하면 응답하라.
	public String rest()
	{
		return "rest";
	}
	
	@RequestMapping(value = "/null") 
	public String mNull()
	{
		return null;
	}
	
	@RequestMapping()
	public String hello()
	{
		int ret = hServcie.add(20, 40);
		return ret + "";
	}
	
	
}
