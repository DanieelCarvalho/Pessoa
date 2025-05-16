package br.com.api.pessoa.repositorio.servico;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.api.pessoa.modelo.PessoaModelo;
import br.com.api.pessoa.repositorio.PessoaRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaServico {
    
    // Atributo da classe
    private final PessoaRepositorio pr;

     //Método responsável pela listagem de pessoas
   
    public ResponseEntity<Iterable<PessoaModelo>> listarPessoas(){
        return new ResponseEntity<>( this.pr.findAll(), HttpStatus.OK);
    }

    //Método responsável pelo cadastro de pessoas
    
    public ResponseEntity<PessoaModelo> cadastrarPessoa( PessoaModelo pm){

        return new ResponseEntity<>(this.pr.save(pm), HttpStatus.CREATED);

    }

    // Método responsável pela alteração total dos dados
   
    public ResponseEntity<PessoaModelo> alterarPessoaTotal(Long codigo,PessoaModelo pm){

        //Obter o registro contido na tabela
        Optional<PessoaModelo> obj = this.pr.findById(codigo);

        //Condicional
        if(obj.isPresent()){
            pm.setCodigo(codigo);
           return new ResponseEntity<>(this.pr.save(pm), HttpStatus.OK);
        }

        // Caso não exista
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       
    }

    // Método responsável pela alteração parcial dos dados
   
    public ResponseEntity<PessoaModelo> alteracaoParcial(Long codigo,  PessoaModelo pm){

        //Obter o registro contido na tabela

        Optional<PessoaModelo> obj = this.pr.findById(codigo);

        if (obj.isPresent()) {
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
           return new ResponseEntity<>(this.pr.save(pm2), HttpStatus.OK);

        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Método responsável pela remoção de pessoas


    public ResponseEntity<Void> removerPessoa(Long codigo){
        
        //verificar a existencia do codigo 
        boolean existeCodigo = this.pr.existsById(codigo);
        
        if (existeCodigo) {
            this.pr.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //Método para testar as funcionalidades implementadas no repositório 
    // public Long teste(String cidade){

    //     return this.pr.calcularSomaIdades();
    // }

}
