package com.pessoa.cadastro;

import com.pessoa.cadastro.model.Pessoa;
import com.pessoa.cadastro.repository.PessoaRepository;
import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;
import com.pessoa.cadastro.usecases.pessoa.obter.impl.ObterPessoaPorIdUseCaseImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ObterPessoaPorIdUseCaseTest {

    @Test
    public void obterPessoaPorId() {
        Long id = 22L;
        Pessoa pessoa = new Pessoa(id, "Claudio", "123456789");
        PessoaRepository pessoaRepository = Mockito.mock(PessoaRepository.class);
        Mockito.when(pessoaRepository.findById(22L)).thenReturn(Optional.of(pessoa));
        ObterPessoaPorIdUseCaseImpl obterPessoaPorIdUseCase = new ObterPessoaPorIdUseCaseImpl(pessoaRepository);
        PessoaDTO execute = obterPessoaPorIdUseCase.execute(id);
        Assert.assertEquals(id,execute.getId());
    }

}
