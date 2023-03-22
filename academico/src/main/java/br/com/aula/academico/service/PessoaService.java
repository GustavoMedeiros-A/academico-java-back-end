package br.com.aula.academico.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.aula.academico.model.Pessoa;

@Service
public class PessoaService {
    
    static ArrayList<Pessoa> lista  = new ArrayList<>();
    static {
        lista.add(new Pessoa(1, "zezin", "ze@ze", "111", 20, 0, false, 1000));
        lista.add(new Pessoa(2, "luigi", "ze@ze", "111", 20, 0, false, 1000));
        lista.add(new Pessoa(3, "mario", "ze@ze", "111", 20, 0, false, 1000));
    }
    
    
    public double pessoaValida(Pessoa pessoa) {

        if(pessoa.getNome().isBlank()) {
            return 0;
        }
        if(pessoa.getCpf().length() != 11) {
            return 0;
        }
        return pessoa.salarioLiquido();
    }

    public double reajuste(int id, double newSalario) {
        Pessoa p = procuraPessoa(id);
        if (p == null) {
            return 0;
        }
        p.setSalario(newSalario);
        return p.salarioLiquido();
        
    }

    public static Pessoa procuraPessoa(int id){
        for(Pessoa p: lista) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
