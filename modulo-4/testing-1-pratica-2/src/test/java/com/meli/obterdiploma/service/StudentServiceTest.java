package com.meli.obterdiploma.service;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.IStudentRepository;
import com.meli.obterdiploma.repository.StudentDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
//import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void itShouldCallSave(){
        StudentDTO studentDTO = gerarDados(10.0, 5.0);

        studentService.create(studentDTO);

        Mockito.verify(studentDAO, Mockito.times(1))
                .save(studentDTO);
    }

    @Test
    public void itShouldCallFindById(){
        studentService.read(1L);

        Mockito.verify(studentDAO, Mockito.times(1))
                .findById(Mockito.anyLong());
    }

    @Test
    public void itShouldCallSaveWhenUpdate(){
        StudentDTO student = new StudentDTO(1L, "Weverton", null, null, new ArrayList<>());
        studentService.update(student);

        ArgumentCaptor<StudentDTO> captor = ArgumentCaptor.forClass(StudentDTO.class);
        Mockito.verify(studentDAO, Mockito.times(1))
                .save(captor.capture());

        assertThat(captor.getValue()).isEqualTo(student);
        
    }

    @Test
    public void itShouldCallDelete(){
        studentService.delete(1L);

        Mockito.verify(studentDAO, Mockito.times(1))
                .delete(Mockito.anyLong());
    }

    @Test
    public void itShouldReturnAllStudents(){
        studentService.getAll();

        Mockito.verify(studentRepository, Mockito.times(1))
                .findAll();
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