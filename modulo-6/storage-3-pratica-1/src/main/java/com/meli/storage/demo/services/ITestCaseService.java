package com.meli.storage.demo.services;

import com.meli.storage.demo.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ITestCaseService {
    TestCaseDTO create(TestCaseDTO test);
    TestCaseDTO update(Long ID, TestCaseDTO test);
    List<TestCaseDTO> findAll();
    List<TestCaseDTO> search(LocalDate lastUpdate);
    TestCaseDTO findById(Long ID);
    void delete(Long ID);
}
