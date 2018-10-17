import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ObterPessoaService } from '../providers/obter-pessoa.service';

@Component({
  selector: 'app-pessoa',
  templateUrl: './pessoa.component.html',
  styleUrls: ['./pessoa.component.css']
})
export class PessoaComponent implements OnInit {
  
  pessoa:any = {}  

  constructor(private activedRouter: ActivatedRoute, 
              private pessoaService:ObterPessoaService,
              private router: Router) {
    
   }

  ngOnInit() {
    let id = this.activedRouter.snapshot.params["id"];
    if(id) {
      this.getPessoa(id);
    }
  }

  salvar() {
    this.pessoaService.salvarPessoa(this.pessoa).subscribe(data=>{
      console.log(data)
    })
  }

  excluir() {
    this.pessoaService.excluirPessoa(this.pessoa.id).subscribe(data=> {
  
    })
  }

  navegarParaHome() {
    this.router.navigate(['/']);
  }

  getPessoa(id:any) {
    this.pessoaService.getPessoasPorId(id).subscribe(data=>{
      this.pessoa = {
        id : data.id,
        nome : data.nome,
        telefone : data.telefone
      }
    })
  }

}
