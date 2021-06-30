public class Planador extends Aeronave {

    private double comprimentoAsas;

    public Planador(String modelo, int capacidade, double peso, double velocidademax, double comprimentoAsas) {
        super(modelo, capacidade, peso, velocidademax);
        this.comprimentoAsas = comprimentoAsas;
    }

    public double getcomprimentoAsas() {
        return comprimentoAsas = comprimentoAsas;
    }

    public void setComprimentoAsas(double comprimentoAsas) {
        this.comprimentoAsas = comprimentoAsas;
    }

    public String toString() {
        String retorno = super.toString();
        retorno += "Comprimento das Asas: " + this.comprimentoAsas + " metros\n";
        retorno += "Status de decolagem: " + this.ativarVoo() + "\n";
        return retorno;
    }

    @Override
    public String ativarVoo() {
        if (getPeso() <= 512) {
            return "Decolando";
        } else return "Impossível levantar Voo, aeronave muito pesada!!!\nPESO LIMITE: 512kg";
    }
}
