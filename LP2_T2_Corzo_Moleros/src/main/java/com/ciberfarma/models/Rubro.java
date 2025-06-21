package com.ciberfarma.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tbl_rubro")
public class Rubro {

	@Id
	@Column(name="id_rubro")
	private int idRubro;
	
	@Column(name="denominacion", nullable=false)
	private String denominacion;
	
	public String toString() {
		return denominacion;
	}
}
