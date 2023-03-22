package br.com.aula.academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.academico.model.Pessoa;
import br.com.aula.academico.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired // Entrega o objeto ja pronto (Ex: pessoa1 = new Pessoa())
    PessoaService pService;


    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable int id) { // Return entity type USER
        Pessoa obj = PessoaService.procuraPessoa(id);
        return ResponseEntity.ok().body(obj);
    } 

    
    @PostMapping()
    public double calculaSalario(@RequestBody Pessoa pess) {

        double salario = pService.pessoaValida(pess);

        return salario;
    }
    // RequesParam - localhost:8080/pessoa/{id}/reajust?salario=1000,00
    @PatchMapping("/{id}/reajuste")
    public double editPessoa(@PathVariable(required = true) int id, @RequestParam(name="novosalario", required = true) double newSalario) {

        return pService.reajuste(id, newSalario);   
        }

}
