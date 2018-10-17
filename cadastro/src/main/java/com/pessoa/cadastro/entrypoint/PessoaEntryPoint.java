package com.pessoa.cadastro.entrypoint;

import com.pessoa.cadastro.usecases.pessoa.deletar.DeletarPessoaUseCase;
import com.pessoa.cadastro.usecases.pessoa.atualizar.AtualizarPessoaUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterPessoaPorIdUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.ObterTodasPessoasUseCase;
import com.pessoa.cadastro.usecases.pessoa.obter.PessoaDTO;
import com.pessoa.cadastro.usecases.pessoa.obter.impl.PageDTO;
import com.pessoa.cadastro.usecases.pessoa.salvar.SalvarPessoaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("pessoa")
public class PessoaEntryPoint extends GenericController {

    private ObterTodasPessoasUseCase obterTodasPessoasUseCase;
    private ObterPessoaPorIdUseCase obterPessoaPorIdUseCase;
    private SalvarPessoaUseCase salvarPessoaUseCase;
    private AtualizarPessoaUseCase atualizarPessoaUseCase;
    private DeletarPessoaUseCase deletarPessoaUseCase;

    @Autowired
    public PessoaEntryPoint(ObterTodasPessoasUseCase obterTodasPessoasUseCase, ObterPessoaPorIdUseCase obterPessoaPorIdUseCase,
                            SalvarPessoaUseCase salvarPessoaUseCase, AtualizarPessoaUseCase atualizarPessoaUseCase, DeletarPessoaUseCase deletarPessoaUseCase) {
        this.obterTodasPessoasUseCase = obterTodasPessoasUseCase;
        this.obterPessoaPorIdUseCase = obterPessoaPorIdUseCase;
        this.salvarPessoaUseCase = salvarPessoaUseCase;
        this.atualizarPessoaUseCase = atualizarPessoaUseCase;
        this.deletarPessoaUseCase = deletarPessoaUseCase;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> salvarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest, BindingResult result) {
        Long id = this.salvarPessoaUseCase.execute(pessoaRequest.getNome(), pessoaRequest.getTelefone());
        return ResponseEntity.ok(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PessoaResponse> obterPessoaPorId(@PathVariable("id") Long id) {
        PessoaDTO pessoaDTO = this.obterPessoaPorIdUseCase.execute(id);
        PessoaResponse pessoaResponse = buildPessoaResponse(pessoaDTO.getId(), pessoaDTO.getNome(), pessoaDTO.getTelefone());
        return ResponseEntity.ok(pessoaResponse);
    }

    @RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarPessoa(@PathVariable("id") Long id) {
        this.deletarPessoaUseCase.execute(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PageDTO> obterPessoasPaginadas(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) {
        PageDTO execute = this.obterTodasPessoasUseCase.execute(page, size);
        return ResponseEntity.ok(execute);
    }

    @RequestMapping(value = "/{id}/atualizar", method = RequestMethod.PUT)
    public ResponseEntity<Long> atualizarPessoa(@PathVariable("id") Long id, @RequestBody PessoaRequest pessoaRequest) {
        Long idPessoa = this.atualizarPessoaUseCase.execute(pessoaRequest.getId(), pessoaRequest.getNome(), pessoaRequest.getTelefone());
        return ResponseEntity.ok(idPessoa);
    }

    private PessoaResponse buildPessoaResponse(Long id, String nome, String telefone) {
        return new PessoaResponse(id, nome, telefone);
    }


}
