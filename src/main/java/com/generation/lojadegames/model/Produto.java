package com.generation.lojadegames.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo nome deve conter entre 5 e 100 caracteres")
    private String nome;

    @Positive(message = "O atributo preço deve ser maior do que zero")
    @NotNull(message = "O atributo preço é obrigatório!")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal preco;

    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private Categoria categoria;

}