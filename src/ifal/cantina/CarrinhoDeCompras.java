package ifal.cantina;

import java.util.ArrayList;

public class CarrinhoDeCompras {
    ArrayList<Produtos> carrinho = new ArrayList<>();

    public void adiciona(Produtos produto){
        carrinho.add(produto);
    }

}
