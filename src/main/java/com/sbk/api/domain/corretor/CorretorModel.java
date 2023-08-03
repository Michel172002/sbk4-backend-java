package com.sbk.api.domain.corretor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "corretores")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CorretorModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(length = 22)
    private String telefone;

    @Column(length = 50)
    private String creci;

    private Boolean ativo;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    public CorretorModel(CorretorDto dados){
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.creci = dados.creci();
        this.ativo = dados.ativo();
        this.createAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    public void EditarCorretor(CorretorEditarDadosDto dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.creci() != null){
            this.creci = dados.creci();
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

    public String getTelefone() {
        return telefone;
    }

    public String getCreci() {
        return creci;
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
