package com.wissen.hibernatemapping.repository.unidirectional.onetoone;

import com.wissen.hibernatemapping.entity.unidirectional.onetoone.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
