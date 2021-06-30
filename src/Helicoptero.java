public class Helicoptero extends Aeronave{

    private int qtdHelices;

    public Helicoptero(String modelo, int capacidade, double peso, double velocidademax, int qtdHelices) {
        super(modelo, capacidade, peso, velocidademax);
        this.qtdHelices = qtdHelices;
    }
    public int getQtdHelices(){
        return qtdHelices = qtdHelices;
    }
    public void setqtdHelices(int qtdHelices){
        this.qtdHelices = qtdHelices;
    }
    public String toString() {
        String retorno = super.toString();
        retorno += "Quantidade de Hélices: " + this.qtdHelices + "\n";
        return retorno;
    }
    @Override
    public boolean ativarVoo(){
        return true;
    }
}
