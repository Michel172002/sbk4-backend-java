package com.sbk.api.controller;

import com.sbk.api.domain.imoveis.ImovelDto;
import com.sbk.api.domain.imoveis.ImovelEditarDadosDto;
import com.sbk.api.domain.imoveis.ImovelExibirDadosDto;
import com.sbk.api.service.ImovelService;
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
@RequestMapping("imovel")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @PostMapping
    @Transactional
    public ResponseEntity criarImovel(@RequestBody @Valid ImovelDto dados){
        var imovelCriado = imovelService.criarImovel(dados);

        return ResponseEntity.status(HttpStatus.CREATED).body(imovelCriado);
    }

    @GetMapping
    public ResponseEntity<Page<ImovelExibirDadosDto>> listarImoveis(@PageableDefault Pageable pageable){
        var page = imovelService.listarImoveis(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirDadosImovel(@PathVariable(value = "id")Long id){
        var imovel = imovelService.exibirDadosImovel(id);

        return ResponseEntity.status(HttpStatus.OK).body(imovel);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarDadosImovel(@PathVariable(value = "id")Long id, @RequestBody ImovelEditarDadosDto dados){
        var imovel = imovelService.editarDadosImovel(id, dados);

        return ResponseEntity.status(HttpStatus.OK).body(imovel);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirImovel(@PathVariable(value = "id")Long id){
        imovelService.excluirImovel(id);

        return ResponseEntity.status(HttpStatus.OK).body("Imovel excluido com Sucesso!");
    }
}
