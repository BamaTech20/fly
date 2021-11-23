package com.example.fmw.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "billet")
public class Billet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long numero;
	private String destination;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyy-MM-dd")
	private Date dateSave;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyy-MM-dd")
	private Date dateDepart;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyy-MM-dd")
	private Date dateArrive;
	
	private Boolean actif;
	
	
	
	public Billet() {}

	public Billet(Long id, Long numero, String destination, Date dateSave, Date dateDepart, Date dateArrive,
			Boolean actif) {
		this.id = id;
		this.numero = numero;
		this.destination = destination;
		this.dateSave = dateSave;
		this.dateDepart = dateDepart;
		this.dateArrive = dateArrive;
		this.actif = actif;
	}
	
	
	@Override
	public String toString() {
		return "Billet [id=" + id + ", numero=" + numero + ", destination=" + destination + ", dateSave=" + dateSave
				+ ", dateDepart=" + dateDepart + ", dateArrive=" + dateArrive + ", actif=" + actif + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDateSave() {
		return dateSave;
	}
	public void setDateSave(Date dateSave) {
		this.dateSave = dateSave;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	

}
