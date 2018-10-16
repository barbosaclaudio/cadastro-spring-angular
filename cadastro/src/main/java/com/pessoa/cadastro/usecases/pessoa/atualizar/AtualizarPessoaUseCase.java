package com.pessoa.cadastro.usecases.pessoa.atualizar;

public interface AtualizarPessoaUseCase {

    Long execute(Long id, String nome, String telefone);
}
