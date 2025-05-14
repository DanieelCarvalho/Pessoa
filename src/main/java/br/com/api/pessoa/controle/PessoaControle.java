package br.com.api.pessoa.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PessoaControle {
    

    @GetMapping("/mensagem")
    public String mensagem() {
        return  "Aprendendo Spring";
    }

    @GetMapping("/apresentacao/{nome}")
    public String apresentacao(@PathVariable String nome){
        return " Olá, "+nome;
    }
    

}
