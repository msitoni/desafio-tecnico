package br.com.sitoni.domain.dto;

import br.com.sitoni.utils.Constantes;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class PersonDTO extends BaseDTO {


    private Long id;
    private String name;
    private String sex;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = Constantes.LOCALE, timezone = Constantes.TIMEZONE)
    private Date dateBirth;
    private String naturalness;
    private String nationality;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = Constantes.LOCALE, timezone = Constantes.TIMEZONE)
    private Date dateRegistration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = Constantes.LOCALE, timezone = Constantes.TIMEZONE)
    private Date dateUpdate;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, String sex, String email, Date dateBirth, String naturalness, String nationality, String cpf, Date dateRegistration, Date dateUpdate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.dateBirth = dateBirth;
        this.naturalness = naturalness;
        this.nationality = nationality;
        this.cpf = cpf;
        this.dateRegistration = dateRegistration;
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNaturalness() {
        return naturalness;
    }

    public void setNaturalness(String naturalness) {
        this.naturalness = naturalness;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
