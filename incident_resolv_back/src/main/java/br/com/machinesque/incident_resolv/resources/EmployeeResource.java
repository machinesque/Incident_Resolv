/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.machinesque.incident_resolv.resources;

import br.com.machinesque.incident_resolv.domain.Employee;
import br.com.machinesque.incident_resolv.repositories.EmployeeRepository;
import br.com.machinesque.incident_resolv.services.EmployeeService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author luiz
 */
@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public List<Employee> listEmployee() {
        return employeeService.listEmployee();
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Employee employee) {
        employee = employeeService.insert(employee);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(employee.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }
    
}
