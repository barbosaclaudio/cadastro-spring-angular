package com.pessoa.cadastro.usecases.pessoa.obter.impl;

import com.pessoa.cadastro.core.model.Pessoa;
import com.pessoa.cadastro.core.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterPessoaPorIdUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObterPessoaPorIdUseCaseImpl implements ObterPessoaPorIdUseCase {

    private PessoaRepository pessoaRepository;

    @Autowired
    public ObterPessoaPorIdUseCaseImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public PessoaDTO execute(Long id) {
        Optional<Pessoa> pessoaById = pessoaRepository.findById(id);
        if(!pessoaById.isPresent()) {
            return null;
        }
        Pessoa pessoa = pessoaById.get();
        return new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone());
    }


}
