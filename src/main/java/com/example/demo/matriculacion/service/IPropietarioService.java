package com.example.demo.matriculacion.service;

import com.example.demo.matriculacion.modelo.Propietario;

public interface IPropietarioService {

	public void crear(Propietario propietario);

	public void eliminar(String cedula);
}
