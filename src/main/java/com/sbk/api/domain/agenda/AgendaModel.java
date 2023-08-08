package com.sbk.api.domain.agenda;

import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.domain.corretor.CorretorModel;
import com.sbk.api.domain.imoveis.ImovelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(name = "agenda")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AgendaModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCorretor")
    private CorretorModel corretor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idImovel")
    private ImovelModel imovel;

    private LocalDate dia;

    private LocalTime hora;

    private String informacoes;

    private Boolean aprovado;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;

    public AgendaModel(CorretorModel corretor, ClienteModel cliente, ImovelModel imovel, AgendaDto dados){
        this.corretor = corretor;
        this.cliente = cliente;
        this.imovel = imovel;
        this.dia = dados.dia();
        this.hora = dados.hora();
        this.informacoes = dados.informacoes();
        this.aprovado = dados.aprovado();
        this.status = dados.status();
        this.createAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    public void EditarDados(CorretorModel corretor, ClienteModel cliente, ImovelModel imovel, AgendaEditarDadosDto dados){
        if(corretor != null){
            this.corretor = corretor;
        }
        if(cliente != null){
            this.cliente = cliente;
        }
        if(imovel != null){
            this.imovel = imovel;
        }
        if(dados.dia() != null){
            this.dia = dados.dia();
        }
        if(dados.hora() != null){
            this.hora = dados.hora();
        }
        if(dados.informacoes() != null){
            this.informacoes = dados.informacoes();
        }
        if(dados.aprovado() != null){
            this.aprovado = dados.aprovado();
        }
        if(dados.status() != null){
            this.status = dados.status();
        }
        this.lastUpdate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public CorretorModel getCorretor() {
        return corretor;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public ImovelModel getImovel() {
        return imovel;
    }

    public LocalDate getDia() {
        return dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
