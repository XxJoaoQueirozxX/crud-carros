# SISTEMA DE CADASTRO DE VEICULOS

Sistema de CRUD de veiculos

## RECURSOS DISPONIVEIS
   - Veiculos

## ENDPOINTS
   #### Utilitarios
   - /h2-console -> Banco de dados em memoria (H2)
   - /swagger-ui/ -> Documentação da API explicando sobre as requisições suas possiveis respostas e os dados para as requisições
   
   
   #### Recurso de veiculos
   - /veiculos (GET) -> retorna todos os veiculos permitindo filtro por query params
   - /veiculos (POST) -> cadastra um novo veiculo no banco
   - /veiculos/{id} (GET) -> retorna o veiculo ao qual o id informado pertence
   - /veiculos/{id} (PUT) -> atualiza o veiculo com o id informado utilizando os dados passados no corpo da requisição
   - /veiculos/{id} (DELETE) -> deleta o veiculo com o id informado