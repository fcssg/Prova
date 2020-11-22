# Prova
Arquivos da prova 

--------------------------------------------------------------------------------
Exercício 2
--------------------------------------------------------------------------------

Compilar e executar o arquivo Ex2_FooBaa.java
A solução adotada atende ao solicitado e foi a forma que encontrei que utiliza
a menor quantidade de linhas de código, devido a isso foi escolhida.
Primeiro é verificado se o número é divisível por 15 (sendo múltiplo de 3 e 5)
Caso não seja multiplo de ambos simultaneamente, é validado se ele é múltiplo 
de 3, caso não seja, se ele é multiplo de 5. Em caso negativo, é impresso o 
número do contador, pois o número informado náo deve ser substituído por Foo, 
Baa ou FooBaa.

--------------------------------------------------------------------------------
Exercício 3
--------------------------------------------------------------------------------

Compilar e executar o arquivo Ex3_ConcatERemove.java
Informar a string inicial, a string desejada e um número inteiro que representa 
o número de operações.
Caso a string informada não atenda os critérios descritos, o retorno será "não".
As variaveis de entrada devem possuir entre 1 e 100 caracteres minúsculos e não
numéricos. 
Verifica os caracteres da string inicial comparando com a string desejada um a 
um, substituindo e contando a quantidade de vezes que isso ocorre (passos), 
não contando quando o caracter for igual. 
Se a quantidade de passos for maior do que o numero de operações informado, 
retorna "não".
Após as substituições, verifica o tamanho da string desejada. Se a quantidade
de caracteres da strinf desejada for menor do que da string inicial, ele remove 
os caracteres somando um a cada removido na quantidade de passos.
Se a quantidade de passos final for maior do que o informado na variável 
operações, retorna "não".
Caso contrário, retorna "sim".

--------------------------------------------------------------------------------
Exercício 4
--------------------------------------------------------------------------------

>> PARA VALIDAÇÃO

Foram geradas as criações de tabelas e inserção dos dados informados. Mais duas 
linhas foram adicionadas para uma melhor vizualização do resultado esperado.

CREATE TABLE alunos
( id    NUMBER
, nome  VARCHAR2(20)
, valor NUMBER
);

CREATE TABLE notas
( nota      NUMBER
, valor_min NUMBER
, valor_max NUMBER
);

BEGIN
  INSERT INTO notas VALUES (1 ,0 , 9  );
  INSERT INTO notas VALUES (2 ,10, 19 );
  INSERT INTO notas VALUES (3 ,20, 29 );
  INSERT INTO notas VALUES (4 ,30, 39 );
  INSERT INTO notas VALUES (5 ,40, 49 );
  INSERT INTO notas VALUES (6 ,50, 59 );
  INSERT INTO notas VALUES (7 ,60, 69 );
  INSERT INTO notas VALUES (8 ,70, 79 );
  INSERT INTO notas VALUES (9 ,80, 89 );
  INSERT INTO notas VALUES (10,90, 100);
  INSERT INTO alunos VALUES (1, 'Julia'    , 88);
  INSERT INTO alunos VALUES (2, 'Carol'    , 68);
  INSERT INTO alunos VALUES (3, 'Maria'    , 99);
  INSERT INTO alunos VALUES (4, 'Andreia'  , 78);
  INSERT INTO alunos VALUES (5, 'Jaqueline', 63);
  INSERT INTO alunos VALUES (6, 'Marcela'  , 81);
  -- inseridas duas linhas para validação da solução
  INSERT INTO alunos VALUES (8, 'Mirela'   , 42);
  INSERT INTO alunos VALUES (7, 'Amanda'   , 55);
  COMMIT;    
END;

>> SOLUÇÃO

Foram criadas duas queries.
A primeira query retorna os registros com notas maiores ou igual a 8,já com
a ordenação decrescente por nota e nome em ordem alfabética.
Essa primeira query é unida a segunda query, que traz todos os registros com 
notas abaixo de 8 particionadas pela nota, realizando um rank das mesmas, 
permitindo ordenar de outra forma quando a mesma nota se repete para mais de um
aluno. O nome dos alunos é exibido como null quando sua nota for inferior à 8. 
As notas inferiores à 8 que forem destinadas a apenas um aluno são ordenadas 
em ordem decrescente.

Essa solução foi adotada por ser eficiente para o caso demonstrado, onde não há
uma quantidade elevada de registros. Nesse caso, o uso de função no select não 
causou um grande impacto na performance. Em casos onde a quantidade de dados é 
muito alta, não é aconselhável o uso de funções, então essa solução poderia
não ser tão eficaz.


--------------------------------------------------------------------------------
Exercício 5
--------------------------------------------------------------------------------

Os dois métodos tem a mesma assinatura, porém com comportamentos distintos
(atributos e métodos diferentes).
Como não foi infomada a existência de argumentos diferentes, trata-se de 
polimorfismo.

--------------------------------------------------------------------------------
Exercício 6
--------------------------------------------------------------------------------

Compilar e executar o arquivo Ex6_Lenght.cpp

Informar a string que deseja saber o tamanho (limite de 200 caracteres).
Ao apertar enter, será retornada a quantidade de caracteres da string.

Criada uma variável do tipo char, com tamanho 200. 
Solicita ao usuário inserir o texto.
A função TamanhoTexto é chamada, onde é passado o texto.
O tamanho da string é exibido na tela.

TamanhoTexto
Recebe um ponteiro do tipo char, onde sua ultima posição é 0. 
Então, ele soma um na variável de tamanho (tlenght) enquanto a posição for
diferente de 0. Retorna o valor de posições.

--------------------------------------------------------------------------------
Exercício 7
--------------------------------------------------------------------------------

>> PARA VALIDAÇÃO

Criar as tabelas Cats e Dogs.
Inserir informações nas mesmas.

CREATE TABLE dogs 
( id   NUMBER       PRIMARY KEY
, name VARCHAR2(50) NOT NULL
);

CREATE TABLE cats 
( id   NUMBER       PRIMARY KEY
, name VARCHAR2(50) NOT NULL
);

BEGIN
  INSERT INTO dogs VALUES (1, 'DOG1');
  INSERT INTO dogs VALUES (2, 'DOG2');
  INSERT INTO dogs VALUES (3, 'DOG3');
  INSERT INTO dogs VALUES (4, 'DOG2');
  INSERT INTO dogs VALUES (5, 'DOG3');
  INSERT INTO dogs VALUES (6, 'CAT2');
  INSERT INTO dogs VALUES (7, 'DOG2');
  INSERT INTO dogs VALUES (8, 'CAT2');
  INSERT INTO cats VALUES (1, 'CAT1');
  INSERT INTO cats VALUES (2, 'CAT2');
  INSERT INTO cats VALUES (3, 'CAT3');
  INSERT INTO cats VALUES (4, 'CAT3');
  INSERT INTO cats VALUES (5, 'DOG1');
  INSERT INTO cats VALUES (6, 'CAT2');
  INSERT INTO cats VALUES (7, 'DOG2');
END;

>> SOLUÇÃO

Ao executar a consulta utilizando union, são trazidos todos os registros da 
tabela cats e da tabela dogs com dados distintos das duas tabelas, pois o union 
resulta em uma consulta sem dados duplicados e ordenada por padrão (default).
Isso é um ponto positivo para alguns casos pois o distinct e a ordenaçao acontecem 
implicitamente, porém é um ponto negativo na questao performatica da query.
No caso do exercício, esse impacto não é um ponto relevante visto a quantidade de 
inforações nas tabelas.
