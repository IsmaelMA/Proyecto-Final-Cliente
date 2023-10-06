package com.ismaelmaldonado.cliente.service.cliente;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

/**
 * Servicio para gestionar operaciones relacionadas con los clientes.
 * Esta clase realiza llamadas a una API externa usando {@link RestTemplate}.
 */
@Service
public class ClienteService implements IClienteService {

    @Autowired
    RestTemplate template;

    /** URL base para el servicio cliente en el servidor. */
    private static final String URL = "http://localhost:8080/cliente";

    /**
     * Obtiene una lista de todos los clientes desde el servidor.
     * 
     * @return Lista de todos los clientes.
     */
    @Override
    public List<Cliente> listarTodosLosClientes() {
        return Arrays.asList(template.getForObject(URL, Cliente[].class));
    }

    /**
     * Busca y devuelve una lista de clientes basándose en su apellido.
     * 
     * @param apellido El apellido del cliente a buscar.
     * @return Lista de clientes con el apellido proporcionado.
     */
    @Override
    public List<Cliente> encontrarClientesPorApellido(String apellido) {
        return Arrays.asList(template.getForObject(URL + "/detalle/ " + apellido, Cliente[].class));
    }

    /**
     * Encuentra y devuelve un cliente por su ID.
     * 
     * @param id El ID del cliente a buscar.
     * @return Cliente con el ID proporcionado.
     */
    @Override
    public Cliente encontrarPorId(int id) {
        return template.getForObject(URL + "/" + id, Cliente.class);
    }

    /**
     * Encuentra y devuelve una lista de vehículos asociados a un cliente
     * específico.
     * 
     * @param idCliente El ID del cliente para el cual buscar vehículos.
     * @return Lista de vehículos asociados al cliente con el ID proporcionado.
     */
    @Override
    public List<Vehiculo> encontrarVehiculosPorIdCliente(int idCliente) {
        return Arrays.asList(template.getForObject(URL + "/" + idCliente + "/vehiculos", Vehiculo[].class));
    }

    /**
     * Actualiza la información de un cliente especificado por su ID.
     * 
     * @param id       El ID del cliente a actualizar.
     * @param nombre   El nuevo nombre del cliente.
     * @param apellido El nuevo apellido del cliente.
     */
    @Override
    public void actualizarClientePorID(int id, String nombre, String apellido) {
        template.put(URL + "/" + id + "/" + nombre + "/" + apellido, null);
    }

    /**
     * Elimina un cliente especificado por su ID.
     * 
     * @param id El ID del cliente a eliminar.
     */
    @Override
    public void eliminarClientePorID(int id) {
        template.delete(URL + "/" + id);
    }

    /**
     * Crea un nuevo cliente con un nombre y apellido dados.
     * 
     * @param nombre   El nombre del nuevo cliente.
     * @param apellido El apellido del nuevo cliente.
     */
    @Override
    public void crearCliente(String nombre, String apellido) {
        template.postForEntity(URL + "/" + nombre + "/" + apellido, null, Void.class);
    }

}
