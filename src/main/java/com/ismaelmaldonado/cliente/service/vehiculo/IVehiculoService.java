package com.ismaelmaldonado.cliente.service.vehiculo;

import java.util.List;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.model.Vehiculo;

public interface IVehiculoService {

    public List<Vehiculo> listarTodosLosVehiculos();

    public Vehiculo encontrarPorId(int id);

    public Vehiculo actualizarMatriculaVehiculoPorID(int id, String matricula);

    public void eliminarVehiculoPorID(int id);

    public Vehiculo crearVehiculo(String matricula, String fabricante, String modelo, int idCliente);

    public Cliente conseguirElDuenioDelVehiculo(int idVehiculo);

    public Vehiculo encontrarVehiculoPorMatricula(String matricula);

    public Vehiculo encontrarVehiculoPorNombreDelFabricante(String fabricante);

}
