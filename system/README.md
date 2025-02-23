# Desafio: Sistema de Gerenciamento de Eventos
Você deve criar uma API RESTful utilizando Spring Boot que permita gerenciar eventos e participantes. O sistema deve incluir funcionalidades que utilizem os conceitos listados, como manipulação de coleções, algoritmos de busca e ordenação, e as novidades do Java 17.

## Descrição do Sistema
O sistema será responsável por gerenciar eventos e seus participantes. Cada evento terá informações como nome, data, local e uma lista de participantes. Os participantes terão informações como nome, e-mail e idade.

## Funcionalidades da API
### Gerenciar Eventos:

- Criar um evento.
- Listar todos os eventos.
- Buscar eventos por nome (utilizando Binary Search).
- Ordenar eventos por data (utilizando Bubble Sort).
- Atualizar informações de um evento.
- Deletar um evento.

### Gerenciar Participantes:

- Adicionar participantes a um evento.
- Listar participantes de um evento.
- Remover participantes de um evento.
- Verificar duplicidade de participantes (utilizando HashSet).

### Relatórios:

- Listar todos os eventos com mais de X participantes.
- Listar todos os participantes ordenados por idade (utilizando TreeSet).

### Requisitos Técnicos
Configuração Inicial:

### Crie um projeto Spring Boot com as dependências:
- Spring Web
- Spring Data JPA
- H2 Database (ou outro banco de sua escolha)
- Lombok (opcional, para reduzir boilerplate)

### Estrutura do Projeto:

- Controller: Gerenciar as requisições HTTP.
- Service: Implementar a lógica de negócios.
- Repository: Gerenciar a persistência de dados.

### Modelos de Dados:

### Evento:
- id (Long)
- nome (String)
- data (LocalDate)
- local (String)
- participantes (List<Participante>)

### Participante:
- id (Long)
- nome (String)
- email (String)
- idade (int)

### Novidades do Java 17:

- Utilize Records para representar os DTOs (Data Transfer Objects).
- Utilize o switch aprimorado para implementar lógica de validação ou filtros.
- Experimente sealed classes para criar hierarquias de classes, caso necessário.

### Manipulação de Dados:

- Utilize Stream API para filtrar e processar listas.
- Utilize HashMap para armazenar e buscar eventos temporariamente (em memória).
- Utilize TreeSet para ordenar participantes por idade.

### Algoritmos de Busca e Ordenação:

- Implemente o Bubble Sort para ordenar eventos por data.
- Implemente o Binary Search para buscar eventos por nome.

Exemplo de Endpoints
### Eventos:

- POST /eventos: Criar um novo evento.
- GET /eventos: Listar todos os eventos.
- GET /eventos/{nome}: Buscar evento por nome.
- PUT /eventos/{id}: Atualizar informações de um evento.
- DELETE /eventos/{id}: Deletar um evento.

### Participantes:

- POST /eventos/{id}/participantes: Adicionar um participante a um evento.
- GET /eventos/{id}/participantes: Listar participantes de um evento.
- DELETE /eventos/{id}/participantes/{idParticipante}: Remover um participante de um evento.

### Relatórios:

- GET /eventos/relatorio/mais-participantes?min=10: Listar eventos com mais de 10 participantes.
- GET /eventos/{id}/participantes/ordenados: Listar participantes de um evento ordenados por idade.

Dicas para Implementação
Configuração Inicial:

Use o Spring Initializr para criar o projeto.
Configure o banco de dados H2 no arquivo application.properties.
Modelos e Relacionamentos:

Use anotações do JPA para mapear as entidades Evento e Participante.
Configure o relacionamento entre Evento e Participante como OneToMany.
Lógica de Negócio:

Implemente a lógica de ordenação e busca manualmente (não use bibliotecas prontas para isso).
Utilize Stream API para manipular coleções de forma eficiente.
Validações:

Valide os dados de entrada usando anotações como @NotNull, @Size, etc.
Verifique duplicidade de participantes usando um HashSet.
Exemplo de Entrada e Saída
Criar Evento
Requisição:

```

POST /eventos
{
  "nome": "Tech Conference",
  "data": "2023-12-01",
  "local": "São Paulo"
}
Resposta:



{
  "id": 1,
  "nome": "Tech Conference",
  "data": "2023-12-01",
  "local": "São Paulo",
  "participantes": []
}
Adicionar Participante
Requisição:



POST /eventos/1/participantes
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "idade": 30
}
Resposta:



{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "idade": 30
}
Listar Eventos
Requisição:



GET /eventos
Resposta:



[
  {
    "id": 1,
    "nome": "Tech Conference",
    "data": "2023-12-01",
    "local": "São Paulo",
    "participantes": [
      {
        "id": 1,
        "nome": "João Silva",
        "email": "joao@email.com",
        "idade": 30
      }
    ]
  }
]

```
### Desafio Extra
Implemente uma funcionalidade para exportar os dados de um evento (incluindo participantes) para um arquivo JSON ou CSV.
