import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { PessoaComponent } from './pessoa.component';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import {InputTextModule} from 'primeng/inputtext';
import { SharedModule } from '../utils/shared.module';
import { ObterPessoaService } from '../providers/obter-pessoa.service';
import { SweetAlert2Module } from '@toverux/ngx-sweetalert2';

const routes = [
    {
        path     : '',
        component: PessoaComponent
    }
];

@NgModule({
    declarations: [
        PessoaComponent,
    ],
    imports     : [
        RouterModule.forChild(routes),
        InputTextModule,
        HttpClientModule,
        CommonModule,
        SweetAlert2Module.forRoot(),
        SharedModule
    ],
    exports     : [
        PessoaComponent
    ],
    providers: [
        ObterPessoaService
    ]
})

export class PessoaModule{}