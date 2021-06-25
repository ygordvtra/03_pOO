import java.io.Serializable;

public abstract class Aeronave implements Serializable {

    private String modelo;
    private int capacidade;
    private double peso;
    private double velocidademax;

    public Aeronave(String modelo, int capacidade, double peso, double velocidademax){
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.peso = peso;
        this.velocidademax = velocidademax;
    }
    public String toString() {
        String retorno = "";
        retorno += "Modelo: " + this.modelo + "\n";
        retorno += "Capacidade: " + this.capacidade + " pessoas\n";
        retorno += "Peso: " + this.peso + " Kg\n";
        return retorno;
    }
}
