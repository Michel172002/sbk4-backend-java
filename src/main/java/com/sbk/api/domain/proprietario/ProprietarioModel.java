package com.sbk.api.domain.proprietario;

import com.sbk.api.domain.identificacao.Identificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "proprietarios")
@Entity
@Getter
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
}
