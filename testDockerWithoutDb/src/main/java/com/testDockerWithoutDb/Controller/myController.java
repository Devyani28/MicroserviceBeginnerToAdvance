package com.testDockerWithoutDb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseEndpoint")
public class myController {
	
	@GetMapping
	public String displayAll() {
		return "displaying all";
	}

}
