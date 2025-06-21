package com.ciberfarma.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tbl_orden_compra")
public class OrdenCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private int nroOrden;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@Column(name = "monto")
	private double monto;
	
	@Column(name = "direccion_entrega")
	private String direccionEntrega;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;
	
	@Column(name = "estado")
	private String estado;
	
}
