import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

export const routes: Routes = [
  {
    path: 'pessoa',
    children: [
      { path: '', pathMatch: 'full', loadChildren: './pessoa/pessoa.module#PessoaModule' },
      { path: ':id', pathMatch: 'full', loadChildren: './pessoa/pessoa.module#PessoaModule' }
    ]
  },
  {
    path: '',
    pathMatch: 'full',
    loadChildren: './lista-pessoa/lista-pessoa.module#ListaPessoaModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  constructor() {
     
  }

}
