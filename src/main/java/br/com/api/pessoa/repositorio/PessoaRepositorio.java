package br.com.api.pessoa.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.pessoa.modelo.PessoaModelo;

@Repository
public interface PessoaRepositorio extends CrudRepository<PessoaModelo, Long> {
    

    Iterable<PessoaModelo> findByCidade(String cidade);

    Iterable<PessoaModelo> findByCidadeOrCidade(String cidade1, String cidade2);

    Iterable<PessoaModelo> findByIdadeGreaterThanEqual(Integer idade);

    Iterable<PessoaModelo> findByIdadeBetween(Integer idade1, Integer idade2);

    Iterable<PessoaModelo> findByNomeLike(String nome);

    Iterable<PessoaModelo> findByNomeLikeIgnoreCase(String nome);

    Iterable<PessoaModelo> findAllByOrderByNomeAsc();

    Long countByCidade(String cidade);

    @Query("SELECT SUM(p.idade FROM PessoaModelo p)")
    Long calcularSomaIdades();



}
