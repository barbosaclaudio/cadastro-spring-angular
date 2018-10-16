package com.pessoa.cadastro.usecases.pessoa.obter;

public class PessoaDTO {

    private final String nome;
    private final String telefone;

    public PessoaDTO(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
