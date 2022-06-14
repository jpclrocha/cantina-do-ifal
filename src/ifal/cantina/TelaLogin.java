package ifal.cantina;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblSenha;
    private JTextField txtSenha;
    public TelaLogin() {
        lblNome = new JLabel("Login: ");
        txtNome = new JTextField();
        lblSenha = new JLabel("Senha: ");
        txtSenha = new JTextField();
        setSize(800, 600);
        setTitle("Tela Inicial");
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout(2,2));
        lblNome.setBounds(10, 10, 100, 25);
        txtNome.setBounds(30, 10, 50, 10);
        lblSenha.setBounds(10, 10, 100, 25);
        txtSenha.setBounds(30, 10, 50, 10);
        add(lblNome);
        add(txtNome);
        add(lblSenha);
        add(txtSenha);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        TelaLogin t1 = new TelaLogin();
    }
}

