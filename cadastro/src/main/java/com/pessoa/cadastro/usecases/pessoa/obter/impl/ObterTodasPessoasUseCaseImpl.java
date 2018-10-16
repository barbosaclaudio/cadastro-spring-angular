package com.pessoa.cadastro.usecases.pessoa.obter.impl;

import com.pessoa.cadastro.model.Pessoa;
import com.pessoa.cadastro.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterTodasPessoasUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ObterTodasPessoasUseCaseImpl implements ObterTodasPessoasUseCase {

    private PessoaRepository pessoaRepository;

    @Autowired
    public ObterTodasPessoasUseCaseImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    @Override
    public Page<PessoaDTO> execute() {
        Page<Pessoa> pessoas = pessoaRepository.findAll((Pageable) null);
        return null;
    }
}
