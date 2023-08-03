package com.sbk.api.controller;

import com.sbk.api.domain.proprietario.ProprietarioDto;
import com.sbk.api.domain.proprietario.ProprietarioEditarDadosDto;
import com.sbk.api.domain.proprietario.ProprietarioExibirDadosDto;
import com.sbk.api.domain.proprietario.ProprietarioModel;
import com.sbk.api.repository.ProprietarioRepository;
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
@RequestMapping("proprietario")
public class ProprietarioController {
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarProprietario(@RequestBody @Valid ProprietarioDto dados){
        var proprietario = new ProprietarioModel(dados);
        proprietarioRepository.save(proprietario);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProprietarioExibirDadosDto(proprietario));
    }

    @GetMapping
    public ResponseEntity<Page<ProprietarioExibirDadosDto>> listarProprietarios(@PageableDefault Pageable pageable){
        var page = proprietarioRepository.findAll(pageable).map(ProprietarioExibirDadosDto::new);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirDadosProprietario(@PathVariable(value = "id")Long id){
        var proprietario = proprietarioRepository.getReferenceById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new ProprietarioExibirDadosDto(proprietario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarDadosProprieatario(@PathVariable(value = "id")Long id, @RequestBody ProprietarioEditarDadosDto dados){
        var proprietario = proprietarioRepository.getReferenceById(id);
        proprietario.EditarDadosProprietario(dados);

        return ResponseEntity.status(HttpStatus.OK).body(new ProprietarioExibirDadosDto(proprietario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirProprietario(@PathVariable(value = "id")Long id){
        var proprietario = proprietarioRepository.getReferenceById(id);
        proprietarioRepository.delete(proprietario);

        return ResponseEntity.status(HttpStatus.OK).body("Proprietario Excluido com sucesso!");
    }

}
