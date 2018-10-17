package com.pessoa.cadastro.usecases.pessoa.obter.impl;

import com.pessoa.cadastro.core.model.Pessoa;
import com.pessoa.cadastro.core.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterTodasPessoasUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObterTodasPessoasUseCaseImpl implements ObterTodasPessoasUseCase {

    private PessoaRepository pessoaRepository;

    @Autowired
    public ObterTodasPessoasUseCaseImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    @Override
    public PageDTO execute(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        Page<Pessoa> pessoasPageable = pessoaRepository.findAll(pageRequest);
        List<Pessoa> pessoas = pessoasPageable.getContent();
        List<PessoaDTO> pessoasDTO = pessoas.stream().map(p -> new PessoaDTO(p.getId(), p.getNome(),
                                                                    p.getTelefone())).collect(Collectors.toList());
        PageDTO pageDTO = new PageDTO(pessoasPageable.getTotalPages(),
                                            pessoasPageable.getSize(), pessoasPageable.getTotalElements(), pessoasDTO);
        return pageDTO;
    }
}
