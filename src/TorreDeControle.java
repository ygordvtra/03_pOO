import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TorreDeControle {

    private ArrayList<Aeronave> naves = new ArrayList<Aeronave>();

    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public Planador lePlanador (){

        String [] valores = new String [4];
        String [] modeloVal = {"Modelo", "Capacidade de Passageiros", "Peso (Kg)", "Velocidade Máxima", "Comprimento das Asas"};
        valores = leValores (modeloVal);

        int capacidadepassageiros = this.retornaInteiro(valores[1]);
        double pesokg = this.retornaDouble(valores[2]);
        double velocidademax = this.retornaDouble(valores[3]);
        double comprimentoAsas = this.retornaDouble(valores [4]);

        Planador planador = new Planador (valores[0],capacidadepassageiros,pesokg,velocidademax, comprimentoAsas);
        return planador;
    }
    public Avião leAviao (){

        String [] valores = new String [4];
        String [] modeloVal = {"Modelo", "Capacidade de Passageiros", "Peso (Kg)", "Velocidade Máxima", "Quantidade de Turbinas"};
        valores = leValores (modeloVal);

        int capacidadepassageiros = this.retornaInteiro(valores[1]);
        double pesokg = this.retornaDouble(valores[2]);
        double velocidademax = this.retornaDouble(valores[3]);
        int qteTurbinas = this.retornaInteiro(valores [4]);

        Avião aviao = new Avião (valores[0],capacidadepassageiros,pesokg,velocidademax, qteTurbinas);
        return aviao;
    }

    public Helicoptero leHelicoptero (){

        String [] valores = new String [4];
        String [] modeloVal = {"Modelo", "Capacidade de Passageiros", "Peso (Kg)", "Velocidade Máxima", "Quantidade de Hélices"};
        valores = leValores (modeloVal);

        int capacidadepassageiros = this.retornaInteiro(valores[1]);
        double pesokg = this.retornaDouble(valores[2]);
        double velocidademax = this.retornaDouble(valores[3]);
        int qteHelices = this.retornaInteiro(valores [4]);

        Helicoptero helicoptero = new Helicoptero (valores[0],capacidadepassageiros,pesokg,velocidademax, qteHelices);
        return helicoptero;
    }

    private boolean intValido(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int retornaInteiro(String entrada) {
        int numInt;

        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
        }
        return Integer.parseInt(entrada);
    }

    private boolean doubleValido(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public double retornaDouble(String entrada) {
        float numFloat;

        while (!this.doubleValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número decimal.");
        }
        return Double.parseDouble(entrada);
    }

    public void salvaNaves (ArrayList<Aeronave> naves ){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("naves.dados"));
            for (int i=0; i < naves.size(); i++)
                outputStream.writeObject(naves.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    @SuppressWarnings("finally")
    public ArrayList<Aeronave> recuperaNaves (){
        ArrayList<Aeronave> navesTemp = new ArrayList<Aeronave>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("naves.dados"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Aeronave) {
                    navesTemp.add((Aeronave) obj);
                }
            }
        } catch (EOFException ex) {
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com aeronaves não existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return navesTemp;
        }
    }
    public void menuNaves (){

        String menu = "";
        String entrada;
        int    opc1, opc2;

        do {
            menu = "==================\n" +
                    "TORRE DE CONTROLE\n" +
                    "==================\n" +
                    "Opções:\n" +
                    "------------\n" +
                    "1. Inserir Aeronaves\n" +
                    "2. Exibir Aeronaves\n" +
                    "3. Limpar Dados\n" +
                    "4. Gravar Dados\n" +
                    "5. Recuperar Dados\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1: //Inserir dados
                    menu = "INSERIR AERONAVES\n" +
                            "Opções:\n" +
                            "------------\n" +
                            "1. Aviões\n" +
                            "2. Helicópteros\n" +
                            "3. Planadores";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2){
                        case 1: naves.add((Aeronave) leAviao());
                            break;
                        case 2: naves.add((Aeronave) leHelicoptero());
                            break;
                        case 3: naves.add((Aeronave) lePlanador());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Aeronave para entrada não escolhida!");
                    }

                    break;

                case 2: // Exibir dados
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Não há dados em memória. Adicione aeronaves primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < naves.size(); i++)	{
                        dados += naves.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;

                case 3: // Limpar Dados
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Não há dados em memória. Adicione aeronaves primeiramente");
                        break;
                    }
                    naves.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;

                case 4: // Gravar Dados
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Não há dados em memória. Adicione aeronaves primeiramente");
                        break;
                    }
                    salvaNaves(naves);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;

                case 5: // Recuperar Dados
                    naves = recuperaNaves();
                    if (naves.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Aplicativo TORRE DE CONTROLE finalizado com sucesso!");
                    break;
            }
        } while (opc1 != 9);
    }
    public static void main(String[] args) {

        TorreDeControle ca = new TorreDeControle();
        ca.menuNaves();
    }
}