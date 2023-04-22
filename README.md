# HTTP Requests
### Cadastrar vendedor - POST
/vendedores
```sh
{
    "nome" : "Pedro"
}
```
#
### Cadastrar venda - POST
/vendas
```sh
{
    "valor" : 500.90,
    "vendedor" : 1 // ID de um vendedor já cadastrado
}
```
#
### Listar vendedores conforme o período informado por parâmetro - GET
/vendedores/listar?dataInicial=2023-04-20&dataFinal=2023-04-16
