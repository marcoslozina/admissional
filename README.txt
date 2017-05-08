Neste reposit�rio, encontra-se os exerc�cios do exame: Prova - Java PL - SR Netshoes - v1.1.b
Para a resolu��o do ex�rcito 1 e 2 se crio dos Web Services RESTful utilizando o estilo de arquitetura REST proposto por Roy Fielding, 
este estilo de arquitetura se caracteriza por ser escal�vel, incremental, simples, extens�vel, e global, ou seja, carater�sticas que a web atual possui.
A implementa��o foi feita utilizando a tecnologia do framework Spring MVC, junto com APIs de java 8. 
Os componentes do framwork utilizado foram: Spring boot, Spring Data, devtools. 
Banco de dados H2 em mem�ria, e servidor web tomcat embutido independente,rodando em portos diferentes (8080 e 8081) para cada API. 
Pensando nos requisitos n�o funcionais do servi�o, foi implementado cache.  
Os testes foram realizados utilizando Junit e Mock Object junto com testes automatizados feitos em Postman.
Para executar os exerc�cios, descarregar este reposit�rio.
Compilar os projetos utilizando mvn compile para todos os projetos.
As APIs executar como spring-boot-aplication e o exerc�cio 3 executar como java aplication. 
Ap�s startar as APIs, importar os testes automatizados para cada API com postman e execut�-los.
Cada API tem um arquivo README que orienta sobre como executar os testes.
