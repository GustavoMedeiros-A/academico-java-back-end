package br.com.aula.academico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", unique=true, nullable = false)
    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @Min(value = 40, message = "Carga horária abaixo da permitida")
    private int cargaHoraria;

    @Length(max = 100, message = "Limite de caracteres ultrapassado")
    private String conteudo;

    // @NotNull(message = "Professor é obrigatório")
    // private Pessoa professor;

    @NotNull(message = "Não pode ser nulo")
    @PastOrPresent(message = "Data deve ser menor que o dia de hoje")
    private LocalDate dataCriacao;


}
