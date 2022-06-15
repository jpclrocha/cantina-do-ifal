package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeiraTela extends JFrame {
    private JButton cadastro;
    private JButton login;
    private Container ctn;
    public PrimeiraTela(){
        setSize(420,420);
        setTitle("Inicio");
        ctn = getContentPane();
        cadastro = new JButton("Cadastro de Funcionários");
        login = new JButton("Login de Funcionários");
        setLayout(null);
        cadastro.setBounds(50, 100, 300, 40);
        login.setBounds(50, 200,300,40);
        ctn.add(cadastro);
        ctn.add(login);
        cadastro.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cadastro();
                    }
                }
        );
        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        login();
                    }
                }
        );
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cadastro(){
        this.dispose();
        TelaCadastro tc = new TelaCadastro();
    }
    public void login(){
        this.dispose();
        TelaLogin tl = new TelaLogin();
    }
    public static void main(String[] args) {
        PrimeiraTela p = new PrimeiraTela();
    }

}
