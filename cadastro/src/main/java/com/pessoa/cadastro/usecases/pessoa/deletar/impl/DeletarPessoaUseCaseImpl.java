package com.pessoa.cadastro.usecases.pessoa.deletar.impl;

import com.pessoa.cadastro.core.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.deletar.DeletarPessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarPessoaUseCaseImpl implements DeletarPessoaUseCase {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public void execute(Long id) {
        this.pessoaRepository.deleteById(id);
    }
}
