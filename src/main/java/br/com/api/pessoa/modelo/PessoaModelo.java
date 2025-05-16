package br.com.api.pessoa.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Nome inválido!")
    @Size(min = 3 , max = 30, message = "O nome deve ter entre 3 e 30 caracteres")
    private String nome;

    @NotNull(message = "Idade inválida!")
    @Min(value = 0, message   = "A idade minima permitida é 0")
    @Max(value = 120, message = "A idade máxima permitida é 120")
    private Integer    idade;

    @NotBlank(message   = "Cidade inválido!")
    @Size(min = 3 , max = 30, message = "O nome da cidade deve ter entre 3 e 30 caracteres")
    private String cidade;




    
}
