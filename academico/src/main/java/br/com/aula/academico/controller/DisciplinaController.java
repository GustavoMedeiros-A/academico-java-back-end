package br.com.aula.academico.controller;

import java.time.LocalDate;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.core.net.SyslogOutputStream;

import br.com.aula.academico.model.Disciplina;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // http status to validate
    public Disciplina saveDisciplina(@RequestBody @Valid Disciplina disciplina) { //@valid deve ser colocado para considerar as validações colocadas na classe
        System.out.println(disciplina.getNome());
        disciplina.setDataCriacao(LocalDate.now());

        return disciplina;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerException(Exception e) {
        String err = e.getMessage();
        return err.substring(err.lastIndexOf("Default message") + 17, err.length() - 3);
    }
}
