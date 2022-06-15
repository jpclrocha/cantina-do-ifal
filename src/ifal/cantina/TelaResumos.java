package ifal.cantina;

import javax.swing.*;
import java.awt.*;

public class TelaResumos extends JFrame{
    private JButton gerar;
    private JLabel nome;
    private JTextField texto;
    private Container ctn;
    public TelaResumos() {
        setSize(420,420);
        setTitle("Resumos");
        ctn = getContentPane();
        nome = new JLabel("Resumo dos lucros / prejuizos");
        texto = new JTextField();
        gerar =  new JButton("Gerar");

        nome.setBounds(10,10,190,25);
        texto.setBounds(200,10,50,25);
        gerar.setBounds(10,40,100,25);
        ctn.add(nome);
        ctn.add(texto);
        ctn.add(gerar);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TelaResumos tr = new TelaResumos();
    }
}
