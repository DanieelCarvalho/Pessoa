package br.com.api.pessoa.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class PessoaModelo {
    
    //Atributos

    @Id                                                  //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento 
    private Long   codigo;
    private String nome;
    private Integer    idade;
    private String cidade;




    
}
