# Banco de Dados Relacionais
## Consultas SQL Avançadas

----------
### Responda as seguintes questões

1 - Como é chamado um JOIN em um banco de dados e para que é usado?

```
INNER JOIN, é usado para obter dados de várias tabelas relacionadas. Consiste em combinar dados de uma tabela com dados de outra tabela, com base em uma ou mais condicoes.
```


2 - Explique os tipos de JOIN.

```
INNER JOIN, ou JOIN padrão, é utilizado para fazer a interseccao de dados entre tabelas. LEFT JOIN é utilizado para obter dados relacionados entre duas tabelas e os nao relacionados da tabela à esquerda da clausula JOIN (faz a diferenca A-B), já o RIGHT JOIN é o inverso.
```

3 - Para que serve o GROUP BY?

```
Agrupa os resultos de acordo com as colunas indicadas gerando um unico registro para cada grupo de linhas e colunas.
```

4 - Para que serve o HAVING?

```
Usada para incluir condicoes para consultas agrupadas.
```

5 - Escreva uma consulta genérica para cada um dos seguintes diagramas:

```
SELECT * FROM left_table l INNER JOIN right_table r on l.id = r.reference_id;
SELECT * FROM left_table l LEFT JOIN right_table r on l.id = r.reference_id; 
```

--------
###  Faça as seguintes consultas ao banco de dados movies_db.sql trabalhado na primeira aula: 

<br>
1 - Mostrar o título e o nome do gênero de todas as séries.

```
SELECT s.title, g.name FROM series s INNER JOIN genres g ON s.genre_id = g.id;
```

2 - Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em cada um deles.

```
SELECT e.title, a.first_name, a.last_name FROM actor_episode as ae INNER JOIN actors as a ON a.id = ae.actor_id INNER JOIN episodes as e ON e.id = ae.episode_id;
```

3 - Mostrar o título de todas as séries e o número total de temporadas que cada uma
delas possui.

```
SELECT series.title, COUNT(*) as total_seasons FROM series INNER JOIN seasons on seasons.serie_id = series.id GROUP BY series.id;
```

4 - Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde que seja maior ou igual a 3.

```
SELECT g.name, COUNT(*) as total_movies FROM genres g INNER JOIN movies m ON m.genre_id = g.id GROUP BY g.id HAVING COUNT(*) >= 3;
```

5 - Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de Star Wars e que estes não se repitam.

```
SELECT a.first_name, a.last_name 
FROM actor_movie as am 
    INNER JOIN actors as a ON a.id = am.actor_id 
    INNER JOIN movies as m ON m.id = am.movie_id 
WHERE m.title LIKE "La Guerra de las galaxias%" 
GROUP BY a.id;
```