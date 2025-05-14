package br.com.api.pessoa.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.pessoa.modelo.PessoaModelo;
import br.com.api.pessoa.repositorio.PessoaRepositorio;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor //4° maneira de injetar dependência. Basta ter uma atributo com "final"
public class PessoaControle {

    //@Autowired 1° maneira de injetar dependência
    private final PessoaRepositorio pr;
    
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
    public Iterable<PessoaModelo> listarPessoas(){
        return this.pr.findAll();
    }

    //Rota responsável pelo cadastro de pessoas
    @PostMapping("/")
    public PessoaModelo cadastrarPessoa(@RequestBody PessoaModelo pm){

        return this.pr.save(pm);

    }

    // Rota responsável pela alteração total dos dados
    @PutMapping("/{codigo}")
    public PessoaModelo alterarPessoaTotal(@PathVariable Long codigo, @RequestBody PessoaModelo pm){

        pm.setCodigo(codigo);
        return this.pr.save(pm);
    }

    // Rota responsável pela alteração parcial dos dados
    @PatchMapping("/{codigo}")
    public PessoaModelo alteracaoParcial(@PathVariable Long codigo, @RequestBody PessoaModelo pm){

        //Obter o registro contido na tabela

        Optional<PessoaModelo> obj = this.pr.findById(codigo);

        // Converter Optional para PessoaModelo

        PessoaModelo pm2 = obj.get();

        // Verificação
        if (pm.getNome() != null) {
            pm2.setNome(pm.getNome());
        }
         if (pm.getIdade() != null) {
            pm2.setIdade(pm.getIdade());
        }
         if (pm.getCidade() != null) {
            pm2.setCidade(pm.getNome());
        }

        // Retorno
        return this.pr.save(pm2);


    }

    //Rota responsável pela remoção de pessoas

    @DeleteMapping("/{codigo}")
    public void removerPessoa(@PathVariable Long codigo){
        this.pr.deleteById(codigo);
    }
    

}
