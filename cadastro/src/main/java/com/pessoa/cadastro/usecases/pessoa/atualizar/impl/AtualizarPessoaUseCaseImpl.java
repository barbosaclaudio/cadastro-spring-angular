package com.pessoa.cadastro.usecases.pessoa.atualizar.impl;

import com.pessoa.cadastro.core.model.Pessoa;
import com.pessoa.cadastro.core.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.atualizar.AtualizarPessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPessoaUseCaseImpl implements AtualizarPessoaUseCase {

    private PessoaRepository pessoaRepository;

    @Autowired
    public AtualizarPessoaUseCaseImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Long execute(Long id, String nome, String telefone) {
        Pessoa pessoa = new Pessoa(id, nome, telefone);
        Pessoa pessoaSaved = this.pessoaRepository.save(pessoa);
        return pessoaSaved.getId();
    }


}
