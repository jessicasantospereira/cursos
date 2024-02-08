# API Cursos
- Criação de um novo curso
- Listagem de todos os cursos
- Atualização de um curso pelo `id`
- Remover um curso pelo `id`

### Regras de negócio

Entidade curso:

- `id` - Identificador único de cada curso
- `name` - Nome do curso
- `category` - Categoria do curso
- `Active` - Define se o curso está ativo ou não
- `created_at` - Data de quando o curso foi criado.
- `updated_at` - Deve ser sempre alterado para a data de quando o curso for atualizada.

### Rotas
- `POST - /cursos`    
- `GET - /cursos`    
- `PUT - /cursos/:id`    
- `DELETE - /cursos/:id`
- `PATCH - /cursos/:id/active`
