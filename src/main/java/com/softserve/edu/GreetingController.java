package com.softserve.edu;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	//@RequestMapping(value="/greeting", method=RequestMethod.GET)
	//@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World")
			String name) {
		// Call classes from service layer
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}

	//@RequestMapping("/")
	public String greeting() {
		// Call classes from service layer
		return "redirect:/greeting";
	}

}

