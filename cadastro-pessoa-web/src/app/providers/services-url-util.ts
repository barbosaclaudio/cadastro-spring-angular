export enum ServicesURL {
    OBTER_TODAS_PESSOAS = <any>'/pessoa?page={page}&size={size}',
    OBTER_PESSOA_ID = <any>'/pessoa/{id}',
    SALVAR_PESSOA = <any>'/pessoa',
    ATUALIZAR_PESSOA = <any>'/pessoa/{id}/atualizar',
    EXCLUIR_PESSOA = <any>'/pessoa/excluir/{id}',
}