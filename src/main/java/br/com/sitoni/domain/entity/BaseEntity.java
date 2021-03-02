package br.com.sitoni.domain.entity;

import java.util.Date;

/**
 * BaseEntity
 */
public interface BaseEntity {

    Long getId();
    void setId(Long id);
   
    Date getDateRegistration();
    void setDateRegistration(Date dateRegistration);

    Date getDateUpdate();
    void setDateUpdate(Date dateUpdate);

}