package com.pessoa.cadastro.usecases.pessoa.obter;

import org.springframework.data.domain.Page;

public interface ObterTodasPessoasUseCase {

    Page<PessoaDTO> execute();

}
