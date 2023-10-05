package com.ismaelmaldonado.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.cliente.model.Cliente;
import com.ismaelmaldonado.cliente.service.cliente.ClienteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/dueños")
    public List<Cliente> listarClientes() {
        return clienteService.listarTodosLosClientes();
    }

}
