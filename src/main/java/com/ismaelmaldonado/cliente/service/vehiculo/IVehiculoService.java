package com.ismaelmaldonado.cliente.service.vehiculo;

import java.util.List;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

/**
 * Interfaz que define los servicios relacionados con la entidad Vehiculo.
 */
public interface IVehiculoService {

    /**
     * Lista todos los vehículos disponibles.
     * 
     * @return Una lista con todos los vehículos.
     */
    public List<Vehiculo> listarTodosLosVehiculos();

    /**
     * Busca y devuelve un vehículo por su ID.
     * 
     * @param id El ID del vehículo a buscar.
     * @return Vehículo con el ID proporcionado.
     */
    public Vehiculo encontrarPorId(int id);

    /**
     * Actualiza la matrícula de un vehículo especificado por su ID.
     * 
     * @param id        El ID del vehículo a actualizar.
     * @param matricula La nueva matrícula para el vehículo.
     */
    public void actualizarMatriculaVehiculoPorID(int id, String matricula);

    /**
     * Elimina un vehículo especificado por su ID.
     * 
     * @param id El ID del vehículo a eliminar.
     */
    public void eliminarVehiculoPorID(int id);

    /**
     * Crea un nuevo vehículo.
     * 
     * @param matricula  Matrícula del nuevo vehículo.
     * @param fabricante Fabricante del nuevo vehículo.
     * @param modelo     Modelo del nuevo vehículo.
     * @param idCliente  ID del cliente propietario del vehículo.
     */
    public void crearVehiculo(String matricula, String fabricante, String modelo, int idCliente);

    /**
     * Devuelve el cliente propietario de un vehículo especificado por su ID.
     * 
     * @param idVehiculo El ID del vehículo.
     * @return Cliente propietario del vehículo.
     */
    public Cliente conseguirElPropietarioDelVehiculo(int idVehiculo);

    /**
     * Busca y devuelve un vehículo basándose en su matrícula.
     * 
     * @param matricula La matrícula del vehículo a buscar.
     * @return Vehículo con la matrícula proporcionada.
     */
    public Vehiculo encontrarVehiculoPorMatricula(String matricula);

    /**
     * Busca y devuelve una lista de vehículos basándose en el nombre del
     * fabricante.
     * 
     * @param fabricante El nombre del fabricante a buscar.
     * @return Lista de vehículos del fabricante proporcionado.
     */
    public List<Vehiculo> encontrarVehiculosPorNombreDelFabricante(String fabricante);

}
