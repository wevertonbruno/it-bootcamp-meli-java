package com.meli.storage.demo.services;

import com.meli.storage.demo.dto.TestCaseDTO;
import com.meli.storage.demo.entities.TestCase;
import com.meli.storage.demo.repositories.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final TestCaseRepository repository;

    @Override
    public TestCaseDTO create(TestCaseDTO test) {
        TestCase testCase = TestCase.builder()
                .description(test.getDescription())
                .tested(test.getTested())
                .passed(test.getPassed())
                .numberOfTries(test.getNumberOfTries())
                .lastUpdate(LocalDate.now())
                .build();

        return TestCaseDTO.fromTestCase(repository.save(testCase));
    }

    @Override
    public TestCaseDTO update(Long ID, TestCaseDTO test) {
        TestCase testCase = repository.findById(ID)
                .map(testMap -> {
                    testMap.setDescription(test.getDescription());
                    testMap.setTested(test.getTested());
                    testMap.setPassed(test.getPassed());
                    testMap.setNumberOfTries(test.getNumberOfTries());
                    testMap.setLastUpdate(LocalDate.now());

                    return testMap;
                })
                .orElseThrow(() -> new RuntimeException("TestCase nao encontrado!"));

        return TestCaseDTO.fromTestCase(repository.save(testCase));
    }

    @Override
    public List<TestCaseDTO> findAll() {
        return repository.findAll()
                .stream().map(TestCaseDTO::fromTestCase).collect(Collectors.toList());
    }

    @Override
    public List<TestCaseDTO> search(LocalDate lastUpdate) {
        return repository.findByLastUpdateGreaterThanEqual(lastUpdate)
                .stream().map(TestCaseDTO::fromTestCase).collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO findById(Long ID) {
        TestCase testCase = repository.findById(ID)
                .orElseThrow(() -> new RuntimeException("TestCase nao encontrado!"));

        return TestCaseDTO.fromTestCase(testCase);
    }

    @Override
    public void delete(Long ID) {
        repository.findById(ID)
                .orElseThrow(() -> new RuntimeException("TestCase nao encontrado!"));

        repository.deleteById(ID);
    }
}
