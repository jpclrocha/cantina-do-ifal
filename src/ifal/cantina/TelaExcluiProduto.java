package ifal.cantina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaExcluiProduto extends JFrame {
    private JLabel nome;
    private JTextField texto;
    private JButton botao;
    private JButton voltar;
    private Container ctn;
    public TelaExcluiProduto(){
        setSize(420,420);
        setTitle("Excluir Produtos");
        ctn = getContentPane();
        voltar =  new JButton("Voltar");
        botao = new JButton("Excluir");
        nome = new JLabel("Digite o código do produto a ser excluido");
        texto = new JTextField();
        nome.setBounds(10,10,250 , 25);
        texto.setBounds(260 , 10 , 100,25);
        botao.setBounds(10,100,80,40);
        voltar.setBounds(100,100,80,40);
        ctn.add(nome);
        ctn.add(texto);
        ctn.add(botao);
        ctn.add(voltar);
        botao.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        excluir(texto);
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

    public void excluir(JTextField text){
        String numero = text.getText();
        int codigo = Integer.parseInt(numero);
        ProdutoDAO produto =  new ProdutoDAO();
        produto.deleteProduto(codigo);
    }
    public void voltar(){
        this.dispose();
        TelaPrincipal tl = new TelaPrincipal();
    }

    public static void main(String[] args) {
        TelaExcluiProduto tle = new TelaExcluiProduto();
    }
}
