package com.sbk.api.domain.agenda;

import com.sbk.api.domain.cliente.ClienteModel;
import com.sbk.api.domain.corretor.CorretorModel;
import com.sbk.api.domain.imoveis.ImovelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(name = "agenda")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {
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

    private LocalDate data;

    private LocalTime hora;

    private String informacoes;

    private Boolean aprovado;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createAt;

    private LocalDateTime lastUpdate;
}
