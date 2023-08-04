package com.sbk.api.controller;

import com.sbk.api.domain.cliente.ClienteDto;
import com.sbk.api.domain.cliente.ClienteEditarDadosDto;
import com.sbk.api.domain.cliente.ClienteExibirDadosDto;
import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarCliente(@RequestBody @Valid ClienteDto dados){
        var cliente = new ClienteModel(dados);
        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteExibirDadosDto(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteExibirDadosDto>> listarClientes(@PageableDefault Pageable pageable){
        var page = clienteRepository.findAll(pageable).map(ClienteExibirDadosDto::new);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirDadosCliente(@PathVariable(value = "id")Long id){
        var cliente = clienteRepository.getReferenceById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new ClienteExibirDadosDto(cliente));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarDadosCliente(@PathVariable(value = "id")Long id, @RequestBody ClienteEditarDadosDto dados){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.EditarDados(dados);

        return ResponseEntity.status(HttpStatus.OK).body(new ClienteExibirDadosDto(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCliente(@PathVariable(value = "id")Long id){
        var cliente = clienteRepository.getReferenceById(id);
        clienteRepository.delete(cliente);

        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluido com sucesso!");
    }

}
