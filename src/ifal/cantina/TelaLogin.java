package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaLogin extends JFrame {
    private JButton botao;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblSenha;
    private JTextField txtSenha;
    private Container ctn;
    public TelaLogin() {
        setSize(420,420);
        setTitle("Tela de Login: ");
        ctn = getContentPane();
        botao = new JButton("Enviar");
        lblNome = new JLabel("Login: ");
        txtNome = new JTextField();
        lblSenha = new JLabel("Senha: ");
        txtSenha = new JTextField();
        setLayout(null);
        lblNome.setBounds(10, 10, 50, 25);
        txtNome.setBounds(100, 10, 100, 25);
        lblSenha.setBounds(10, 50, 50, 25);
        txtSenha.setBounds(100, 50, 100, 25);
        botao.setBounds(10, 100, 80, 40);
        ctn.add(lblNome);
        ctn.add(txtNome);
        ctn.add(lblSenha);
        ctn.add(txtSenha);
        ctn.add(botao);
        botao.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tratamentoBotao(txtNome , txtSenha);
                    }
                }
        );
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void tratamentoBotao(JTextField nome , JTextField senha){
        FuncionarioDAO func = new FuncionarioDAO();
        ArrayList<Funcionario> cadastrados = new ArrayList<>();
        String usuario = nome.getText();
        String password = senha.getText();
        for (Funcionario f : func.readFuncionario()){
            if (!f.getNome().equals(usuario) && !f.getSenha().equals(password)){
                JOptionPane.showMessageDialog(null, "Usuário não válido!");
            }else{
                this.dispose();
                TelaPrincipal tl = new TelaPrincipal();
            }
        }
    }
    public static void main(String[] args) {
        TelaLogin t1 = new TelaLogin();
    }
}

