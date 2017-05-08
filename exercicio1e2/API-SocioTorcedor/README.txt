Neste arquivo README explica-se como executar os testes da segunda API-Socio-Torcedor.
Para o exercício 2
Requisito funcional:
Dado um E-mail que já existe, informar que o cadastro já foi efetuado Teste do requisito funcional
Teste do requisito funcional
Executar o teste
•	2-Teste criação de torcedores - Criar torcedor 4
O teste anterior cria um torcedor com o email: torcedor4@gmail.com 
Logo executar
•	2-Teste criação de torcedores - Criar torcedor existente
 E o status da resposta retorna um 409. Indicando um conflito, por causa que não pode existir dois torcedores com o mesmo email.
Requisito funcional:
Ao efetuar o cadastro, o serviço deverá repassar uma lista de campanhas ao qual está associado ao time do coração. 
O Consumo das listas das campanhas deve ser feita via Serviço exposto conforme descrito no exercício anterior;

Teste do requisito funcional
Executar o teste
•	3-Teste recuperar campanhas cadastradas - Recuperar todas as campanhas 
(as campanhas tem que estar cadastradas usando a API-Campanha, executar os testes automatizados da API-Campanha primeiro)

Esse teste recupera a lista de campanhas cadastradas desde a primeira API-Campanhas, sendo independente.
Requisito funcional:
A associação do cadastro do Cliente juntamente com as Campanhas deverá ocorrer em um segundo passo, utilizando a API construída no próximo exercício.
Teste do requisito funcional
Executar as request dentro da pasta:
•	1-Teste criação de times
•	4-Asociar Campanhas com Time
Nesse teste se associa uma campanha com um time. Considerando o ID da campanha recuperado utilizando a API-Campanhas.
E por último, para associar um time a um torcedor executar as request dentro da pasta:
•	2-Teste criação de torcedores
•	5-Asociar time com torcedor
Nesse último teste se associa um time com um torcedor.
