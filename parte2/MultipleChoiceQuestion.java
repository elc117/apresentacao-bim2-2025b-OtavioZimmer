import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> opcoes;
    private int opcaoCorreta;

    public MultipleChoiceQuestion(String texto, List<String> opcoes, int opcaoCorreta) {
        super(texto);
        this.opcoes = opcoes;
        this.opcaoCorreta = opcaoCorreta;
    }

    @Override
    public boolean checarResposta(String resposta) {
        marcarRespondida();
        try {
            int escolha = Integer.parseInt(resposta);
            return escolha == opcaoCorreta;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String mostraQuestao() {
        String s = texto + "\n";
        for (int i = 0; i < opcoes.size(); i++) {
            s = s + i + ": " + opcoes.get(i) + "\n";
        }
        return s.toString();
    }
}