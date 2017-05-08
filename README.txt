Neste repositório, encontra-se os exercícios do exame: Prova - Java PL - SR Netshoes - v1.1.b
Para a resolução do exército 1 e 2 se crio dos Web Services RESTful utilizando o estilo de arquitetura REST proposto por Roy Fielding, 
este estilo de arquitetura se caracteriza por ser escalável, incremental, simples, extensível, e global, ou seja, caraterísticas que a web atual possui.
A implementação foi feita utilizando a tecnologia do framework Spring MVC, junto com APIs de java 8. 
Os componentes do framwork utilizado foram: Spring boot, Spring Data, devtools. 
Banco de dados H2 em memória, e servidor web tomcat embutido independente,rodando em portos diferentes (8080 e 8081) para cada API. 
Pensando nos requisitos não funcionais do serviço, foi implementado cache.  
Os testes foram realizados utilizando Junit e Mock Object junto com testes automatizados feitos em Postman.
Para executar os exercícios, descarregar este repositório.
Compilar os projetos utilizando mvn compile para todos os projetos.
As APIs executar como spring-boot-aplication e o exercício 3 executar como java aplication. 
Após startar as APIs, importar os testes automatizados para cada API com postman e executá-los.
Cada API tem um arquivo README que orienta sobre como executar os testes.
