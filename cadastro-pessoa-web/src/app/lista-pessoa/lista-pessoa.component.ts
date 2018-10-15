import { Component, OnInit } from '@angular/core';
import { ObterPessoaService } from './service/obter.pessoa.service';

@Component({
  selector: 'app-lista-pessoa',
  templateUrl: './lista-pessoa.component.html',
  styleUrls: ['./lista-pessoa.component.css']
})
export class ListaPessoaComponent implements OnInit {

  pessoas: any[];

  cols: any[];

  constructor(private obterPessoaService: ObterPessoaService) { }

  ngOnInit() {
      this.obterPessoaService.getPessoasPaginadas().then(pessoas => this.pessoas = pessoas);

      this.cols = [
          { field: 'nome', header: 'Nome' },
          { field: 'telefone', header: 'Telefone' }
      ];
  }

}
