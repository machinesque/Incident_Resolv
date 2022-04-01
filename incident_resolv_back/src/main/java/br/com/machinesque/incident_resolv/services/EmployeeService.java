/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.machinesque.incident_resolv.services;

import br.com.machinesque.incident_resolv.domain.Employee;
import br.com.machinesque.incident_resolv.repositories.EmployeeRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luiz
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }
    
    public Employee insert(Employee employee) {
        employee.setId(null);
        employee.setCreateAt(OffsetDateTime.now());
        employee.setActive(true);
        return employeeRepository.save(employee);
    }
    
}
