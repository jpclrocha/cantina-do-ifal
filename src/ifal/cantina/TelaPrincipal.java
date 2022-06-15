package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JButton cadastrarProduto;

    private JButton excluirProduto;
    private JButton venderProduto;
    private JButton resumos;
    private Container ctn;

    public TelaPrincipal(){
        setSize(420,420);
        setTitle("Tela Principal");
        ctn = getContentPane();
        cadastrarProduto = new JButton("Cadastro de Produtos");
        excluirProduto = new JButton("Exclusao de Produtos");
        venderProduto = new JButton("Venda de produtos");
        resumos = new JButton("Resumos de lucro/prejuizo");

        cadastrarProduto.setBounds(10, 100, 300, 40);
        excluirProduto.setBounds(10, 150, 300, 40);
        venderProduto.setBounds(10, 200, 300, 40);
        resumos.setBounds(10,250,300,40);

        ctn.add(cadastrarProduto);
        ctn.add(resumos);
        ctn.add(excluirProduto);
        ctn.add(venderProduto);
        cadastrarProduto.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cadastrarProduto();
                    }
                }
        );

        excluirProduto.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        excluirProduto();
                    }
                }
        );
        venderProduto.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        venderProduto();
                    }
                }
        );
        resumos.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        resumos();
                    }
                }
        );
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cadastrarProduto(){
        this.dispose();
        TelaCadastroProduto tcp = new TelaCadastroProduto();
    }


    public void excluirProduto(){
        this.dispose();
        TelaExcluiProduto tcp = new TelaExcluiProduto();
    }

    public void venderProduto(){
        this.dispose();
        TelaVenderProduto tcp = new TelaVenderProduto();
    }

    public void resumos(){
        this.dispose();
        TelaResumos tr = new TelaResumos();
    }
    public static void main(String[] args) {
        TelaPrincipal tp = new TelaPrincipal();
    }
}
