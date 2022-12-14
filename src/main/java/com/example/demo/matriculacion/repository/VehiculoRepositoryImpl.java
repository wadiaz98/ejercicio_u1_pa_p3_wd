package com.example.demo.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matriculacion.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	private static List<Vehiculo> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		baseDatos.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo2 = null;
		for (Vehiculo v : baseDatos) {
			if (v.getPlaca().equals(vehiculo.getPlaca())) {
				vehiculo2 = v;
			}
			baseDatos.remove(vehiculo2);
			baseDatos.add(vehiculo);
		}

	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo2 = null;
		for (Vehiculo v : baseDatos) {
			if (v.getPlaca().equals(placa)) {
				vehiculo2 = v;
			}
		}
		return vehiculo2;
	}

	@Override
	public void borrar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = this.buscar(placa);
		baseDatos.remove(vehiculo);
	}

}
