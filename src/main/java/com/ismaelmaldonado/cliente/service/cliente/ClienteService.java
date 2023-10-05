package com.ismaelmaldonado.cliente.service.cliente;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    RestTemplate template;

    private static final String URL = "http://localhost:8080/cliente";

    @Override
    public List<Cliente> listarTodosLosClientes() {
        return Arrays.asList(template.getForObject(URL, Cliente[].class));
    }

    @Override
    public List<Cliente> encontrarPorApellido(String apellido) {
        return Arrays.asList(template.getForObject(URL, Cliente[].class));
    }

    @Override
    public Cliente encontrarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarPorId'");
    }

    @Override
    public List<Vehiculo> encontrarVehiculosPorIdCliente(int idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarVehiculosPorIdCliente'");
    }

    @Override
    public Cliente actualizarClientePorID(int id, String nombre, String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarClientePorID'");
    }

    @Override
    public void eliminarClientePorID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarClientePorID'");
    }

    @Override
    public Cliente crearCliente(String nombre, String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCliente'");
    }

}
