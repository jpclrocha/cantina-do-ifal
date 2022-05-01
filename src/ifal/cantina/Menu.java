
package ifal.cantina;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class Menu{
Estoque estoque = new Estoque();
	public void mainMenu() {
  		int numero = 0;
		System.out.println("Bem vindo, escolha uma opcao do menu!");
		while(numero != 7){
			Scanner input = new Scanner(System.in);
	  		System.out.println("1 - Cadastro de Produtos \n2 - Venda de produtos \n3 - Resumo de produtos pela descricao \n4 - Resumo de produtos pela quantidade disponivel \n5 - Itens com baixa quantidade no estoque \n6 - Lucro/Prejuizo \n7 - Sair");
	  		numero = input.nextInt();
	   
	  		if(numero == 1) {
	  			try {
	  				estoque.cadastraProduto();
	  			}
	  			catch(IllegalArgumentException iae) {
					System.out.println(iae.getMessage());
	  			}
			   
	  		}
	  		else if(numero == 2){
	  			try{
					System.out.println("Digite o nome do produto: ");
					String nome = input.next();

					System.out.println("Digite a quantidade de produtos: ");
					int quantidade = input.nextInt();
					estoque.vende(nome, quantidade);
				}catch (IllegalArgumentException iae){
					System.out.println(iae.getMessage());
				}
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
				double vendas = 0;
				double compras = 0;
				System.out.println("Lucro / Prejuizo");
				for(Produtos e : estoque.estoqueDeProdutos){
					vendas += e.getAmountSold() * e.getSellPrice();
					compras += e.getAmountBought() * e.getBuyPrice();
				}

				if(vendas > compras){
					System.out.println("Total de lucro: R$" + (vendas - compras));
				}else if(vendas < compras){
					System.out.println("Total de prejuizo: R$" + (vendas - compras));
				}else{
					System.out.println("Voce nao teve lucro nem prejuizo.");
				}
			}
	  		
		}
	}
 
  
}