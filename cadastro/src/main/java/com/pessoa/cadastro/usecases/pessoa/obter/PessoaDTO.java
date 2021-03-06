package com.pessoa.cadastro.usecases.pessoa.obter;

public class PessoaDTO {

    private final Long id;
    private final String nome;
    private final String telefone;

    public PessoaDTO(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
