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
        retorno += "Ativar Voo? " + this.ativarVoo() + "\n";
        return retorno;
    }
    public abstract boolean ativarVoo();

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidadepassageiros(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidademax() {
        return velocidademax;
    }

    public void setVelocidademax(double velocidademax) {
        this.velocidademax = velocidademax;
    }


}
