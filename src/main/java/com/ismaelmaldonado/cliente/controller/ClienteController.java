package com.ismaelmaldonado.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;
import com.ismaelmaldonado.cliente.service.cliente.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/owners")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/list")
    public List<Cliente> listarClientes() {
        return clienteService.listarTodosLosClientes();
    }

    @GetMapping(value = "/search/{id}")
    public Cliente buscarClientePorId(@PathVariable int id) {
        return clienteService.encontrarPorId(id);
    }

    @GetMapping(value = "/search/detail/{apellido}")
    public List<Cliente> buscarClientePorId(@PathVariable("apellido") String apellido) {
        return clienteService.encontrarClientesPorApellido(apellido);
    }

    @GetMapping(value = "/search/vehiclesByOwner/{id}")
    public List<Vehiculo> buscarVehiculosPorIdCliente(@PathVariable("id") int id) {
        return clienteService.encontrarVehiculosPorIdCliente(id);
    }

    @PutMapping(value = "/update/{id}/{nombre}/{apellido}")
    public ResponseEntity<String> actualizarCliente(@PathVariable int id, @PathVariable String nombre,
            @PathVariable String apellido) {
        clienteService.actualizarClientePorID(id, nombre, apellido);
        return ResponseEntity.ok("Cliente actualizado correctamente");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable int id) {
        clienteService.eliminarClientePorID(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }

}
