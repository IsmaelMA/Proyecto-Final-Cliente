package com.ismaelmaldonado.cliente.service.cliente;

import java.util.List;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

public interface IClienteService {

    // Gets

    public List<Cliente> encontrarPorApellido(String apellido);

    public List<Cliente> listarTodosLosClientes();

    public Cliente encontrarPorId(int id);

    public List<Vehiculo> encontrarVehiculosPorIdCliente(int idCliente);

    // Put

    public Cliente actualizarClientePorID(int id, String nombre, String apellido);

    // Delete

    public void eliminarClientePorID(int id);

    // Post

    public Cliente crearCliente(String nombre, String apellido);

}
