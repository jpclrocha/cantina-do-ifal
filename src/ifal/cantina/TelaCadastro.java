package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCadastro extends JFrame {
    private JButton botao;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblSenha;
    private JTextField txtSenha;
    private Container ctn;
    public TelaCadastro() {
        setSize(420,420);
        setTitle("Tela de Cadastro");
        ctn = getContentPane();
        botao = new JButton("Enviar");
        lblNome = new JLabel("Digite um usuario para login: ");
        txtNome = new JTextField();
        lblSenha = new JLabel("Digite uma senha para login: ");
        txtSenha = new JTextField();
        setLayout(null);
        lblNome.setBounds(10, 10, 170, 25);
        txtNome.setBounds(200, 10, 100, 25);
        lblSenha.setBounds(10, 50, 170, 25);
        txtSenha.setBounds(200, 50, 100, 25);
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
        String usuario = nome.getText();
        String password = senha.getText();
        Funcionario f = new Funcionario(usuario,password);
        func.insertFuncionario(f);
        this.dispose();
        TelaLogin tl = new TelaLogin();
    }
    public static void main(String[] args) {
        TelaCadastro t1 = new TelaCadastro();
    }
}


