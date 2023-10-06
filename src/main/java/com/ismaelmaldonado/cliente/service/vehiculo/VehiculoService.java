package com.ismaelmaldonado.cliente.service.vehiculo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

/**
 * Implementación del servicio para gestionar las operaciones relacionadas con
 * vehículos.
 * Utiliza {@link RestTemplate} para interactuar con el microservicio de
 * vehículos.
 */
@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    RestTemplate template;

    /** URL base del microservicio de vehículos. */
    private static final String url = "http://localhost:8080/vehiculo";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehiculo> listarTodosLosVehiculos() {
        return Arrays.asList(template.getForObject(url, Vehiculo[].class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehiculo encontrarPorId(int id) {
        return template.getForObject(url + "/" + id, Vehiculo.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarMatriculaVehiculoPorID(int id, String matricula) {
        template.put(url + "/" + id + "/" + matricula, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarVehiculoPorID(int id) {
        template.delete(url + "/" + id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void crearVehiculo(String matricula, String fabricante, String modelo, int idCliente) {
        template.postForObject(url + "/" + matricula + "/" + fabricante + "/" + modelo + "/" + idCliente, null,
                String.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cliente conseguirElPropietarioDelVehiculo(int idVehiculo) {
        return template.getForObject(url + "/propietario/" + idVehiculo, Cliente.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehiculo encontrarVehiculoPorMatricula(String matricula) {
        return template.getForObject(url + "/detalle/matricula/" + matricula, Vehiculo.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehiculo> encontrarVehiculosPorNombreDelFabricante(String fabricante) {
        return Arrays.asList(template.getForObject(url + "/detalle/" + fabricante, Vehiculo[].class));
    }
}
