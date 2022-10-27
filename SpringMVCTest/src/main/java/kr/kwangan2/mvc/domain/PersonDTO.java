package kr.kwangan2.mvc.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data // 얘 있으면 bean이라는 뜻~
public class PersonDTO {

	private String name;
	private int age;
	private ArrayList<PersonDTO> personDTOList;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	public PersonDTO() {
		this.personDTOList = new ArrayList<PersonDTO>();
	}

}
