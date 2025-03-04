## Descrição do Sistema
O sistema é responsável por gerenciar eventos e seus participantes.

## Funcionalidades da API - Endpoints
### Gerenciar Eventos:

- POST /events: Criar um novo evento.
- GET /events: Listar todos os eventos.
- GET /events/{eventName}: Buscar evento por nome.
- GET /events/allParticipantsToEvent/{eventId}: Listar participantes de um evento.
- PUT /events/update/{eventId}: Atualizar informações de um evento.
- PUT /events/addParticipant/{idParticipant}/{eventName}: Adicionar um participante a um evento.
- PUT /events/removeParticipant/{idParticipant}/{eventName}: Remover um participante de um evento.
- DELETE /eventos/{eventId}: Deletar um evento.

### Gerenciar Participantes:

- POST /participant: Cadastrar novo participante.
- GET /participant: Listar todos os participantes.
- GET /participant/{id}: Buscar participante por id.

### Relatórios:

- GET /events/report/moreThanParticipants/{numberOfParticipants}: Lista apenas eventos com número de participantes igual ou superior ao informado.
- GET /events/report/listParticipantsByAge/{eventId}: Lista participantes de um evento ordenados por idade.

## Técnologias utilizadas:
- Spring Web
- Java 17
- Spring Data JPA
- H2 Database

## Modelos de Dados:

### Event:
- id (Long)
- name (String)
- date (LocalDate)
- local (String)
- participants (List<Participante>)

### Participante:
- id (Long)
- name (String)
- email (String)
- age (int)

## Exemplo de Entrada e Saída
- Criar Evento

```

POST /events
{
  "name": "Tech Conference",
  "date": "2023-12-01",
  "local": "São Paulo"
}

Resposta:

{
  "id": 1,
  "name": "Tech Conference",
  "date": "2023-12-01",
  "local": "São Paulo",
  "participants": []
}
```

- Adicionar Participante
```
POST /participant
{
  "name": "João Silva",
  "email": "joao@email.com",
  "age": 30
}

Resposta:

{
  "id": 1,
  "name": "João Silva",
  "email": "joao@email.com",
  "age": 30
}
```

- Listar Eventos
```

GET /events
Resposta:


[
  {
    "id": 1,
    "name": "Tech Conference",
    "data": "2023-12-01",
    "local": "São Paulo",
    "participants": [
      {
        "id": 1,
        "name": "João Silva",
        "email": "joao@email.com",
        "age": 30
      }
    ]
  }
]
```
