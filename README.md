# ProjetoBuilders
Meu processo criativo foi:  quando estava decidindo como fazer, 
havia primeiro pensado em utilizar o Spring Data JPA para aproveitar os métodos padrões que já existem, 
porem atualmente estou mais acostumado em utilizar o EntityManager então resolvi usa-lo e criar todos os métodos.
Durante o desenvolvimento eu tentei deixar as classes e métodos o mais simples possíveis para focar apenas no que foi pedido e
após fui adicionando coisas conforme senti necessidade. Um exemplo seria o método insereListaClientes em que primeiro pensei em
dar alguns inserts direto no banco, mas após fiquei em duvida se o SQL deveria ficar responsavel por essa parte dos testes e resolvi
criar algo possibilitando a criação de vários clientes pelo próprio postman. 
Para atualizar os dados também estava em duvida se criava um método para cada campo ou fazia algo diferente,
acabei fazendo algo que verifica qual campo está faltando e completa com as informações originais, mas em essência é exatamente igual ao
que recebe e atualiza todas as informações de uma vez, podendo até substitui-lo e ficar apenas ele. 
Sobre o campo idade, pensei em varias formas de faze-lo, mas achei que estava complicando demais as coisas e resolvi adicionar algo
diretamente no método get dele, o que acabou diminuindo as linhas de código.
