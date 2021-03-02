package br.com.sitoni.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sitoni.utils.Constantes;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Setter
@Getter
@Entity
@Table(name="Person")
public class Person implements Serializable, BaseEntity {

    private static final long serialVersionUID = 1L;

    public Person(Long id, String name, String sex, String email, Date dateBirth, String naturalness, String nationality, String cpf, Date dateRegistration, Date dateUpdate) {
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

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "sex", length = 1)
    private String sex;

    @NotBlank(message = "Email is mandatory")
    @NotEmpty(message = "Email is required")
    @Email
    @Column(name = "email", length = 150)
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = Constantes.LOCALE, timezone = Constantes.TIMEZONE)
    @Temporal(TemporalType.DATE)
    @Column(name = "dateBirth", columnDefinition = "DATE")
    private Date dateBirth;

    @Column(name = "naturalness", length = 50)
    private String naturalness;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "cpf", length = 11, unique = true)
    @NotEmpty(message = "{campo.cpf.obrigatorio }")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = Constantes.LOCALE, timezone = Constantes.TIMEZONE)
    @Temporal(TemporalType.DATE)
    @Column(name = "dateRegistration", columnDefinition = "DATE")
    private Date dateRegistration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = Constantes.LOCALE, timezone = Constantes.TIMEZONE)
    @Temporal(TemporalType.DATE)
    @Column(name = "dateUpdate", columnDefinition = "DATE")
    private Date dateUpdate;
    
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

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", dateBirth=" + dateBirth +
                ", naturalness='" + naturalness + '\'' +
                ", nationality='" + nationality + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", dateUpdate=" + dateUpdate +
                '}';
    }

}
