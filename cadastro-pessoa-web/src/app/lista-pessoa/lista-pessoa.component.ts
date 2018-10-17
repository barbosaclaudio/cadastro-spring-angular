import { Component, OnInit } from '@angular/core';
import { ObterPessoaService } from '../providers/obter-pessoa.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-pessoa',
  templateUrl: './lista-pessoa.component.html',
  styleUrls: ['./lista-pessoa.component.css']
})
export class ListaPessoaComponent implements OnInit {

  pessoas: any[];
  cols: any[];
  totalRecords :number;

  constructor(private router:Router, private obterPessoaService: ObterPessoaService) { }

  ngOnInit() {
      this.cols = [
          { field: 'id', header: 'Id' },
          { field: 'nome', header: 'Nome' },
          { field: 'telefone', header: 'Telefone' }
      ];
  }

  loadPessoasLazy(event: any) {
    let page = event.first/event.rows;
    this.obterPessoaService.getPessoasPaginadas(page.toString() , event.rows).subscribe(data => {
      this.pessoas = data.content;
      this.totalRecords = data.totalDeElementos;
    });
  }

  onRowSelect(event) {
    this.router.navigate(['pessoa', event.data.id]);
}

}
