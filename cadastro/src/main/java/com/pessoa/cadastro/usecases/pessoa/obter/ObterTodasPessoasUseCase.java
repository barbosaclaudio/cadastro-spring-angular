package com.pessoa.cadastro.usecases.pessoa.obter;

import com.pessoa.cadastro.usecases.pessoa.obter.impl.PageDTO;

public interface ObterTodasPessoasUseCase {

    PageDTO execute(int page, int size);

}
