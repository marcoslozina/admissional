Neste arquivo README explica-se como executar os testes da primeira API-Campanhas.
Para o exerc�cio 1
Requisito funcional:
No cadastramento de uma nova campanha, deve-se verificar se j� existe uma campanha ativa para aquele per�odo (vig�ncia), caso exista uma campanha ou N campanhas associadas naquele per�odo, o sistema dever� somar um dia no t�rmino da vig�ncia de cada campanha j� existente. Caso a data final da vig�ncia seja igual a outra campanha, dever� ser acrescido um dia a mais de forma que as campanhas n�o tenham a mesma data de t�rmino de vig�ncia. Por fim, efetuar o cadastramento da nova campanha.
Teste do requisito funcional
Dentro dos testes automatizados com postsman executar as requests dentro da pasta
1-Teste cria��o 
Esse teste vai criar tr�s (3) campanhas
�	Camanha 1 com a datafin: 2018-05-06
�	Camanha 2 com a datafin: 2018-05-07
�	Camanha 3 com a datafin: 2018-05-08
Tentamos cadastrar uma quarta campanha com a data fin= 2018-05-06 executando 
�       2-Teste atualiza��o campanhas - Criar campanha que atualiza as outras
O sistema teria que atualizar as data fim das 3 campanhas cadastradas acrescentando um dia em cada campanha para poder cadastrar a campanha 4.
Requisito funcional:
No caso de uma nas campanhas j� existentes, o sistema dever� ser capas de fornecer recursos para avisar outros sistemas que houve altera��o nas campanhas existentes.
Teste do requisito funcional
Para atender este requisito funcional se crio uma auditoria onde se cadastram todas as mudan�as feitas nas campanhas. Para verificar as mudan�as executar.
�	2-Teste atualiza��o campanhas - Verificar auditoria criada.
Requisito funcional
Fornecer mecanismos (APIs) para INCLUIR, CONSULTAR, ATUALIZAR, DELETAR. 
Teste do requisito funcional
Executar os testes:
�	3-Teste buscas
�	4-Teste update
�	5-Teste delete (se executar duas vezes sem criar de novo a campanha o teste n�o vai encontrar a campanha para deletar)
