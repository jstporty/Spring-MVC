package kr.kwangan2.mvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("exception" + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";  //http://localhost:8080/test/personDTO?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=..
	}
}
