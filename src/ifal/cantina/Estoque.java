package ifal.cantina;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    ArrayList<Produtos> estoqueDeProdutos = new ArrayList<>();

    public void cadastraProduto() throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = input.nextLine();

        System.out.println("Digite a descricao do produto: ");
        String descricao = input.nextLine();
       
        System.out.println("Digite o preco de compra do produto: ");
        double preco_compra = input.nextDouble();
        if (preco_compra <= 0) {
            throw new IllegalArgumentException("Valor de compra invalido!");
        }

        System.out.println("Digite por quanto o produto vai ser vendido: ");
        double preco_venda = input.nextDouble();
        if (preco_venda <= preco_compra || preco_venda <= 0) {
            throw new IllegalArgumentException("Valor de venda invalido!");
        }

        System.out.println("Digite a quantidade de produtos comprada: ");
        int quantidade = input.nextInt();
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de itens comprados eh invalida");
        } else {
        	Produtos teste = new Produtos(nome.toLowerCase(), descricao, preco_compra, preco_venda, quantidade);
            estoqueDeProdutos.add(teste);
        }
    }
    public void vende(String nome, int quantidadeVenda) throws IllegalArgumentException{
        if (quantidadeVenda <= 0){
            throw new IllegalArgumentException("O valor minimo de compra eh de 1 produto!");
        }else{
            for (Produtos x : estoqueDeProdutos){
                if(x.getName().equals(nome)) {
                    x.sellItem(quantidadeVenda);
                    System.out.println(x.toString());
                }
            }
        }
    }

    
    @Override
    public String toString(){
        String teste = "";
        teste += estoqueDeProdutos.toString();
        return teste;
    }
}
