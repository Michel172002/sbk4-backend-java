package com.sbk.api.domain.cliente;

import com.sbk.api.domain.identificacao.Identificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "clientes")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClienteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNas;

    private Boolean sexo;

    @Column(length = 22)
    private String telefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Identificacao identificacao;

    @Column(length = 50)
    private String identificacaoNumber;

    private String observacao;

    @Column(length = 50)
    private String procTipo;

    private Boolean procAlugando;

    @Column(length = 50)
    private String procComodos;

    private Boolean ativo;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    public ClienteModel(ClienteDto dados){
        this.nome = dados.nome();
        this.dataNas = dados.dataNas();
        this.sexo = dados.sexo();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.identificacao = dados.identificacao();
        this.identificacaoNumber = dados.identificacaoNumber();
        this.observacao = dados.observacao();
        this.procTipo = dados.procTipo();
        this.procAlugando = dados.procAlugando();
        this.procComodos = dados.procComodos();
        this.ativo = true;
        this.createAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    public void EditarDados(ClienteEditarDadosDto dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.dataNas() != null){
            this.dataNas = dados.dataNas();
        }
        if(dados.sexo() != null){
            this.sexo = dados.sexo();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.identificacao() != null){
            this.identificacao = dados.identificacao();
        }
        if(dados.identificacaoNumber() != null){
            this.identificacaoNumber = dados.identificacaoNumber();
        }
        if(dados.observacao() != null){
            this.observacao = dados.observacao();
        }
        if(dados.procTipo() != null){
            this.procTipo = dados.procTipo();
        }
        if(dados.procAlugando() != null){
            this.procAlugando = dados.procAlugando();
        }
        if(dados.procComodos() != null){
            this.procComodos = dados.procComodos();
        }
        if(dados.ativo() != null){
            this.ativo = dados.ativo();
        }
        this.lastUpdate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNas() {
        return dataNas;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public String getIdentificacaoNumber() {
        return identificacaoNumber;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getProcTipo() {
        return procTipo;
    }

    public Boolean getProcAlugando() {
        return procAlugando;
    }

    public String getProcComodos() {
        return procComodos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
