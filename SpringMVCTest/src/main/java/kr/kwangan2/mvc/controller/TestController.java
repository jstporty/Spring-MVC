package kr.kwangan2.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kwangan2.mvc.domain.PersonDTO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/test/*", method = { RequestMethod.GET, RequestMethod.POST }) // localhost:8080/test/
@Log4j
public class TestController {

	@RequestMapping(value = "/test1", method = { RequestMethod.GET }) // get 요청 8080/test/test1
	public void test1() {

		log.info("testGet() 호출!");
	}

	@RequestMapping(value = "/test2", method = { RequestMethod.POST }) // poet 요청8080/test/test2
	public void test2() {
		log.info("testPost() 호출!"); // http://localhost:8080/test/test2

	}

	@RequestMapping(value = "/personParam")
	public void testPersonDTO(@RequestParam("name") String n, @RequestParam("age") int a) {
		log.info(n + ":" + a);
	}

	@RequestMapping(value = "/personDTO")
	public void testPersonDTO(PersonDTO personDTO) {
		log.info(personDTO);
	}

	@RequestMapping(value = "/fileupload")
	public void testFileUpload(@RequestParam("uploadFile") ArrayList<String> listUploadFiles) {
		log.info(listUploadFiles); // http://localhost:8080/fileupload/fileuploadForm

	}

	@RequestMapping(value = "/personDTOList")
	public void testPersonDTOList(PersonDTO personDTO) {
		log.info(personDTO);
		// localhost:8080/test/personDTOList?personDTOList%5B0%5D.name=hwan&personDTOList%5B1%5D.name=seok
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/initBinder")
	public void binder(PersonDTO personDTO) {
		log.info(personDTO); // http://localhost:8080/test/initBinder?birth=2022-10-27
	}

	@GetMapping("/getModelInfo")
	public String getModelInfo(Model model, @ModelAttribute("addr") String addr) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 20);
		log.info(addr);
		return "getModelInfo"; // http://localhost:8080/test/getModelInfo?addr=온천장
	}

	@GetMapping("/getInfo")
	public String getInfo(Model model, String name, int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "redirect:/";
	} // http://localhost:8080/test/getInfo?name=여승현&age=20

	@GetMapping("/getJson")
	public @ResponseBody PersonDTO getJson() {
		log.info("sss");
		PersonDTO personDTO1 = new PersonDTO();
		personDTO1.setAge(1);
		personDTO1.setName("여");
		personDTO1.setBirth(new Date());

		PersonDTO personDTO2 = new PersonDTO();
		personDTO2.setAge(2);
		personDTO2.setName("승");
		personDTO2.setBirth(new Date());

		PersonDTO personDTO3 = new PersonDTO();
		personDTO3.setAge(3);
		personDTO3.setName("현");
		personDTO3.setBirth(new Date());
		ArrayList<PersonDTO> personDTOList = new ArrayList<PersonDTO>();
		personDTOList.add(personDTO1);
		personDTOList.add(personDTO2);
		personDTO3.setPersonDTOList(personDTOList);

		return personDTO3; // http://localhost:8080/test/getJson
	}

	@GetMapping("modelAndView")
	public ModelAndView modelAndView(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 20);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAndView");
		// mav.setstatus(HttpStatus.OK);
		return mav; // http://localhost:8080/test/modelAndView
	}

	@GetMapping("/realUploadForm")
	public String realUploadForm() {
		return "realUploadForm";

	}

	@PostMapping("/realfileupload")
	public void realfileupload(ArrayList<MultipartFile> uploadFile) {
		uploadFile.forEach(file -> {
			log.info("업로드할때의 파일명:	" + file.getOriginalFilename());
			log.info("업로드할때의 파일크기:	" + file.getSize());  //http://localhost:8080/test/realfileupload
		});
	}
	
	

}


















