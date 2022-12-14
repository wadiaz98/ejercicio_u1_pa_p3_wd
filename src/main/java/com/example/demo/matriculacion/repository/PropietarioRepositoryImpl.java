package com.example.demo.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matriculacion.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	private static List<Propietario> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		baseDatos.add(propietario);
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		Propietario propietario = null;
		for (Propietario p : baseDatos) {
			if (p.getCedula().equals(cedula)) {
				propietario = p;
			}
		}
		return propietario;
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		Propietario propietario = this.buscar(cedula);
		baseDatos.remove(propietario);
	}

}
