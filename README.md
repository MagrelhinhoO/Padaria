📋 Sistema de Gerenciamento de Padaria - API RESTful
Um sistema back-end completo para gerenciamento de padaria, desenvolvido em Spring Boot, com operações CRUD para clientes, produtos, vendas, fornecedores e administradores.

🚀 Tecnologias Utilizadas
Java 17+ (ou versão compatível com Spring Boot 3.2.0)

Spring Boot 3.2.0

Spring Data JPA (Banco de dados H2 em memória)

Lombok (Para reduzir boilerplate code)

Hibernate Validator (Validações de entrada)

Maven (Gerenciamento de dependências)

Postman (Testes da API)

📌 Funcionalidades
✅ Clientes

Cadastro, edição, exclusão e listagem de clientes

Busca por nome ou CPF

✅ Produtos

Controle de estoque e preços

Busca por nome, preço máximo ou estoque baixo

✅ Vendas

Registro de vendas com cálculo automático do valor total

Relação N-N com produtos (uma venda pode ter vários produtos)

Histórico por cliente ou período

✅ Fornecedores

Cadastro e gerenciamento de fornecedores

Relação com produtos (1-N)

✅ Administradores

Gerenciamento de usuários admin



Você pode testar a API usando o Postman com os seguintes endpoints:

CLIENTES:

Exemplo:

{
  "nome": "João Silva",
  "cpf": "123.456.789-00",
  "telefone": "(11) 99999-9999"
}

GET /api/clientes - Listar todos

GET /api/clientes/{id} - Buscar por ID

POST /api/clientes - Criar novo

PUT /api/clientes/{id} - Atualizar

DELETE /api/clientes/{id} - Deletar

GET /api/clientes/buscar?nome={nome} - Buscar por nome

ADMINISTRADORES:


GET /api/administradores - Listar todos

GET /api/administradores/{id} - Buscar por ID

POST /api/administradores - Criar novo

PUT /api/administradores/{id} - Atualizar

DELETE /api/administradores/{id} - Deletar

GET /api/administradores/buscar?nome={nome} - Buscar por nome

PRODUTOS:


GET /api/produtos - Listar todos

GET /api/produtos/{id} - Buscar por ID

POST /api/produtos - Criar novo

PUT /api/produtos/{id} - Atualizar

DELETE /api/produtos/{id} - Deletar

GET /api/produtos/buscar?nome={nome} - Buscar por nome

GET /api/produtos/preco-maximo?preco={preco} - Buscar por preço máximo

GET /api/produtos/estoque-baixo?quantidade={quantidade} - Buscar produtos com estoque baixo

VENDAS:


GET /api/vendas - Listar todos

GET /api/vendas/{id} - Buscar por ID

POST /api/vendas - Criar nova

PUT /api/vendas/{id} - Atualizar

DELETE /api/vendas/{id} - Deletar

GET /api/vendas/periodo?inicio={inicio}&fim={fim} - Buscar por período

GET /api/vendas/cliente/{clienteId} - Buscar por cliente

FORNECEDORES:


GET /api/fornecedores - Listar todos

GET /api/fornecedores/{id} - Buscar por ID

POST /api/fornecedores - Criar novo

PUT /api/fornecedores/{id} - Atualizar

DELETE /api/fornecedores/{id} - Deletar

GET /api/fornecedores/buscar?nome={nome} - Buscar por nome
