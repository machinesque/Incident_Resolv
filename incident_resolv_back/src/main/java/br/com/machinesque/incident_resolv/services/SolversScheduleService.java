/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.machinesque.incident_resolv.services;

import br.com.machinesque.incident_resolv.domain.SolversSchedule;
import br.com.machinesque.incident_resolv.repositories.SolversScheduleRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luiz
 */
@Service
public class SolversScheduleService {
    
    @Autowired
    private SolversScheduleRepository solversScheduleRepository;
    
    public List<SolversSchedule> listSolversSchedules() {
        return solversScheduleRepository.findAll();
    }
    
    public SolversSchedule insert(SolversSchedule solversSchedule) {
        solversSchedule.setId(null);
        solversSchedule.setCreateAt(OffsetDateTime.now());
        solversSchedule.setActive(true);
        return solversScheduleRepository.save(solversSchedule);
    }
    
}
