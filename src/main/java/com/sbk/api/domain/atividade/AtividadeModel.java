package com.sbk.api.domain.atividade;

import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.domain.imoveis.ImovelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "atividades")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtividadeModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idImovel")
    private ImovelModel imovel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private ClienteModel cliente;

    private Boolean ativo;

    private int vencimento;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    public AtividadeModel(ImovelModel imovel, ClienteModel cliente, AtividadeDto dados){
        this.imovel = imovel;
        this.cliente = cliente;
        this.ativo = dados.ativo();
        this.vencimento = dados.vencimento();
        this.situacao = dados.situacao();
        this.createAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    public void EditarDados(ImovelModel imovel, ClienteModel cliente, AtividadeEditarDadosDto dados){
        if(imovel != null){
            this.imovel = imovel;
        }
        if(cliente != null){
            this.cliente = cliente;
        }
        if(dados.ativo() != null){
            this.ativo = dados.ativo();
        }
        if(dados.vencimento() != null){
            this.vencimento = dados.vencimento();
        }
        if(dados.situacao() != null){
            this.situacao = dados.situacao();
        }
        this.lastUpdate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public ImovelModel getImovel() {
        return imovel;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public int getVencimento() {
        return vencimento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
