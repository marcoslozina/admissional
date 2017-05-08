Neste arquivo README explica-se como executar os testes da segunda API-Socio-Torcedor.
Para o exerc�cio 2
Requisito funcional:
Dado um E-mail que j� existe, informar que o cadastro j� foi efetuado Teste do requisito funcional
Teste do requisito funcional
Executar o teste
�	2-Teste cria��o de torcedores - Criar torcedor 4
O teste anterior cria um torcedor com o email: torcedor4@gmail.com 
Logo executar
�	2-Teste cria��o de torcedores - Criar torcedor existente
 E o status da resposta retorna um 409. Indicando um conflito, por causa que n�o pode existir dois torcedores com o mesmo email.
Requisito funcional:
Ao efetuar o cadastro, o servi�o dever� repassar uma lista de campanhas ao qual est� associado ao time do cora��o. 
O Consumo das listas das campanhas deve ser feita via Servi�o exposto conforme descrito no exerc�cio anterior;

Teste do requisito funcional
Executar o teste
�	3-Teste recuperar campanhas cadastradas - Recuperar todas as campanhas 
(as campanhas tem que estar cadastradas usando a API-Campanha, executar os testes automatizados da API-Campanha primeiro)

Esse teste recupera a lista de campanhas cadastradas desde a primeira API-Campanhas, sendo independente.
Requisito funcional:
A associa��o do cadastro do Cliente juntamente com as Campanhas dever� ocorrer em um segundo passo, utilizando a API constru�da no pr�ximo exerc�cio.
Teste do requisito funcional
Executar as request dentro da pasta:
�	1-Teste cria��o de times
�	4-Asociar Campanhas com Time
Nesse teste se associa uma campanha com um time. Considerando o ID da campanha recuperado utilizando a API-Campanhas.
E por �ltimo, para associar um time a um torcedor executar as request dentro da pasta:
�	2-Teste cria��o de torcedores
�	5-Asociar time com torcedor
Nesse �ltimo teste se associa um time com um torcedor.
