package com.example.storage4pratica2.data.ES;

import com.example.storage4pratica2.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findAll();
}
