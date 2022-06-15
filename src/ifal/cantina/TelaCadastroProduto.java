package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroProduto extends JFrame {
    private JLabel lblnome;
    private JLabel lbldes;
    private JLabel lblpre;
    private JLabel lblven;
    private JLabel lblcom;
    private JTextField nome;
    private JTextField descricao;
    private JTextField preco;
    private JTextField venda;
    private JTextField comprado;
    private JButton botao;
    private JButton voltar;
    private Container ctn;
    public TelaCadastroProduto(){
        setSize(420,420);
        setTitle("Excluir Produtos");
        ctn = getContentPane();
        voltar =  new JButton("Voltar");
        botao = new JButton("Cadastrar");

        lblnome = new JLabel("Nome do produto:");
        nome = new JTextField();

        lbldes = new JLabel("Descricao do produto:");
        descricao =  new JTextField();

        lblpre =  new JLabel("Preco de compra:");
        preco = new JTextField();

        lblven = new JLabel("Preco de venda:");
        venda = new JTextField();

        lblcom = new JLabel("Quantidade comprada:");
        comprado = new JTextField();

        lblnome.setBounds(10,10,120,25);
        nome.setBounds(130,10,100 , 25);

        lbldes.setBounds(10,40,150,25);
        descricao.setBounds(160,40,100 , 25);

        lblpre.setBounds(10,80,120,25);
        preco.setBounds(130,80,100 , 25);

        lblven.setBounds(10,120,120,25);
        venda.setBounds(130,120,100 , 25);

        lblcom.setBounds(10,160,150,25);
        comprado.setBounds(160,160,100 , 25);

        botao.setBounds(10,200,130,40);
        voltar.setBounds(160,200,80,40);

        ctn.add(lblnome);
        ctn.add(nome);
        ctn.add(lbldes);
        ctn.add(descricao);
        ctn.add(lblpre);
        ctn.add(preco);
        ctn.add(lblven);
        ctn.add(venda);
        ctn.add(lblcom);
        ctn.add(comprado);
        ctn.add(botao);
        ctn.add(voltar);
        botao.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cadastrar(nome, descricao, preco , venda, comprado);
                    }
                }
        );
        voltar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        voltar();
                    }
                }
        );
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cadastrar(JTextField nome,JTextField descricao , JTextField preco, JTextField precoVenda, JTextField comprado){
        String name = nome.getText();
        String description =  descricao.getText();
        double buyPrice = Double.parseDouble(preco.getText());
        double sellPrice = Double.parseDouble(precoVenda.getText());
        int amountBought = Integer.parseInt(comprado.getText());
        ProdutoDAO dao = new ProdutoDAO();
        Produtos p = new Produtos(name,description,buyPrice,sellPrice,amountBought);
        dao.insertProduto(p);
    }
    public void voltar(){
        this.dispose();
        TelaPrincipal tl = new TelaPrincipal();
    }

    public static void main(String[] args) {
        TelaCadastroProduto tle = new TelaCadastroProduto();
    }
}
