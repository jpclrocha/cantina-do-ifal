
package ifal.cantina;
import java.util.Scanner;
public class Menu{
Estoque estoque = new Estoque();
	public void mainMenu() {
  		int numero = 0;
		while(numero != 3){
			Scanner input = new Scanner(System.in);
	  		System.out.println("Bem vindo, escolha uma opção do menu!");
	  		System.out.println("1 - Cadastro de Produtos \n2 - Venda de produtos");
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
	  			Scanner input2 = new Scanner(System.in);
	  			System.out.println("venda de produtos");
	  			
	  			System.out.println("Digite o nome do produto: ");
	  			String nome = input2.nextLine();
	  			
	  			System.out.println("Digite a quantidade de produtos: ");
	  	        int quantidade = input2.nextInt();
	  	        
	  			estoque.vende(nome, quantidade);
	  		}
	  		
		}
	}
 
  
}