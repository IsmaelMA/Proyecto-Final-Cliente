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
    public List<Cliente> encontrarClientesPorApellido(String apellido) {
        return Arrays.asList(template.getForObject(URL + "/detalle/ " + apellido, Cliente[].class));
    }

    @Override
    public Cliente encontrarPorId(int id) {
        return template.getForObject(URL + "/" + id, Cliente.class);
    }

    @Override
    public List<Vehiculo> encontrarVehiculosPorIdCliente(int idCliente) {
        return Arrays.asList(template.getForObject(URL + "/" + idCliente + "/vehiculos", Vehiculo[].class));
    }

    @Override
    public void actualizarClientePorID(int id, String nombre, String apellido) {
        template.put(URL + "/" + id + "/" + nombre + "/" + apellido, null);
    }

    @Override
    public void eliminarClientePorID(int id) {
        template.delete(URL + "/" + id);
    }

    @Override
    public Cliente crearCliente(String nombre, String apellido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCliente'");
    }

}
