package com.example.demo.matriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matriculacion.modelo.Matricula;
import com.example.demo.matriculacion.modelo.Propietario;
import com.example.demo.matriculacion.modelo.Vehiculo;
import com.example.demo.matriculacion.repository.IMatriculaRepository;
import com.example.demo.matriculacion.repository.IPropietarioRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	@Autowired
	private IMatriculaRepository matriculaRepository;
	@Autowired
	private IPropietarioRepository propietarioRepository;
	@Autowired
	private IVehiculoService vehiculoService;

	@Override
	public void crear(String cedulaPropietario, String placaVehiculo) {
		// TODO Auto-generated method stub
		// 1. Busco propietario
		Propietario propietario = this.propietarioRepository.buscar(cedulaPropietario);
		// 2.Busco vehiculo
		Vehiculo vehiculo = this.vehiculoService.buscar(placaVehiculo);
		// 3.Calculo valor
		BigDecimal valorMatricula = null;
		if (vehiculo.getTipo().toUpperCase().equals("PESADO")) {
			valorMatricula = vehiculo.getPrecio().multiply(new BigDecimal(0.15));

		} else if (vehiculo.getTipo().toUpperCase().equals("LIVIANO")) {
			valorMatricula = vehiculo.getPrecio().multiply(new BigDecimal(0.10));
		}

		if (valorMatricula.compareTo(new BigDecimal(2000)) == 1) {
			valorMatricula = valorMatricula.subtract(valorMatricula.multiply(new BigDecimal(0.07)));
		}

		// Creo matricula
		Matricula matricula = new Matricula();
		matricula.setFecha(LocalDateTime.now());
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		matricula.setValor(valorMatricula);

		this.matriculaRepository.insertar(matricula);
	}
}
