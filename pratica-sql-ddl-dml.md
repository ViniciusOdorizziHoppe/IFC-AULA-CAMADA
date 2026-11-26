# 💻 Prática de SQL (DDL, DML, DQL e Transações ACID)

**Instituição:** Instituto Federal Catarinense (IFC) — Campus Ibirama  
**Disciplina:** Banco de Dados  
**Professor:** Prof. Msc. Rodrigo Azevedo  
**Ambiente:** [SQL Online (sqliteonline.com)](https://sqliteonline.com/)

---

## 🎯 Objetivos da Atividade

Nesta prática em laboratório, você irá aplicar os conceitos estudados em sala diretamente em um Sistema Gerenciador de Banco de Dados (SGBD) relacional, exercitando:

1. **DDL (Data Definition Language):** Criação e alteração de estruturas de tabelas, restrições (`CHECK`, `UNIQUE`, `NOT NULL`) e políticas de integridade referencial (`FOREIGN KEY`, `ON DELETE CASCADE`).
2. **DML (Data Manipulation Language):** Inserção, atualização condicional e exclusão segura de registros.
3. **DQL (Data Query Language):** Consultas com filtros, ordenação, funções de agregação (`COUNT`, `SUM`), agrupamento (`GROUP BY`) e junções entre tabelas (`INNER JOIN`).
4. **TCL (Transaction Control Language):** Controle transacional garantindo as propriedades **ACID** (`BEGIN`, `COMMIT` e `ROLLBACK`).

---

## 🛠️ Preparando o Ambiente (Setup Inicial)

1. Acesse o site **[sqliteonline.com](https://sqliteonline.com/)** no seu navegador.
2. No menu lateral esquerdo, mantenha selecionada a opção padrão **SQLite** (ou selecione **PostgreSQL**).
3. Apague o código de exemplo que aparece na área central.
4. Copie todo o script SQL abaixo, cole no editor e clique no botão **Run** (ou pressione `Shift + Enter`) para criar o banco de dados **TechStore IFC**:

```sql
-- Limpeza inicial (caso precise reiniciar o banco do zero)
DROP TABLE IF EXISTS itens_pedido;
DROP TABLE IF EXISTS pedidos;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS clientes;

-- 1. Tabela Clientes
CREATE TABLE clientes (
    id_cliente INTEGER PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(60) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- 2. Tabela Produtos
CREATE TABLE produtos (
    id_produto INTEGER PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL CHECK (preco > 0),
    estoque INTEGER NOT NULL DEFAULT 0 CHECK (estoque >= 0)
);

-- 3. Tabela Pedidos
CREATE TABLE pedidos (
    id_pedido INTEGER PRIMARY KEY,
    id_cliente INTEGER NOT NULL REFERENCES clientes(id_cliente),
    data_pedido DATE NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'Pendente'
);

-- 4. Tabela Associativa Itens do Pedido (N:N)
CREATE TABLE itens_pedido (
    id_pedido INTEGER NOT NULL REFERENCES pedidos(id_pedido) ON DELETE CASCADE,
    id_produto INTEGER NOT NULL REFERENCES produtos(id_produto),
    quantidade INTEGER NOT NULL CHECK (quantidade > 0),
    preco_unitario NUMERIC(10, 2) NOT NULL,
    PRIMARY KEY (id_pedido, id_produto)
);

-- Carga inicial de dados para teste
INSERT INTO clientes VALUES 
(1, 'Ana Souza', 'Ibirama', 'ana@email.com'),
(2, 'Carlos Lima', 'Blumenau', 'carlos@email.com'),
(3, 'Beatriz Rocha', 'Ibirama', 'bia@email.com'),
(4, 'João Mendes', 'Rio do Sul', 'joao@email.com');

INSERT INTO produtos VALUES
(10, 'Mouse Sem Fio', 'Periféricos', 85.00, 15),
(20, 'Teclado Mecânico', 'Periféricos', 250.00, 8),
(30, 'Monitor 24 Pol', 'Monitores', 890.00, 4),
(40, 'Cabo HDMI 2m', 'Acessórios', 35.00, 30),
(50, 'Headset Gamer', 'Áudio', 190.00, 0);

INSERT INTO pedidos VALUES
(101, 1, '2026-11-10', 'Entregue'),
(102, 2, '2026-11-12', 'Pago'),
(103, 1, '2026-11-15', 'Pendente'),
(104, 3, '2026-11-18', 'Cancelado');

INSERT INTO itens_pedido VALUES
(101, 10, 2, 85.00),
(101, 40, 1, 35.00),
(102, 30, 1, 890.00),
(103, 20, 1, 250.00),
(103, 10, 1, 85.00),
(104, 50, 1, 190.00);
```

> ⚠️ **Atenção (Importante no SQLite):** Caso esteja utilizando a aba **SQLite** no SQL Online, execute o comando abaixo uma vez antes de iniciar o Bloco 1 para garantir que a verificação de chaves estrangeiras esteja ativa:
> ```sql
> PRAGMA foreign_keys = ON;
> ```

---

## 📝 Lista de Exercícios Práticos

Crie um arquivo chamado `resolucao_sql.sql` (ou anote suas respostas e prints) contendo os comandos SQL utilizados para resolver cada questão abaixo.

### 🔹 Bloco 1: DDL e Integridade Referencial (Testando Restrições)

1. **Adicionando Coluna (`ALTER TABLE`):**  
   Adicione uma nova coluna chamada `telefone` (do tipo `VARCHAR(20)`) na tabela `clientes`.

2. **Testando Violação de Chave Estrangeira (`FOREIGN KEY`):**  
   Tente inserir um novo pedido (`id_pedido = 105`) para um cliente inexistente (`id_cliente = 99`).  
   *Responda em comentário (`--`):* Qual mensagem de erro o SGBD retornou e qual regra de integridade impediu a gravação?

3. **Testando Violação de Regra de Domínio (`CHECK`):**  
   Tente cadastrar um novo produto (`id_produto = 60`) com preço negativo (`-50.00`).  
   *Responda em comentário (`--`):* Por que o banco bloqueou essa inserção?

4. **Testando Política `ON DELETE CASCADE`:**  
   Exclua o pedido `104` da tabela `pedidos` (`DELETE FROM pedidos WHERE id_pedido = 104;`) e, em seguida, execute `SELECT * FROM itens_pedido;`.  
   *Responda em comentário (`--`):* O que aconteceu com o item vinculado ao pedido `104` na tabela filha?

---

### 🔹 Bloco 2: DML (Inserção, Atualização e Exclusão Segura)

5. **Novo Cadastro Completo:**  
   Cadastre **você mesmo** (seu nome, sua cidade e seu e-mail institucional) na tabela `clientes` com `id_cliente = 5`. Em seguida, registre um novo pedido (`id_pedido = 105`, status `'Pago'`) em seu nome contendo **2 unidades** do `Teclado Mecânico` (`id_produto = 20`).

6. **Reajuste de Preços (`UPDATE`):**  
   Aumente em **10%** o preço de todos os produtos pertencentes à categoria `'Periféricos'`.

7. **Baixa de Estoque:**  
   Atualize o estoque do `Teclado Mecânico` (`id_produto = 20`), subtraindo as 2 unidades vendidas no exercício 5.

8. **Exclusão Condicional (`DELETE` com Subconsulta):**  
   Exclua da tabela `clientes` todos os clientes que **nunca realizaram nenhum pedido** (Dica: utilize `WHERE id_cliente NOT IN (...)`).

---

### 🔹 Bloco 3: DQL (Consultas, Filtros, Agregações e `JOIN`)

9. **Filtros e Ordenação:**  
   Liste o `nome_produto`, `categoria` e `preco` de todos os produtos que possuem **estoque maior que 0** e custam **menos de R$ 300,00**, ordenados do mais caro para o mais barato (`ORDER BY`).

10. **Relatório de Clientes por Cidade (`GROUP BY`):**  
    Escreva uma consulta que exiba cada `cidade` e a quantidade total de clientes cadastrados nela.

11. **Junção de Tabelas (`INNER JOIN`):**  
    Exiba o `id_pedido`, a `data_pedido`, o `status` e o `nome` do cliente responsável por cada pedido.

12. **Desafio — Faturamento por Pedido (`JOIN` + `SUM`):**  
    Calcule o valor total (em R$) de cada pedido, exibindo o `id_pedido`, o `nome` do cliente e a coluna calculada `valor_total` (`SUM(quantidade * preco_unitario)`). Considere apenas os pedidos cujo status seja diferente de `'Cancelado'`.

---

### 🔹 Bloco 4: Transações ACID (`BEGIN`, `COMMIT` e `ROLLBACK`)

13. **Simulando Falha e Desfazendo Alterações (`ROLLBACK`):**  
    Execute os passos abaixo **um comando por vez** e observe o resultado:
    - Passo A: Inicie uma transação com `BEGIN;`
    - Passo B: Apague todos os registros da tabela `itens_pedido` (`DELETE FROM itens_pedido;`)
    - Passo C: Consulte a tabela (`SELECT * FROM itens_pedido;`) e verifique se ficou vazia.
    - Passo D: Execute `ROLLBACK;` e consulte novamente `SELECT * FROM itens_pedido;`.
    - *Responda em comentário (`--`):* Qual propriedade **ACID** foi comprovada na prática com esse teste?

14. **Efetivando uma Venda Atômica (`COMMIT`):**  
    Inicie uma transação (`BEGIN;`), insira um novo pedido (`id_pedido = 106` para o cliente `2`), adicione **1 unidade** do `Monitor 24 Pol` (`id_produto = 30`) em `itens_pedido`, subtraia `1` do estoque desse monitor na tabela `produtos` e finalize gravando definitivamente com `COMMIT;`.

---

## 📤 Instruções de Entrega

- Salve todos os seus comandos SQL comentados em um arquivo `.sql` (ex: `seu_nome_pratica_sql.sql`).
- Envie o arquivo no **SIGAA** (ou submeta via Pull Request / repositório da disciplina conforme orientado em sala).