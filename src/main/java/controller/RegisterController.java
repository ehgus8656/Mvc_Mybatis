package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping(value="/register/step1",
			method= {RequestMethod.POST,RequestMethod.GET})
	public String handleStep1() {
		return "register/step1";
	}
	
	// 1번 방법
//	@RequestMapping(value="/register/step2",
//			method=RequestMethod.POST)
//	public String handleStep2(HttpServletRequest request) {
//		String agreePaeram = request.getParameter("agree");
//		if(agreePaeram == null || !agreePaeram.equals("true")) {
//			return "register/step1";
//		}
//		return "register/step2";
//	}
	
	//2번 방법
	@RequestMapping(value="/register/step2",
			method= {RequestMethod.POST,RequestMethod.GET})
	public String handleStep2(@RequestParam(value="agree", defaultValue = "false")Boolean agree, Model model) {
		if(!agree) {
			return "register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());
		return "register/step2";
	}
	
//	@RequestMapping(value="/register/step3",
//			method=RequestMethod.POST)
//	public String handleStep3(HttpServletRequest request) {
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String confirmPassword = request.getParameter("confirmp");
//		RegisterRequest regReq = new RegisterRequest();
//		regReq.setEmail(email);
//		regReq.setName(name);
//		regReq.setPassword(password);
//		regReq.setConfirmPassword(confirmPassword);
//		return "register/step3";
//	}
	@RequestMapping(value="/register/step3",
			method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			return "register/step2";
		}
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch (AlreadyExistingMemberException e){
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
}
