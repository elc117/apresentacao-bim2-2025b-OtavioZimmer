# Parte 1

Para a Parte 1 da prática, foi solicitado que fosse analisado e completado um código sobre organização de tarefas (assignments) de disciplinas de faculdade. O código era dividido em três arquivos: ``Assignment.java``, ``GroupAssignment.java`` e ``TrackAssignments.java``, respectivamente para representar uma tarefa, uma tarefa a ser desenvolvida em grupo e a classe que contém o método main, onde também é criada e manipulada uma lista de tarefas. 

Inicialmente, tínhamos que implementar o método ``public String toString()``, para formatar a saída do laço de exibição presente em ``TrackAssignments.java``.

A primeira versão:

<pre>
@Override
public String toString() {
  return "{ " + "dueDate=" + "'" + this.dueDate + "'" + ", description=" + "'" + this.description + "'" + ", pending=" + "'" + this.pending + "'" + ", submitDate=" + "'" + this.submitDate + "'" + "}";
}
</pre>

Identifiquei que era um jeito bem "manual". Resolvi pesquisar para ver se não encontrava algo para deixar mais "dinâmico", e encontrei o String.format, em Java. Então o código, com a aplicação deste método ficou assim:

<pre>
@Override
public String toString() {
  return String.format("{ dueDate='%s', description='%s', pending='%s', submitDate='%s'}",
          dueDate, description, pending, submitDate);
}
</pre>

``@Override`` é usado nesse caso para impedir que retorne o nome da classe + o hashcode do objeto. Por exemplo:

<pre>Assignment@5a07e868</pre>

Com a sua utilização, a saída fica corretamente em forma de string.

Depois, tínhamos que completar o método status, de modo que ele retornasse uma String representando o estado da tarefa: "done" se a tarefa estiver completa (não pendente); "late" se a tarefa estiver pendente e atrasada; "due in x days" se a tarefa estiver pendente, faltando x=daysLeft() dias para a entrega. Tudo levando em consideração as datas.
A lógica que utilizei foi uma estrutura condicional:

<pre>

private String status() {
  if (!isPending()) {
      return "done";
  }
  else if (daysLeft() < 0) {
      return "late";
  }
  else {
      return "due in " + daysLeft() + " days";
  }
}
</pre>

A princípio funcionou. Porém, obtive um problema, que percebi na hora dos testes: o método daysLeft estava implementado da seguinte forma:

<pre>
public int daysLeft() {
  return dueDate.compareTo(LocalDate.now());
}
</pre>

Este método, de acordo com sua documentação, neste caso retorna 0 se as datas forem iguais; > 0 se ``dueDate`` for depois de "hoje"; < 0 se for antes de hoje. Ou seja, ele não retornava o número de dias, mas sim o resultado da comparação de datas. Então, pesquisando sobre como poderia comparar especificamente datas sem que fosse necessário implementar algoritmos muito grandes, encontrei o chronoUnit, que foi essencial para deixar o método funcionando da maneira correta para a questão:

<pre>
public int daysLeft() {
  TemporalUnit unit = ChronoUnit.DAYS;
  return (int) LocalDate.now().until(dueDate, unit);
}
</pre>

Depois, foi necessário implementar o ``super`` no código, para que fosse possível chamar métodos da superclasse e acessar construtores da superclasse. No contexto da atividade, essa palavra chave foi usada para reaproveitar as mensagens implementadas normalmente na superclasse e adicionar variações para ela. Dessa forma, a depender do tipo da tarefa, pode ser enviada uma mensagem modificada quando a tarefa for em grupo.

<pre>
@Override
public String message() {
  if (!isPending()){
      return super.message();
  }
  return "Group " + super.message() + " - call " + this.teamMates;
}
</pre>

Por último, foi solicitado que fosse adicionado um código no final do main, para contar e mostrar a quantidade de tarefas concluídas (não pendentes):

<pre>
int completedAssignmentsCount = 0;
  for (Assignment item : list) {
    if (!item.isPending()){
      completedAssignmentsCount += 1;
    }
  }

  System.out.println("\n==> Completed Assignments: " + completedAssignmentsCount);
</pre>

- Parte fácil: contar e mostrar a quantidade de tarefas concluídas e implementar o método ``toString``.

- Parte difícil: modificar o método ``daysLeft`` para se adequar ao que era pedido e entender o funcionamento do ``super`` e sua implementação no código.

## Fontes
toString(): http://www.mauda.com.br/?p=1472
Override: https://stackoverflow.com/questions/94361/when-do-you-use-javas-override-annotation-and-why?
String.format: https://www.w3schools.com/java/ref_string_format.asp
compareTo(): https://www.w3schools.com/java/ref_string_compareto.asp
chronoUnit: https://labex.io/tutorials/java-how-to-use-chronounit-for-date-operations-in-java-414155
super: https://www.w3schools.com/java/ref_keyword_super.asp
Random em Java: https://www.devmedia.com.br/numeros-aleatorios-em-java-a-classe-java-util-random/26355