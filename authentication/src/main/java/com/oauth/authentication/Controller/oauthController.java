package com.oauth.authentication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class oauthController {
	
//	http://localhost:8070/regUserList
	@RequestMapping("/regUserList")
	public String viewHomePage() {
		return "products.html";
	}
}
