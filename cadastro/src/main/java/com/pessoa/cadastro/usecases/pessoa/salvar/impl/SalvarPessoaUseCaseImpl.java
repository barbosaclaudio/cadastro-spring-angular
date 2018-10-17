package com.pessoa.cadastro.usecases.pessoa.salvar.impl;

import com.pessoa.cadastro.core.model.Pessoa;
import com.pessoa.cadastro.core.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.salvar.SalvarPessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarPessoaUseCaseImpl implements SalvarPessoaUseCase {

    private PessoaRepository pessoaRepository;

    @Autowired
    public SalvarPessoaUseCaseImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Long execute(String nome, String telefone) {
        Pessoa pessoa = new Pessoa(null, nome, telefone);
        Pessoa pessoaSaved = pessoaRepository.save(pessoa);
        return pessoaSaved.getId();
    }
}
