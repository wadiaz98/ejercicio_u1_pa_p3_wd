package com.example.demo.matriculacion.repository;

import com.example.demo.matriculacion.modelo.Vehiculo;

public interface IVehiculoRepository {

	// CRUD
	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public Vehiculo buscar(String placa);

	public void borrar(String placa);
}
