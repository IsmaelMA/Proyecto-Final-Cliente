package com.ismaelmaldonado.cliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Representa un Vehiculo en el sistema.
 * Esta entidad contiene detalles específicos de un vehículo y su relación con
 * un Cliente.
 */
public class Vehiculo {

    /**
     * Identificador único del Vehículo.
     */
    private int id;

    /**
     * Matrícula o número de placa del Vehículo.
     */
    private String matricula;

    /**
     * Fabricante o marca del Vehículo.
     */
    private String fabricante;

    /**
     * Modelo específico del Vehículo.
     */
    private String modelo;

    /**
     * Representa la relación con un Cliente.
     * Un vehículo puede pertenecer a un solo cliente.
     */
    @JsonIgnore
    private Cliente cliente;

    private int clienteId;

    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
    }

    /**
     * Constructor para crear un objeto Vehiculo solo con id.
     *
     * @param id Identificador único del Vehículo.
     */
    public Vehiculo(int id) {
        this.id = id;
    }

    // ... Getters, Setters, hashCode, equals y toString ...

    /**
     * Constructor completo para crear un objeto Vehiculo.
     * 
     * @param id         Identificador único del Vehículo.
     * @param matricula  Matrícula del Vehículo.
     * @param fabricante Fabricante del Vehículo.
     * @param modelo     Modelo del Vehículo.
     * @param cliente    Cliente al que está asociado el Vehículo.
     */
    public Vehiculo(int id, String matricula, String fabricante, String modelo, Cliente cliente) {
        this.id = id;
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Vehiculo other = (Vehiculo) obj;
        if (id != other.id)
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    /**
     * Retorna una representación en cadena del objeto Vehiculo.
     *
     * @return Representación en cadena del Vehiculo.
     */
    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", idCliente=" + cliente.getId() + ", fabricante=" + fabricante
                + ", modelo=" + modelo + "]";
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return this.clienteId;
    }

}
