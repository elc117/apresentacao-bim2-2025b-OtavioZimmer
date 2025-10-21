public class TrueFalseQuestion extends Question {
    private boolean respostaCorreta;

    public TrueFalseQuestion(String texto, boolean respostaCorreta) {
        super(texto);
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public boolean checarResposta(String resposta) {
        marcarRespondida();
        boolean res = resposta.equalsIgnoreCase("true");
        return res == respostaCorreta;
    }

    @Override
    public String mostraQuestao() {
        return texto + " (True/False)\n";
    }
}