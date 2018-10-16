package com.pessoa.cadastro.repository;

import com.pessoa.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
