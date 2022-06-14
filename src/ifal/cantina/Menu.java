
package ifal.cantina;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Menu{
Estoque estoque = new Estoque();
	public void mainMenu() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produtos> estoqueDeProdutos = produtoDAO.readProduto();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = funcionarioDAO.readFuncionario();
        int numero = 0;
  		int numeroP = 0;
		while(numeroP != 3){
			Scanner input = new Scanner(System.in);
			input.useDelimiter("\r?\n");
	  		System.out.println("Bem vindo, escolha uma opcao do menu!");
	  		System.out.println("1 - Funcionario \n2 - Normal \n3 - Sair");
	  		numeroP = input.nextInt();
			if(numeroP == 1){
                System.out.println("Digite seu código : ");
                int codigo = input.nextInt();

                System.out.println("Digite seu nome :");
                String nome = input.next();

                System.out.println("Digite sua senha :");
                String senha = input.next();
                if(Funcionario.verifica(codigo, nome, senha, funcionarios)){
                    System.out.println("1 - Cadastro de Produtos");
                    System.out.println("2 - Alterar produto");
                    System.out.println("3 - Deletar produto");

                    numero = input.nextInt();
                    if (numero == 1) {
                        System.out.println("cadastro de produtos");
                        try {
                            estoque.cadastraProduto();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    } else if (numero == 2) {

                        System.out.println("Digite o nome antigo do produto: ");
                        String nomeProduto = input.next();
                        for (Produtos x : estoqueDeProdutos){
                            if(x.getName().equals(nomeProduto)) {
                                System.out.println(x.toString());
                                System.out.println("Digite o nome do produto: ");
                                String nomeNovo = input.next();

                                System.out.println("Digite a descrição do produto: ");
                                String descricao = input.next();

                                System.out.println("Digite o preço de compra do produto: ");
                                double preco_compra = input.nextDouble();

                                System.out.println("Digite por quanto o produto vai ser vendido: ");
                                double preco_venda = input.nextDouble();

                                System.out.println("Digite a quantidade de produtos comprada: ");
                                int quantidade = input.nextInt();

                                Produtos novoProduto = new Produtos(nomeNovo.toLowerCase(), descricao, preco_compra, preco_venda, quantidade, 0);
                                produtoDAO.updateProduto(novoProduto, x.getId());
                                x.atualizaProduto(nomeNovo.toLowerCase(), descricao, preco_compra, preco_venda, quantidade, 0);
                            }
                        }
                    } else if (numero == 3) {
                        System.out.println("Digite o nome do produto: ");
                        String nomeProduto = input.next();
                        for (Produtos x : estoqueDeProdutos){
                            if(nomeProduto.equals(x.getName())){
                                produtoDAO.deleteProduto(x.getId());
                            }
                        }
                    }

                }
                else {
                    System.out.println("Fomos abalados fortemente.");
                }
			}
			else if (numeroP == 2) {
				System.out.println("1 - Venda de produtos \n2 - Resumo de produtos pela descricao \n3 - Resumo de produtos pela quantidade disponível \n4 - Itens com baixa quantidade no estoque \n5 - Lucro/Prejuízo \n6 - Vendas por mês \n7 - Vendas por dia");
				numero = input.nextInt();
				if (numero == 1) {
					System.out.println("Digite o nome do produto: ");
					String nome = input.next();

					System.out.println("Digite a quantidade de produtos: ");
					int quantidade = input.nextInt();

					System.out.println("Digite o desconto da venda : ");
					double desconto = input.nextDouble();

					System.out.println("Digite a forma de pagamento da venda : ");
					String formaDePagamento = input.next();
					estoque.vende(nome, quantidade, desconto, formaDePagamento);
				} else if (numero == 2) {
					System.out.println("Resumo dos itens pela descricao");
					Collections.sort(estoque.estoqueDeProdutos, new ComparadorDescricao());
					System.out.println(estoque.toString());

				} else if (numero == 3) {
					System.out.println("Resumo dos itens pela quantidade disponivel");
					Collections.sort(estoque.estoqueDeProdutos, new ComparadorQtd());
					System.out.println(estoque.toString());
				} else if (numero == 4) {
					System.out.println("Itens com baixa quantidade no estoque:");
					for (Produtos e : estoque.estoqueDeProdutos) {
						if (e.getAvailableAmount() < 50) {
							System.out.println(e.getName());
						}
					}
				} else if (numero == 5) {
					int vendas = 0;
					int compras = 0;
					System.out.println("Lucro / Prejuízo");
					for (Produtos e : estoque.estoqueDeProdutos) {
						vendas += e.getAmountSold() * e.getSellPrice();
						compras += e.getAmountBought() * e.getBuyPrice();
					}

					if (vendas > compras) {
						System.out.println("Total de lucro: R$" + (vendas - compras));
					} else if (vendas < compras) {
						System.out.println("Total de prejuízo: R$" + (vendas - compras));
					} else {
						System.out.println("Voce nao teve lucro nem prejuizo.");
					}
				} else if (numero == 6) {
					estoque.vendasMes();
				} else if (numero == 7) {
					estoque.vendasDia();
				}
			}

		}
	}
 
  
}