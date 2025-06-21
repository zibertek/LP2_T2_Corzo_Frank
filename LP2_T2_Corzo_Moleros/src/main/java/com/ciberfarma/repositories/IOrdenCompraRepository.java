package com.ciberfarma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.models.OrdenCompra;

public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

	List<OrdenCompra> findAllByOrderByNroOrdenDesc();
}
