package com.sbk.api.domain.proprietario;

import com.sbk.api.domain.identificacao.Identificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "proprietarios")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProprietarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate nascimento;

    private Boolean sexo;

    @Column(length = 22)
    private String telefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Identificacao identificacao;

    @Column(length = 50)
    private String identificacaoNumero;

    private String observacao;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    public ProprietarioModel(ProprietarioDto dados){
        this.nome = dados.nome();
        this.nascimento = dados.nascimento();
        this.sexo = dados.sexo();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.identificacao = dados.identificacao();
        this.identificacaoNumero = dados.identificacaoNumero();
        this.observacao = dados.observacao();
        this.createAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    public void EditarDadosProprietario(ProprietarioEditarDadosDto dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.nascimento() != null){
            this.nascimento = dados.nascimento();
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
        if(dados.identificacaoNumero() != null){
            this.identificacaoNumero = dados.identificacaoNumero();
        }
        if(dados.observacao() != null){
            this.observacao = dados.observacao();
        }
        this.lastUpdate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
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

    public String getIdentificacaoNumero() {
        return identificacaoNumero;
    }

    public String getObservacao() {
        return observacao;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
