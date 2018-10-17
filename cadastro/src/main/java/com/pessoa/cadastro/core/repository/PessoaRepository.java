package com.pessoa.cadastro.core.repository;

import com.pessoa.cadastro.core.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
