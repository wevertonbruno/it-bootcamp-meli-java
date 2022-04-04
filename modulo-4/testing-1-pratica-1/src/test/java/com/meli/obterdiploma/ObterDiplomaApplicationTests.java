package com.meli.obterdiploma;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.service.IObterDiplomaService;
import com.meli.obterdiploma.service.ObterDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
class ObterDiplomaApplicationTests {

	@Mock
	private IObterDiplomaService obterDiplomaService;

	@Test
	@Tag("service")
	public void shouldReturnsAverage() {
		//setup
		SubjectDTO subject1 = new SubjectDTO();
		subject1.setName("Fisica");
		subject1.setScore(7.0);

		SubjectDTO subject2 = new SubjectDTO();
		subject2.setName("Matematica");
		subject2.setScore(9.0);

		List<SubjectDTO> subjectDTOS = new ArrayList<>();
		subjectDTOS.addAll(Arrays.asList(subject1, subject2));

		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Weverton");
		studentDTO.setSubjects(subjectDTOS);

		StudentDTO responseMock = new StudentDTO();
		responseMock.setStudentName("Weverton");
		responseMock.setSubjects(subjectDTOS);
		responseMock.setAverageScore(7.0);

		Mockito.when(obterDiplomaService.analyzeScores(Mockito.any(StudentDTO.class))).thenReturn(responseMock);

		//act
		StudentDTO response = obterDiplomaService.analyzeScores(studentDTO);

		//asssert
		Assertions.assertTrue(response.getAverageScore().equals(7.0));
	}
}