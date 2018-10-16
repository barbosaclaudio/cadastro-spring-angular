package com.pessoa.cadastro.entrypoint;

public class PessoaResponse {

    private final Long id;
    private final String nome;
    private final String telefone;

    public PessoaResponse(Long id, String nome, String telefone) {
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
