import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import {InputTextModule} from 'primeng/inputtext';
import { SharedModule } from '../utils/shared.module';
import { ListaPessoaComponent } from './lista-pessoa.component';
import { ObterPessoaService } from '../providers/obter-pessoa.service';

const routes = [
    {
        path     : '',
        component: ListaPessoaComponent
    }
];

@NgModule({
    declarations: [
        ListaPessoaComponent
    ],
    imports     : [
        RouterModule.forChild(routes),
        InputTextModule,
        HttpClientModule,
        CommonModule,
        SharedModule
    ],
    exports     : [
        ListaPessoaComponent
    ],
    providers: [
        ObterPessoaService
    ]
})

export class ListaPessoaModule{}