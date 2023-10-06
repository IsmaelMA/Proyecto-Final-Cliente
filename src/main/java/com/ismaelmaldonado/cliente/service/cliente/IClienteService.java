package com.ismaelmaldonado.cliente.service.cliente;

import java.util.List;
import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

/**
 * Interface que define los servicios relacionados con el Cliente.
 */
public interface IClienteService {

    /**
     * Encuentra y devuelve una lista de clientes basándose en su apellido.
     * 
     * @param apellido El apellido del cliente.
     * @return Lista de clientes con el apellido proporcionado.
     */
    public List<Cliente> encontrarClientesPorApellido(String apellido);

    /**
     * Obtiene y devuelve una lista de todos los clientes.
     * 
     * @return Lista de todos los clientes.
     */
    public List<Cliente> listarTodosLosClientes();

    /**
     * Encuentra y devuelve un cliente basándose en su ID.
     * 
     * @param id El ID del cliente.
     * @return Cliente con el ID proporcionado.
     */
    public Cliente encontrarPorId(int id);

    /**
     * Encuentra y devuelve una lista de vehículos asociados con un cliente
     * específico.
     * 
     * @param idCliente El ID del cliente.
     * @return Lista de vehículos asociados al cliente con el ID proporcionado.
     */
    public List<Vehiculo> encontrarVehiculosPorIdCliente(int idCliente);

    /**
     * Actualiza la información de un cliente basándose en su ID.
     * 
     * @param id       El ID del cliente a actualizar.
     * @param nombre   El nuevo nombre del cliente.
     * @param apellido El nuevo apellido del cliente.
     */
    public void actualizarClientePorID(int id, String nombre, String apellido);

    /**
     * Elimina un cliente basándose en su ID.
     * 
     * @param id El ID del cliente a eliminar.
     */
    public void eliminarClientePorID(int id);

    /**
     * Crea un nuevo cliente.
     * 
     * @param nombre   El nombre del nuevo cliente.
     * @param apellido El apellido del nuevo cliente.
     */
    public void crearCliente(String nombre, String apellido);

}
