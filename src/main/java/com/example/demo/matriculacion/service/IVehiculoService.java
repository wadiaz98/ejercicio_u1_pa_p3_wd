package com.example.demo.matriculacion.service;

import com.example.demo.matriculacion.modelo.Vehiculo;

public interface IVehiculoService {

	public void agregar(Vehiculo vehiculo);

	public Vehiculo buscar(String placa);

	public void actualizar(Vehiculo vehiculo);

	public void borrar(String placa);
}
