import java.util.Scanner;
public class Menu{
  Estoque e = new Estoque();
  Scanner input = new Scanner(System.in);
  System.out.println("Bem vindo, escolha uma opção do menu!");
  int numero = input.nextInt();
  switch(numero){
    case 1:
      System.out.println("cadastro de produtos");
      break;

    case 2:
      System.out.println("venda de produtos");
      break;

    case 3:
      System.out.println("");
    default:
      System.out.println("teste2");
  }
}