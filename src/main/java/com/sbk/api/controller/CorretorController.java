package com.sbk.api.controller;

import com.sbk.api.domain.corretor.CorretorDto;
import com.sbk.api.domain.corretor.CorretorEditarDadosDto;
import com.sbk.api.domain.corretor.CorretorExibirDadosDto;
import com.sbk.api.domain.corretor.CorretorModel;
import com.sbk.api.repository.CorretorRepository;
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
@RequestMapping("corretor")
public class CorretorController {
    @Autowired
    private CorretorRepository corretorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarCorretor(@RequestBody @Valid CorretorDto dados){
        var corretor = new CorretorModel(dados);
        corretorRepository.save(corretor);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CorretorExibirDadosDto(corretor));
    }

    @GetMapping
    public ResponseEntity<Page<CorretorExibirDadosDto>> listarCorretores(@PageableDefault Pageable pageable){
        var page = corretorRepository.findAll(pageable).map(CorretorExibirDadosDto::new);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirDadosCorretor(@PathVariable(value = "id") Long id){
        var corretor = corretorRepository.getReferenceById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new CorretorExibirDadosDto(corretor));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarDadosCorretor(@PathVariable(value = "id") Long id, @RequestBody CorretorEditarDadosDto dados){
        var corretor = corretorRepository.getReferenceById(id);
        corretor.EditarCorretor(dados);

        return ResponseEntity.status(HttpStatus.OK).body(new CorretorExibirDadosDto(corretor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCorretor(@PathVariable(value = "id")Long id) {
        var corretor = corretorRepository.getReferenceById(id);
        corretorRepository.delete(corretor);

        return ResponseEntity.status(HttpStatus.OK).body("Corretor Excluido Com Sucesso!");
    }
}
