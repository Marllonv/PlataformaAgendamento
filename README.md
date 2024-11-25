# Sistema de Agendamentos - Arcomix

Repositório com o back-end desenvolvido para o sistema de agendamentos de entregas de fornecedores para a empresa Arcomix.

## Instalação

1. Clone o repositório.

2. Utilize o MAVEN com a função package para instalar as dependencias da aplicação.

3. Baixe o Banco de Dados MySQL[site oficial](https://www.mysql.com/downloads/)para poder prossegir com a instalação do Banco de Dados.

4. Crie uma host do banco de dados local ou online localizado no repositorio.

## Servindo Localmente

Configure o arquivo [application.properties](src/main/resources/application.properties) com as configurações locais de sua maquina para criar a conexão com o Banco de Dados, após isso iniciar o serviço do Banco de Dados.

Para iniciar a plataforma basta dar RUN no arquivo [PlataformaApplication.java](src/main/java/com/example/demo/PlataformaApplication.java).

## Utilizando

Para logar, observe as opções de login presentes
em [D:\faculdade2\demo\PlataformaAgendamento\Registros\REGISTRO_FORNECEDORES.txt](Registros/REGISTRO_FORNECEDORES.txt)
(para os logins dos Fornecedores) ou [REGISTROS_COLABORADORES.txt](Registros/REGISTROS_COLABORADORES.txt)(para os logins dos Colaboradores)

## Usando o sistema
1. AuthController.java
  /auth: é um endpoint para autenticação

  /auth/login: é um endpoint de login(processo para acessar um sistema informático restrito). Quando uma requisição POST é feita, o código recebe as credenciais de um usuário(LOGIN e SENHA) e as valida utilizando o mecanismo de autenticação do Spring Security. Se as credenciais forem válidas, um token JWT (JSON Web Token) é gerado e retornado ao cliente. 

  /auth/register/colaborador: é um endpoint para registrar novos colaboradores em um sistema. Quando uma requisição POST é enviada, os dados do novo colaborador (como matrícula, senha, nome e email) são recebidos e validados. A senha é criptografada antes de ser armazenada, garantindo a segurança dos dados.

  /auth/register/fornecedor: é um endpoint para registrar novos fornecedores em um sistema. Quando uma requisição POST é enviada, os dados do novo fornecedor (como ID, senha, razão social, nome fantasia, CNPJ e papel) são recebidos e validados. A senha é criptografada antes de ser armazenada, garantindo a segurança dos dados.

2. SolicitacaoController.java
  /solicitacao: é um endpoint que trata as solicitações de agendamento

  /solicitacao/criar: é um endpoint para criar novas solicitações no sistema. Quando uma requisição POST é enviada, os dados da nova solicitação são recebidos e utilizados para criar um novo objeto de solicitação. Este objeto é então salvo no banco de dados, registrando a nova solicitação.

  /solicitacao/buscar: é um endpoint para buscar todas as solicitações registradas no sistema. Ao receber uma requisição GET, o código busca todas as solicitações armazenadas no banco de dados através do repositório. Em seguida permitindo que o cliente da aplicação acesse todas as solicitações existentes.

3. FornecedorController.java
  /fornecedor: é um endpoint que destina funções que um usario fornecedor pode fazer.

  /fornecedor/minhas-solicitacoes: o sistema verifica a identidade do usuário logado. Se este usuário for um fornecedor, o endpoint consulta o banco de dados e retorna uma lista de todas as solicitações que foram associadas a este fornecedor específico. Caso o usuário logado não seja um fornecedor, uma lista vazia é retornada.

  /fornecedor/meus-agendamentos: Este endpoint permite que um fornecedor autenticado visualize a lista de todos os seus agendamentos. Quando um fornecedor acessa este endereço, o sistema verifica a identidade do usuário logado. Se o usuário for de fato um fornecedor, o endpoint consulta o banco de dados para encontrar todos os agendamentos associados a este fornecedor específico.

  /fornecedor/excluir-solicitacao/{id} : Este endpoint permite que um fornecedor autenticado exclua uma solicitação que lhe pertence. O endpoint verifica se a solicitação existe e se o fornecedor logado é o proprietário da mesma. Se ambas as condições forem verdadeiras, a solicitação é excluída do banco de dados e uma resposta de sucesso é enviada. Caso contrário, uma resposta de erro é retornada.

4. ColaboradorController.java
  /colaborador: é um endpoint responsável por retornar uma lista de todos os colaboradores cadastrados no sistema. A consulta é feita ao repositório, e os resultados são mapeados para objetos antes de serem retornados como resposta.

5. AgendamentoController.java

  /agendamento:  responsável por gerenciar operações relacionadas a agendamentos. Ele utiliza os repositórios para interagir com o banco de dados e realizar operações como buscar, criar, atualizar e excluir solicitações e agendamentos.

  /agendamento/criar: Este endpoint permite criar um agendamento a partir de uma solicitação existente. Ele busca a solicitação por ID, cria um agendamento vinculado a ela, salva o agendamento e deleta a solicitação original. Se bem-sucedido, retorna uma resposta positiva, caso contrário, indica que a solicitação não foi encontrada.

  /agendamento/buscar: Este endpoint retorna uma lista de todos os agendamentos cadastrados no sistema. Ele busca todos os agendamentos no repositório e os transforma em objetos para serem retornados como resposta.


## Informações de login

1. FORNECEDOR

  LOGIN: masterboi_0378
	PASSWORD: 12345

  LOGIN: perdigao_8640
	PASSWORD: 544321

  LOGIN: vitarella_0765
	PASSWORD: 1357910

2. COLABORADOR

  LOGIN: 01278012
	PASSWORD: jonparenteses12

  LOGIN: 01278002
	PASSWORD: josejosejose123

  LOGIN": 01277916
	PASSWORD: giiiiO321

  LOGIN: 01277804
	PASSWORD: lucas_Costa!

  LOGIN: 01277902
	PASSWORD: marllon_123
