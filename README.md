Sistema CRUD Java + MySQL – Cavaleiros Reencarnados
Descrição
Projeto de sistema CRUD desenvolvido em Java para gerenciamento dos dados do universo “Cavaleiros Reencarnados”. O banco de dados MySQL está hospedado na plataforma Aiven, permitindo conexão remota segura pela internet. O sistema permite criar, listar, editar e excluir registros das principais entidades do universo, garantindo a integridade e organização dos dados.

Tecnologias Utilizadas
Linguagem Java (JDK 11 ou superior)

Banco de Dados MySQL hospedado na nuvem (Aiven)

JDBC (Java Database Connectivity) para conexão entre Java e MySQL

Interface simples via linha de comando (CLI) para facilitar interação

Estrutura do Banco de Dados
O banco contém cinco tabelas principais, todas relacionadas:

CONSTELACOES: dados sobre as constelações dos cavaleiros

ARMADURAS: informações das armaduras usadas

CAVALEIROS: cadastro dos cavaleiros com suas características e referências às constelações e armaduras

ERAS: diferentes períodos históricos das reencarnações

REENCARNACOES: registros das reencarnações de cada cavaleiro em diferentes eras

Todas as tabelas seguem as regras de normalização para garantir consistência e evitar redundância.

Como o Sistema Funciona
O sistema realiza operações CRUD completas em todas as tabelas. É possível:

Criar novos registros inserindo dados via terminal

Listar todos os registros existentes para consulta

Atualizar informações específicas de qualquer registro

Excluir registros indesejados, mantendo a integridade referencial

Preparação para Apresentação
O banco de dados está hospedado na nuvem, evitando a necessidade de instalação local do MySQL.

Basta ter o Java instalado no computador que será usado para a apresentação.

A aplicação conecta diretamente ao banco remoto, bastando inserir as credenciais corretas configuradas no código.

Essa abordagem permite executar o sistema em qualquer máquina com acesso à internet.

O projeto está organizado de forma simples, sem pacotes, facilitando entendimento e edição.

Estrutura do Projeto
Arquivo principal: Main.java

Classe responsável pela conexão: conexão via JDBC com MySQL Aiven

Funções CRUD para cada tabela implementadas no Main

Scripts SQL para criação das tabelas e inserção de dados estão incluídos no repositório
