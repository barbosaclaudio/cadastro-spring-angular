package com.pessoa.cadastro.usecases.pessoa.obter.impl;

import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;

import java.util.List;

public class PageDTO {

    private Integer totalDePaginas;
    private Integer size;
    private Long totalDeElementos;
    private List<PessoaDTO> content;

    public PageDTO(Integer totalDePaginas, Integer size, Long totalDeElementos, List<PessoaDTO> content) {
        this.totalDePaginas = totalDePaginas;
        this.size = size;
        this.totalDeElementos = totalDeElementos;
        this.content = content;
    }

    public Integer getTotalDePaginas() {
        return totalDePaginas;
    }

    public Integer getSize() {
        return size;
    }

    public Long getTotalDeElementos() {
        return totalDeElementos;
    }

    public List<PessoaDTO> getContent() {
        return content;
    }
}
