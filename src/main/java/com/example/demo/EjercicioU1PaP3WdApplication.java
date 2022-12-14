package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.matriculacion.modelo.Propietario;
import com.example.demo.matriculacion.modelo.Vehiculo;
import com.example.demo.matriculacion.service.IMatriculaService;
import com.example.demo.matriculacion.service.IPropietarioService;
import com.example.demo.matriculacion.service.IVehiculoService;

@SpringBootApplication
public class EjercicioU1PaP3WdApplication implements CommandLineRunner {
	@Autowired
	private IMatriculaService matriculaService;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IPropietarioService propietarioService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioU1PaP3WdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setPlaca("PBO269");
		vehiculo.setPrecio(new BigDecimal(15000));
		vehiculo.setTipo("Liviano");

		this.vehiculoService.agregar(vehiculo);

		Vehiculo vehiculoActualizado = new Vehiculo();
		vehiculoActualizado.setMarca("Chevrolet");// Atributo actualizado
		vehiculoActualizado.setPlaca("PBO269");
		vehiculoActualizado.setPrecio(new BigDecimal(15000));
		vehiculoActualizado.setTipo("Pesado");// Atributo actualizado

		this.vehiculoService.actualizar(vehiculoActualizado);

		Propietario propietario = new Propietario();
		propietario.setNombre("Willan");
		propietario.setApellido("Diaz");
		propietario.setFechaNaciemiento(LocalDateTime.of(1998, 06, 01, 0, 0));
		propietario.setCedula("1725841538");

		this.propietarioService.crear(propietario);

		this.matriculaService.crear(propietario.getCedula(), vehiculo.getPlaca());
	}

}
