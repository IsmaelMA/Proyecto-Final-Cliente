package com.ismaelmaldonado.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;
import com.ismaelmaldonado.cliente.service.cliente.ClienteService;

import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar operaciones relacionadas con clientes.
 */
@RestController
@RequestMapping(value = "/owners")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Lista todos los clientes disponibles.
     * 
     * @return Una lista con todos los clientes.
     */
    @GetMapping(value = "/list")
    public List<Cliente> listarClientes() {
        return clienteService.listarTodosLosClientes();
    }

    /**
     * Busca y devuelve un cliente por su ID.
     * 
     * @param id El ID del cliente a buscar.
     * @return Cliente con el ID proporcionado.
     */
    @GetMapping(value = "/search/{id}")
    public Cliente buscarClientePorId(@PathVariable int id) {
        return clienteService.encontrarPorId(id);
    }

    /**
     * Busca y devuelve una lista de clientes basándose en su apellido.
     * 
     * @param apellido El apellido del cliente a buscar.
     * @return Lista de clientes con el apellido proporcionado.
     */
    @GetMapping(value = "/search/detail/{apellido}")
    public List<Cliente> buscarClientePorId(@PathVariable("apellido") String apellido) {
        return clienteService.encontrarClientesPorApellido(apellido);
    }

    /**
     * Busca y devuelve una lista de vehículos asociados a un cliente específico.
     * 
     * @param id El ID del cliente para el cual buscar vehículos.
     * @return Lista de vehículos asociados al cliente con el ID proporcionado.
     */
    @GetMapping(value = "/search/vehiclesByOwner/{id}")
    public List<Vehiculo> buscarVehiculosPorIdCliente(@PathVariable("id") int id) {
        return clienteService.encontrarVehiculosPorIdCliente(id);
    }

    /**
     * Actualiza la información de un cliente especificado por su ID.
     * 
     * @param id       El ID del cliente a actualizar.
     * @param nombre   El nuevo nombre del cliente.
     * @param apellido El nuevo apellido del cliente.
     * @return Respuesta indicando que el cliente se actualizó correctamente.
     */
    @PutMapping(value = "/update/{id}/{nombre}/{apellido}")
    public ResponseEntity<String> actualizarCliente(@PathVariable int id, @PathVariable String nombre,
            @PathVariable String apellido) {
        clienteService.actualizarClientePorID(id, nombre, apellido);
        return ResponseEntity.ok("Cliente actualizado correctamente");
    }

    /**
     * Elimina un cliente especificado por su ID.
     * 
     * @param id El ID del cliente a eliminar.
     * @return Respuesta indicando que el cliente fue eliminado correctamente.
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable int id) {
        clienteService.eliminarClientePorID(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }

    /**
     * Crea un nuevo cliente con un nombre y apellido dados.
     * 
     * @param nombre   El nombre del nuevo cliente.
     * @param apellido El apellido del nuevo cliente.
     * @return Respuesta indicando que el cliente fue creado correctamente.
     */
    @PostMapping(value = "/create/{nombre}/{apellido}")
    public ResponseEntity<String> crearCliente(@PathVariable String nombre, @PathVariable String apellido) {
        clienteService.crearCliente(nombre, apellido);
        return ResponseEntity.ok("Cliente creado correctamente");
    }

}
