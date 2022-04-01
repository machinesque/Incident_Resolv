/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.machinesque.incident_resolv.domain;

import java.time.OffsetDateTime;
import javax.persistence.MappedSuperclass;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 *
 * @author luiz
 */
@Data
@MappedSuperclass
public class AuditableEntity {
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime createAt;
 
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime updateAt;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String updatedByUser;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean active;
    
}
