package com.sbk.api.controller;

import com.sbk.api.domain.atividade.AtividadeDto;
import com.sbk.api.domain.atividade.AtividadeEditarDadosDto;
import com.sbk.api.domain.atividade.AtividadeExibirDadosDto;
import com.sbk.api.service.AtividadeService;
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
@RequestMapping("atividade")
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    @Transactional
    public ResponseEntity CriarAtividade(@RequestBody @Valid AtividadeDto dados){
        var atividade = atividadeService.criarAtividade(dados);

        return ResponseEntity.status(HttpStatus.CREATED).body(atividade);
    }

    @GetMapping
    public ResponseEntity<Page<AtividadeExibirDadosDto>> ListarAtividades(@PageableDefault Pageable pageable){
        var page = atividadeService.listarAtividades(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity ExibirDadosAtividades(@PathVariable(value = "id") Long id){
        var atividade = atividadeService.exibirDadosAtividade(id);

        return ResponseEntity.status(HttpStatus.OK).body(atividade);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity EditarDadosAtividades(@PathVariable(value = "id") Long id, @RequestBody AtividadeEditarDadosDto dados){
        var atividadeEditado = atividadeService.editarDadosAtividade(id, dados);

        return ResponseEntity.status(HttpStatus.OK).body(atividadeEditado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ExcluirAtividade(@PathVariable(value = "id")Long id){
        atividadeService.excluirAtividade(id);

        return ResponseEntity.status(HttpStatus.OK).body("Atividade Excluida com sucesso!");
    }
}
