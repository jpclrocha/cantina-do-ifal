package ifal.cantina;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    ArrayList<Produtos> estoqueDeProdutos = new ArrayList<>();

    public void cadastraProduto() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = input.nextLine();

        System.out.println("Digite a descrição do produto: ");
        String descricao = input.nextLine();
       
        System.out.println("Digite o preço de compra do produto: ");
        double preco_compra = input.nextDouble();

        System.out.println("Digite por quanto o produto vai ser vendido: ");
        double preco_venda = input.nextDouble();

        System.out.println("Digite a quantidade de produtos comprada: ");
        int quantidade = input.nextInt();

        if (preco_compra <= 0) {
            throw new Exception("Valor de compra inválido!");
        } else if (preco_venda <= preco_compra) {
            throw new Exception("Valor de venda não pode ser menor ou igual ao de compra!");
        } else if (quantidade <= 0) {
            throw new Exception("A quantidade de itens comprados é inválida");
        } else {
        	Produtos teste = new Produtos(nome.toLowerCase(), descricao, preco_compra, preco_venda, quantidade);
            
            estoqueDeProdutos.add(teste);
        }

    }
    public void vende(String nome, int quantidadeVendida){
        for (Produtos x : estoqueDeProdutos){
        	if(x.getName().equals(nome)) {
        		x.sellItem(quantidadeVendida);
        		System.out.println(x.toString());
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
