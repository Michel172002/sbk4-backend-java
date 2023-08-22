package com.sbk.api.controller;

import com.sbk.api.domain.agenda.AgendaDto;
import com.sbk.api.domain.agenda.AgendaEditarDadosDto;
import com.sbk.api.domain.agenda.AgendaExibirDadosDto;
import com.sbk.api.service.AgendaService;
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
@RequestMapping("agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @PostMapping
    @Transactional
    public ResponseEntity CriarAgenda(@RequestBody @Valid AgendaDto dados){
        var agenda = agendaService.CriarAgenda(dados);

        return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
    }

    @GetMapping
    public ResponseEntity<Page<AgendaExibirDadosDto>> ListarAgendas(@PageableDefault Pageable pageable){
        var page = agendaService.ListarAgendas(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity ExibirDadosAgenda(@PathVariable(value = "id")Long id){
        var agenda = agendaService.ExibirDadosAgenda(id);

        return ResponseEntity.status(HttpStatus.OK).body(agenda);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity EditarDadosAgenda(@PathVariable(value = "id")Long id, @RequestBody AgendaEditarDadosDto dados) {
        var agenda = agendaService.EditarDadosAgenda(id, dados);

        return ResponseEntity.status(HttpStatus.OK).body(agenda);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ExcluirAgenda(@PathVariable(value = "id")Long id){
        agendaService.ExcluirAgenda(id);

        return ResponseEntity.status(HttpStatus.OK).body("Agenda excluida com sucesso!");
    }
}
