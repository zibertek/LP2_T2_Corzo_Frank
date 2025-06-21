package com.ciberfarma.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tbl_proveedor")
public class Proveedor {

	@Id
	@Column(name = "id_proveedor")
	private int idProveedor;

	@Column(name = "ruc", nullable = false)
	private String ruc;

	@Column(name = "razon_social", nullable = false)
	private String razonSocial;

	@Column(name = "fecha_registro", nullable = false)
	private LocalDate fechaRegistro;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "pagina_web")
	private String paginaWeb;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rubro")
	private Rubro rubro;
}
