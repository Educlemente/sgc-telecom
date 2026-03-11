package br.com.sgc.controller;

import br.com.sgc.domain.model.Cliente;
import br.com.sgc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
