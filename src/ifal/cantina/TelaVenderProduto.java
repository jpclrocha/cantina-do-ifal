package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVenderProduto extends JFrame {
    private JLabel lblid;
    private JTextField id;

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
        lblid = new JLabel("Digite o código do produto a ser vendido:");
        id = new JTextField();

        lblid.setBounds(10,10,250 , 25);
        id.setBounds(260 , 10 , 100,25);


        botao.setBounds(10,100,80,40);
        voltar.setBounds(100,100,80,40);

        ctn.add(lblid);
        ctn.add(id);

        ctn.add(botao);
        ctn.add(voltar);
        botao.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        vender(id);
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

    public void vender(JTextField id){
        int codigo = Integer.parseInt(id.getText());
        ProdutoDAO produto =  new ProdutoDAO();
        produto.vendeProduto(codigo);
    }
    public void voltar(){
        this.dispose();
        TelaPrincipal tl = new TelaPrincipal();
    }

    public static void main(String[] args) {
        TelaVenderProduto tle = new TelaVenderProduto();
    }
}



