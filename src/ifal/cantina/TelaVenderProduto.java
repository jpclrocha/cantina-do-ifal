package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVenderProduto extends JFrame {
    private JLabel lblid;
    private JLabel lblproduto;
    private JTextField id;
    private JTextField produtoNome;
    private JLabel lblforma;
    private JTextField formaDePagamento;
    private JLabel lbldesconto;
    private JTextField desconto;
    private JLabel lblqtd;
    private JTextField qtd;
    private JButton botao;
    private JButton voltar;
    private Container ctn;
    public TelaVenderProduto(){
        //com erro
        setSize(420,420);
        setTitle("Vender produtos");
        ctn = getContentPane();
        voltar =  new JButton("Voltar");
        botao = new JButton("Vender");
        lblid = new JLabel("Digite o nome do produto a ser vendido:");
        lblproduto = new JLabel("Digite o código do produto a ser vendido:");
        lbldesconto = new JLabel("Digite a forma de pagamento do produto\n a ser vendido:");
        lblforma = new JLabel("Digite o desconto do produto a ser vendido:");
        lblqtd = new JLabel("Digite a quantidade do produto a ser vendido:");
        // o \n não funciona
        id = new JTextField();
        produtoNome = new JTextField();
        formaDePagamento = new JTextField();
        desconto = new JTextField();
        qtd = new JTextField();

        lblid.setBounds(10,10,250 , 25);
        id.setBounds(260 , 10 , 100,25);

        lblproduto.setBounds(10,40,250 , 25);
        produtoNome.setBounds(260 , 40 , 100,25);

        lbldesconto.setBounds(10,70,250 , 25);
        desconto.setBounds(260 , 70 , 100,25);

        lblforma.setBounds(10,100,250 , 25);
        formaDePagamento.setBounds(260 , 100 , 100,25);

        lblqtd.setBounds(10,130,250 , 25);
        qtd.setBounds(260 , 130 , 100,25);

        botao.setBounds(10,160,80,40);
        voltar.setBounds(100,160,80,40);

        ctn.add(lblid);
        ctn.add(id);

        ctn.add(lblproduto);
        ctn.add(produtoNome);

        ctn.add(lbldesconto);
        ctn.add(desconto);

        ctn.add(lblforma);
        ctn.add(formaDePagamento);

        ctn.add(lblqtd);
        ctn.add(qtd);

        ctn.add(botao);
        ctn.add(voltar);
        botao.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        vender(produtoNome,id,desconto, formaDePagamento, qtd);
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

    public void vender(JTextField id, JTextField produtoName, JTextField forma, JTextField descontoP, JTextField qtd){
        int codigo = Integer.parseInt(id.getText());
        String produtoNome = produtoName.getText();
        double desconto = Double.parseDouble(descontoP.getText());
        String formaDePagamento = forma.getText();
        int quantidade = Integer.parseInt(qtd.getText());
        ProdutoDAO produto =  new ProdutoDAO();
        VendaDAO venda = new VendaDAO();
        if(produto.vendeProduto(produtoNome,quantidade,codigo)){
            venda.insertVenda(produto.readProduto(),produtoNome, desconto, formaDePagamento, quantidade);
        }

    }
    public void voltar(){
        this.dispose();
        TelaPrincipal tl = new TelaPrincipal();
    }

    public static void main(String[] args) {
        TelaVenderProduto tle = new TelaVenderProduto();
    }
}



