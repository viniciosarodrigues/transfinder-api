[![Heroku](https://heroku-badge.herokuapp.com/?app=heroku-badge&style=flat)](https://transfinder-api.herokuapp.com/swagger-ui.html)
# Transfinder-API
Pequeno sistema para que transportadoras possam se cadastrar para que a mesma possa aparecer na listagem principal do sistema, onde aparece todas as transportadoras cadastradas. e elas podem ser filtradas, caso clique no nome da transportadora, pode alterar os seus dados e também deletar a transportadora.

# Como densenvolver?
Para contribuir com o projeto, existem alguns requisítos mínimos de configurações, são eles?
- Java 11 + **(Obrigatório)**
- Lombok 1.16.0 + **(Obrigatório)**
- Eclipse ou STS **(Obrigatório)**
- No caso do Eclipse, usar o plugin do Spring Tools *(Opcional)*

## Configurando o Lombok
Caso não tenha o Lombok, já existe uma dependência do mesmo no projeto, basta importar o projeto no **Eclipse/STS** e aguardar que a dependẽncia seja baixada. Com o Jar do Lombok baixado no repositório local do Maven, siga o passo-a-passo logo abaixo:

- Navegar até o repositório do Lombok
-`C:\users\{usuario}\.m2\repository\org\projectlombok\lombok\{versao_baixada}`
- Executar o jar do lombok
-`java -jar lombok.{versao}.jar`
- Selecionar o Eclipse/STS que irá receber o Lombok
- Clicar em Install/Update
- Sair do instalador
- Abrir a IDE novamente
- Rebuild no projeto

## Como rodar a API?
Por ser um projeto SpringBoot, não se faz necessário o uso de nenhum servidor externo, pois o framework já disponibiliza um Tomcat embarcado, desta forma basta clicar com o botão direito na raiz do projeto, **Run As** -> **SpringBoot App**.
Também pode rodar apartir do **ApplicationMain** encontrado no pacote base da aplicação.

## Contato
Qualquer dúvida ou sugestão, favor enviar para o e-mai *viniciosarodrigues@gmail.com* ou enviar mensagem privada pelo próprio GitGub.
