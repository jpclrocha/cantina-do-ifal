package ifal.cantina;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        try {
            estoque.cadastraProduto();
            System.out.println(estoque.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
