package br.com.aula.academico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private int id;

    private String nome, email, cpf;

    private int idade, numeroFilhos;

    private boolean ehTrabalhadorNoturno;

    private double salario;

    public double salarioLiquido() {
        return salario - inss() + bonusPorFilho() + trabalhadorNoite();    
    }

    private double trabalhadorNoite() {
        return ehTrabalhadorNoturno ? 0.06 * salario : 0;
    }

    private double bonusPorFilho() {
        return (numeroFilhos >= 3) ? 150 : numeroFilhos * 50;
    }

    private double inss() {
        return salario * 0.13;
    }

    
}

