import { Injectable } from "@angular/core";
import { BaseService } from "./base.service";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ServicesURL } from "./services-url-util";

@Injectable()
export class ObterPessoaService extends BaseService {

    constructor(private httpChild: HttpClient) {
        super(httpChild);
    }

    getPessoasPaginadas(page: string, size: string) {
        return this.get(ServicesURL.OBTER_TODAS_PESSOAS, [page, size]);
    }

    getPessoasPorId(id: any) {
        return this.get(ServicesURL.OBTER_PESSOA_ID, [id]);
    }

    excluirPessoa(id: any) {
        return this.delete(ServicesURL.EXCLUIR_PESSOA, [id]);
    }

    salvarPessoa(pessoa: any) {
        if (!pessoa.id) {
            return this.post(pessoa, ServicesURL.SALVAR_PESSOA, []);
        }
        return this.put(pessoa, ServicesURL.ATUALIZAR_PESSOA, [pessoa.id]);
    }
}