package com.ismaelmaldonado.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;
import com.ismaelmaldonado.cliente.service.vehiculo.VehiculoService;

import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con
 * vehículos.
 * Proporciona endpoints para realizar operaciones CRUD sobre vehículos y
 * consultar detalles adicionales.
 */
@RestController
@RequestMapping(value = "/vehicles")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    /**
     * Obtiene una lista de todos los vehículos registrados.
     * 
     * @return Lista de vehículos.
     */
    @GetMapping(value = "/list")
    public List<Vehiculo> listarVehiculos() {
        return vehiculoService.listarTodosLosVehiculos();
    }

    /**
     * Busca un vehículo por su ID.
     * 
     * @param id ID del vehículo.
     * @return Vehículo correspondiente al ID proporcionado.
     */
    @GetMapping(value = "/search/{id}")
    public Vehiculo buscarVehiculoPorId(@PathVariable("id") int id) {
        return vehiculoService.encontrarPorId(id);
    }

    /**
     * Busca un vehículo por su matrícula.
     * 
     * @param matricula Matrícula del vehículo.
     * @return Vehículo correspondiente a la matrícula proporcionada.
     */
    @GetMapping(value = "/search/detail/{matricula}")
    public Vehiculo buscarVehiculoPorMatricula(@PathVariable("matricula") String matricula) {
        return vehiculoService.encontrarVehiculoPorMatricula(matricula);
    }

    /**
     * Obtiene una lista de vehículos basado en el nombre del fabricante.
     * 
     * @param fabricante Nombre del fabricante.
     * @return Lista de vehículos del fabricante proporcionado.
     */
    @GetMapping(value = "/search/detail/fabricante/{fabricante}")
    public List<Vehiculo> buscarVehiculosPorNombreDelFabricante(@PathVariable("fabricante") String fabricante) {
        return vehiculoService.encontrarVehiculosPorNombreDelFabricante(fabricante);
    }

    /**
     * Busca el propietario de un vehículo por el ID del vehículo.
     * 
     * @param id ID del vehículo.
     * @return Propietario del vehículo.
     */
    @GetMapping(value = "/search/owner/{id}")
    public Cliente buscarPropietarioDelVehiculo(@PathVariable("id") int id) {
        return vehiculoService.conseguirElPropietarioDelVehiculo(id);
    }

    /**
     * Elimina un vehículo basado en su ID.
     * 
     * @param id ID del vehículo a eliminar.
     * @return Mensaje de confirmación.
     */
    @DeleteMapping(value = "/delete/{id}")
    public String eliminarVehiculo(@PathVariable("id") int id) {
        vehiculoService.eliminarVehiculoPorID(id);
        return "Vehiculo eliminado correctamente";
    }

    /**
     * Actualiza la matrícula de un vehículo basado en su ID.
     * 
     * @param id        ID del vehículo a actualizar.
     * @param matricula Nueva matrícula.
     * @return Mensaje de confirmación.
     */
    @PutMapping(value = "/update/{id}/{matricula}")
    public String actualizarMatriculaVehiculo(@PathVariable("id") int id, @PathVariable("matricula") String matricula) {
        vehiculoService.actualizarMatriculaVehiculoPorID(id, matricula);
        return "Matricula actualizada correctamente";
    }

    /**
     * Crea un nuevo vehículo.
     * 
     * @param matricula  Matrícula del vehículo.
     * @param fabricante Fabricante del vehículo.
     * @param modelo     Modelo del vehículo.
     * @param idCliente  ID del cliente propietario.
     * @return Mensaje de confirmación.
     */
    @PostMapping(value = "/create/{matricula}/{fabricante}/{modelo}/{idCliente}")
    public String crearVehiculo(@PathVariable("matricula") String matricula,
            @PathVariable("fabricante") String fabricante, @PathVariable("modelo") String modelo,
            @PathVariable("idCliente") int idCliente) {
        vehiculoService.crearVehiculo(matricula, fabricante, modelo, idCliente);
        return "Vehiculo creado correctamente";
    }
}
