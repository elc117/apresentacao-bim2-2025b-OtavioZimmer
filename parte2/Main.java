import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.adicionarQuestao(new TrueFalseQuestion("O Java é uma linguagem compilada?", true));
        quiz.adicionarQuestao(new MultipleChoiceQuestion("Qual é a capital da França?",
                Arrays.asList("Berlim", "Paris", "Roma", "Madri"), 1));
        quiz.adicionarQuestao(new TrueFalseQuestion("O Sol é uma estrela?", true));
        quiz.adicionarQuestao(new MultipleChoiceQuestion("Qual desses números é primo?",
                Arrays.asList("4", "6", "7", "8"), 2));

        // 1ª operação: mostrar todas as questões
        System.out.println("=== Todas as questões ===");
        quiz.mostrarTodasQuestoes();

        // 2ª operação: checar resposta de uma questão
        System.out.println("\n=== Checar resposta ===");
        quiz.checarPergunta(1, "1"); // correta
        quiz.checarPergunta(3, "0"); // incorreta

        // 3ª operação: sortear uma questão
        System.out.println("\n=== Questão aleatória ===");
        quiz.questaoAleatoria();
    }
}