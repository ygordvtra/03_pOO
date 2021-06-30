public class Avião extends Aeronave{

    private int qtdTurbinas;

    public Avião(String modelo, int capacidade, double peso, double velocidademax, int qtdTurbinas) {
        super(modelo, capacidade, peso, velocidademax);
        this.qtdTurbinas = qtdTurbinas;
    }
    public int getqtdTurbinas() {
        return qtdTurbinas;
    }
    public void setQtdTurbinas(int qtdTurbinas) {
        this.qtdTurbinas = qtdTurbinas;
    }
    public String toString() {
        String retorno = super.toString();
        retorno += "Quantidade de Turbinas: " + this.qtdTurbinas + "\n";
        retorno += "Status de decolagem: " + this.ativarVoo() + "\n";
        return retorno;
    }
    @Override
    public String  ativarVoo(){
        return "Decolando";
    }
}
