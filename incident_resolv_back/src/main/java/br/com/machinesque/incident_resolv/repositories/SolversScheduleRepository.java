/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.machinesque.incident_resolv.repositories;

import br.com.machinesque.incident_resolv.domain.SolversSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author luiz
 */
public interface SolversScheduleRepository extends JpaRepository<SolversSchedule, Long> {
    
}