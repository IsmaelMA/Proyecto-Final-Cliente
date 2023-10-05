package com.ismaelmaldonado.cliente.model;

import java.util.List;

/**
 * Representa un Cliente en el sistema.
 * Esta entidad contiene detalles personales de un cliente y una lista de
 * vehículos asociados.
 */
public class Cliente {

    /**
     * Identificador único del Cliente.
     */
    private int id;

    /**
     * Nombre del Cliente.
     */
    private String nombre;

    /**
     * Apellido del Cliente.
     */
    private String apellido;

    /**
     * Representa una lista de Vehículos asociados a este Cliente.
     */
    private List<Vehiculo> vehiculos;

    /**
     * Constructor por defecto.
     */
    public Cliente() {
    }

    /**
     * Constructor para crear un objeto Cliente solo con id.
     * 
     * @param id Identificador único del Cliente.
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Constructor para crear un objeto Cliente completamente poblado.
     *
     * @param id        Identificador único del Cliente.
     * @param nombre    Nombre del Cliente.
     * @param apellido  Apellido del Cliente.
     * @param vehiculos Lista de Vehículos asociados a este Cliente.
     */
    public Cliente(int id, String nombre, String apellido, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * @return Representación en cadena del objeto Cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
