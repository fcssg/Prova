SELECT q1.nome
     , q1.nota
     , q1.valor
  FROM (     
         SELECT a.nome  nome
              , n.nota  nota
              , a.valor valor
           FROM alunos a INNER JOIN notas n ON a.valor BETWEEN n.valor_min AND n.valor_max
          WHERE n.nota >= 8
          ORDER BY n.nota DESC, a.nome
       ) q1
UNION ALL
SELECT q2.nome
     , q2.nota
     , q2.valor
  FROM (     
         SELECT NULL    nome
              , n.nota  nota
              , a.valor valor
              , RANK() OVER (PARTITION BY n.nota ORDER BY a.valor ASC) as rank
           FROM alunos a INNER JOIN notas n ON a.valor BETWEEN n.valor_min AND n.valor_max
          WHERE n.nota < 8
          ORDER BY n.nota DESC, rank
       ) q2;