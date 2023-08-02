package com.sbk.api.domain.cliente;

import com.sbk.api.domain.identificacao.Identificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "clientes")
@Entity
@Getter
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
}
