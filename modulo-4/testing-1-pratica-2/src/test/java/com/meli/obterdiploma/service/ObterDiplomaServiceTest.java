package com.meli.obterdiploma.service;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ObterDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObterDiplomaService obterDiplomaService;

    @Test
    public void itShouldReturnAverage(){
        //setup
        StudentDTO studentDTO = gerarDados(10.0, 8.0);

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //act
        StudentDTO response = obterDiplomaService.analyzeScores(1L);

        //asserts
        assertEquals(response.getAverageScore(), 9.0);
        assertEquals(response.getMessage(), "O aluno Weverton obteve uma média de 9. Você pode melhorar.");
    }

    @Test
    public void itShouldReturnAverageGratherThan9(){
        //setup
        StudentDTO studentDTO = gerarDados(10.0, 10.0);

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //act
        StudentDTO response = obterDiplomaService.analyzeScores(1L);

        //asserts
        assertEquals(response.getAverageScore(), 10.0);
        assertEquals(response.getMessage(), "O aluno Weverton obteve uma média de 10. Parabéns!");
    }

    private StudentDTO gerarDados(Double nota1, Double nota2){
        SubjectDTO sub1 = new SubjectDTO("Fisica", nota1);
        SubjectDTO sub2 = new SubjectDTO("Matematica", nota2);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.addAll(Arrays.asList(sub1, sub2));

        StudentDTO studentDTO = new StudentDTO(1L, "Weverton", null, null, subjects);
        return studentDTO;
    }

}