
package ifal.cantina;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class Menu{
Estoque estoque = new Estoque();
	public void mainMenu() {
  		int numero = 0;
		while(numero != 7){
			Scanner input = new Scanner(System.in);
	  		System.out.println("Bem vindo, escolha uma opcao do menu!");
	  		System.out.println("1 - Cadastro de Produtos \n2 - Venda de produtos \n3 - Resumo de produtos pela descricao \n4 - Resumo de produtos pela quantidade disponível \n5 - Itens com baixa quantidade no estoque \n6 - Lucro/Prejuízo \n7 - Sair");
	  		numero = input.nextInt();
	   
	  		if(numero == 1) {
	  			System.out.println("cadastro de produtos");
	  			try {
	  				estoque.cadastraProduto();
	  			}
	  			catch(Exception e) {
	  				e.getMessage();
	  			}
			   
	  		}
	  		else if(numero == 2){
	  			System.out.println("Digite o nome do produto: ");
	  			String nome = input.next();

	  			System.out.println("Digite a quantidade de produtos: ");
	  	        int quantidade = input.nextInt();
	  			estoque.vende(nome, quantidade);
	  		}
			else if(numero == 3){
				System.out.println("Resumo dos itens pela descricao");
				Collections.sort(estoque.estoqueDeProdutos , new ComparadorDescricao());
				System.out.println(estoque.toString());

			}

			else if(numero == 4){
				System.out.println("Resumo dos itens pela quantidade disponivel");
				Collections.sort(estoque.estoqueDeProdutos , new ComparadorQtd());
				System.out.println(estoque.toString());
			}

			else if(numero == 5){
				System.out.println("Itens com baixa quantidade no estoque:");
				for (Produtos e : estoque.estoqueDeProdutos) {
					if(e.getAvailableAmount() < 50){
						System.out.println(e.getName());
					}
				}
			}

			else if(numero == 6){
				int vendas = 0;
				int compras = 0;
				System.out.println("Lucro / Prejuízo");
				for(Produtos e : estoque.estoqueDeProdutos){
					vendas += e.getAmountSold() * e.getSellPrice();
					compras += e.getAmountBought() * e.getBuyPrice();
				}

				if(vendas > compras){
					System.out.println("Total de lucro: R$" + (vendas - compras));
				}else if(vendas < compras){
					System.out.println("Total de prejuízo: R$" + (vendas - compras));
				}else{
					System.out.println("Voce nao teve lucro nem prejuizo.");
				}
			}
	  		
		}
	}
 
  
}