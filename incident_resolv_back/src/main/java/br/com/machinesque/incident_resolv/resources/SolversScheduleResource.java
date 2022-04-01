/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.machinesque.incident_resolv.resources;

import br.com.machinesque.incident_resolv.domain.SolversSchedule;
import br.com.machinesque.incident_resolv.services.SolversScheduleService;
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
@RequestMapping
public class SolversScheduleResource {
    
    @Autowired
    private SolversScheduleService solversScheduleService;
  
    @GetMapping
    public List<SolversSchedule> listAll() {
        return solversScheduleService.listSolversSchedules();
    }
    
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody SolversSchedule solversSchedule) {
        solversSchedule = solversScheduleService.insert(solversSchedule);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(solversSchedule.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }
    
}
