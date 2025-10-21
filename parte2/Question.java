public class Question {
    protected String texto;
    protected boolean respondida;

    public Question(String texto) {
        this.texto = texto;
        this.respondida = false;
    }

    public String getTexto() {
        return texto;
    }

    public boolean foiRespondida() {
        return respondida;
    }

    public void marcarRespondida() {
        this.respondida = true;
    }

    public String mostraQuestao() { // cada subclasse implementa (cada questão tem sua forma)
        return texto;
    }

    public boolean checarResposta(String resposta) { // cada subclasse implementa (cada questão tem sua forma)
        return false;
    }

    @Override
    public String toString() {
        return "{ texto='" + texto + "', respondida='" + respondida + "' }";
    }
}