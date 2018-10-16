package com.pessoa.cadastro.entrypoint;

import com.pessoa.cadastro.usecases.pessoa.atualizar.AtualizarPessoaUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterPessoaPorIdUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterTodasPessoasUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;
import com.pessoa.cadastro.usecases.pessoa.salvar.SalvarPessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PessoaEntryPoint {

    private ObterTodasPessoasUseCase obterTodasPessoasUseCase;
    private ObterPessoaPorIdUseCase obterPessoaPorIdUseCase;
    private SalvarPessoaUseCase salvarPessoaUseCase;
    private AtualizarPessoaUseCase atualizarPessoaUseCase;

    @Autowired
    public PessoaEntryPoint(ObterTodasPessoasUseCase obterTodasPessoasUseCase, ObterPessoaPorIdUseCase obterPessoaPorIdUseCase,
                            SalvarPessoaUseCase salvarPessoaUseCase, AtualizarPessoaUseCase atualizarPessoaUseCase) {
        this.obterTodasPessoasUseCase = obterTodasPessoasUseCase;
        this.obterPessoaPorIdUseCase = obterPessoaPorIdUseCase;
        this.salvarPessoaUseCase = salvarPessoaUseCase;
        this.atualizarPessoaUseCase = atualizarPessoaUseCase;
    }

    @PostMapping
    public ResponseEntity<Long> salvarPessoa(PessoaRequest pessoaRequest) {
        Long id = this.salvarPessoaUseCase.execute(pessoaRequest.getNome(), pessoaRequest.getTelefone());
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<Long> atualizarPessoa(PessoaRequest pessoaRequest) {
        Long id = this.atualizarPessoaUseCase.execute(pessoaRequest.getId(), pessoaRequest.getNome(), pessoaRequest.getTelefone());
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<PessoaResponse> obterPessoaPorId(Long id) {
        PessoaDTO pessoaDTO = this.obterPessoaPorIdUseCase.execute(id);
        PessoaResponse pessoaResponse = buildPessoaResponse(pessoaDTO.getId(), pessoaDTO.getNome(), pessoaDTO.getTelefone());
        return ResponseEntity.ok(pessoaResponse);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> obterPessoasPaginadas() {
        Page<PessoaDTO> execute = this.obterTodasPessoasUseCase.execute();
        return null;
    }

    private PessoaResponse buildPessoaResponse(Long id, String nome, String telefone) {
        return new PessoaResponse(id, nome, telefone);
    }


}
