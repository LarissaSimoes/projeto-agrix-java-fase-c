# Agrix - Sistema de Gestão de Fazendas e Plantações

Agrix é um sistema que visa melhorar a eficiência no cultivo de plantações, reduzindo o desperdício de recursos e promovendo práticas agrícolas mais sustentáveis.

## Funcionalidades

O projeto Agrix será desenvolvido em fases, e atualmente (fase A) inclui as seguintes funcionalidades:

1. **Cadastrar Fazendas**:
   - Rota POST `/farms` para cadastrar fazendas.

2. **Listar Fazendas**:
   - Rota GET `/farms` para listar todas as fazendas cadastradas.

3. **Detalhes de Fazenda**:
   - Rota GET `/farms/{id}` para obter informações sobre uma fazenda específica.

4. **Cadastrar Plantações**:
   - Rota POST `/farms/{farmId}/crops` para criar plantações em uma fazenda.

5. **Listar Plantações de Fazenda**:
   - Rota GET `/farms/{farmId}/crops` para listar as plantações de uma fazenda.

6. **Listar Todas as Plantações**:
   - Rota GET `/crops` para listar todas as plantações cadastradas.

7. **Detalhes de Plantação**:
   - Rota GET `/crops/{id}` para obter informações sobre uma plantação específica.

8. **Ajuste da rota POST /farms/{farmId}/crops para utilizar datas**:
   - Ajuste da rota POST `/farms/{farmId}/crops` (para incluir dois atributos novos):
- plantedDate, representando a data em que a plantação foi semeada.
- harvestDate, representando a data em qua a plantação foi ou está prevista para ser colhida.

9. **Ajuste da rota GET /farms/{farmId}/crops para utilizar datas (plantedDate e harvestDate)**:
   - Rota GET `/farms/{farmId}/crops` agora traz plantedDate e harvestDate. 

10. **Ajuste da rota GET /crops para utilizar datas (plantedDate e harvestDate)**:
   - Rota GET `/crops` agora traz plantedDate e harvestDate.

11. **Ajuste da rota GET /crops/{id} para utilizar datas (plantedDate e harvestDate)**:
   - Rota GET `/crops/{id}` agora traz plantedDate e harvestDate.

12. **Rota GET /crops/search para busca de plantações**:
   - Rota GET `/crops/search` que recebe dois parâmetros por query string para busca (start: data de início e end: data de fim).
   - Retorna uma lista com as plantações nas quais o campo harvestDate esteja entre as data de início e de fim.

13. **Rota POST /fertilizers**:
   - Rota POST `/fertilizers` que recebe via corpo do POST os dados de um fertilizante.
   - Deve salvar um novo fertilizante a partir dos dados recebidos.

14. **Rota GET /fertilizers**:
   - Rota GET `/fertilizers` que retorna uma lista de todos os fertilizantes cadastrados.

15. **Rota GET /fertilizers/{id}**:
   - Rota GET `/fertilizers/{id}`  que recebe o id de um fertilizante pelo caminho da rota.
   - Caso exista o fertilizante com o id recebido, deve retornar seus dados, incluindo seu id.

16. **Rota POST /crops/{cropId}/fertilizers/{fertilizerId}**:
   - Rota POST `/crops/{cropId}/fertilizers/{fertilizerId}` que faz a associação entre uma plantação e um fertilizante.

17. **Rota GET /crops/{cropId}/fertilizers**:
   - Rota GET `/crops/{cropId}/fertilizers` que lista os fertilizante associados a uma plantação.

18. **Rota POST /persons**:
   - Rota POST `/persons` para salvar novas pessoas da equipe de trabalho no banco de dados.

19. **Foi adicionada autenticação no projeto, incluindo uma rota para login que retorna um JWT**:
    - Foi feita a configuração do Spring Security e implementou-se a autenticação por usuário e senha.

20. **Limitação de acesso às rotas GET /farms, GET /crops e GET /fertilizers**:
    - Foi limitado o acesso à rota GET /farms para que apenas uma pessoa autenticada com role USER, MANAGER ou ADMIN possa acessar.
    - Foi imitado o acesso à rota GET /crops para que apenas uma pessoa autenticada com role MANAGER ou ADMIN possa acessar.
    - Foi limitado o acesso à rota GET /fertilizers para que apenas uma pessoa autenticada com role ADMIN possa acessar.


## Tecnologias Utilizadas

O projeto Agrix utiliza as seguintes tecnologias e frameworks:

- **Spring Boot**: Para criar a aplicação e disponibilizar as APIs.

- **Spring Data JPA**: Para a camada de persistência e acesso ao banco de dados.

- **Docker**: Para configurar a aplicação para execução em contêineres Docker.

## Como executar o projeto

<br/>

```bash
# Clone ou baixe o repositório
git clone git@github.com:LarissaSimoes/projeto-agrix-java-fase-c.git
# Entre no diretório
cd project-agrix-java-fase-c
# Instale as dependências
mvn install -DskipTests
# Execute a aplicação
Executar a Classe Principal (AgrixApplication.java)
```

<br /><hr /><br />

<p align='center'>
  Desenvolvido por <b>Larissa Simões</b>
  <br/><br/>

  <a href="https://www.linkedin.com/in/dev-larissa-carneiro-simoes/">
    <img alt="linkedIn" height="30px" src="https://i.imgur.com/TQRXxhT.png" />
  </a>
  &nbsp;&nbsp;
</p>

