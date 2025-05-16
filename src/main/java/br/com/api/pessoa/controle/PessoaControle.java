package br.com.api.pessoa.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.pessoa.modelo.PessoaModelo;
import br.com.api.pessoa.repositorio.servico.PessoaServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor //4° maneira de injetar dependência. Basta ter uma atributo com "final"
public class PessoaControle {

    //@Autowired 1° maneira de injetar dependência
    private final PessoaServico ps;
    
    // @Autowired 2° maneira de injetar dependência
    // public void setPessoaRepositorio(PessoaRepositorio pr){
    //     this.pr = pr;
    // }

    // 3° maneira e a mais "correta"
    // public PessoaControle(PessoaRepositorio pr) {
    //     this.pr = pr;
    // }
    

    //Rota responsável pela listagem de pessoas
    @GetMapping("/")
    public ResponseEntity<Iterable<PessoaModelo>> listarPessoas(){

       return this.ps.listarPessoas();
    }

    //Rota responsável pelo cadastro de pessoas
    @PostMapping("/")
    public ResponseEntity<PessoaModelo> cadastrarPessoa(@Valid @RequestBody PessoaModelo pm){

        return this.ps.cadastrarPessoa(pm);
    }

    // Rota responsável pela alteração total dos dados
    @PutMapping("/{codigo}")
    public ResponseEntity<PessoaModelo> alterarPessoaTotal(@PathVariable Long codigo,@Valid @RequestBody PessoaModelo pm){

        return this.ps.alterarPessoaTotal(codigo, pm);
    }

    // Rota responsável pela alteração parcial dos dados
    @PatchMapping("/{codigo}")
    public ResponseEntity<PessoaModelo> alteracaoParcial(@PathVariable Long codigo, @RequestBody PessoaModelo pm){

        return this.ps.alteracaoParcial(codigo, pm);
    }

    //Rota responsável pela remoção de pessoas

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerPessoa(@PathVariable Long codigo){

        return this.ps.removerPessoa(codigo);
    }

    //Rota responsável pelos testes 
    // @GetMapping("/teste")
    // public Long teste(){

    //     return this.ps.teste("São Paulo");
    // }


    

}
