package com.example.demo.matriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matriculacion.modelo.Matricula;

@Repository
public class MatriculaRepsitoryImpl implements IMatriculaRepository {
	private static List<Matricula> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		baseDatos.add(matricula);
		System.out.println("Se inserto la matricula: " + matricula);
	}

}
