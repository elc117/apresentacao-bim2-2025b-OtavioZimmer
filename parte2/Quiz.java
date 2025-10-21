import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {
    private List<Question> questoes;

    public Quiz() {
        this.questoes = new ArrayList<>();
    }

    public void adicionarQuestao(Question q) {
        questoes.add(q);
    }

    public void mostrarTodasQuestoes() {
        for (Question q : questoes) {
            System.out.println(q.mostraQuestao());
        }
    }

    public void checarPergunta(int index, String resposta) {
        if (index >= 0 && index < questoes.size()) {
            boolean correta = questoes.get(index).checarResposta(resposta);
            System.out.println("Questão " + index + " respondida: " + (correta ? "Correta!" : "Incorreta!"));
        } else {
            System.out.println("Index inválido de questão.");
        }
    }

    public void questaoAleatoria() {
        Random aleatoria = new Random();
        int idx = aleatoria.nextInt(questoes.size());
        System.out.println("Questão aleatória:");
        System.out.println(questoes.get(idx).mostraQuestao());
    }
}