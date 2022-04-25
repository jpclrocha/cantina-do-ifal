package ifal.cantina;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        try {
            for(int i = 0; i < 4; i++) {
                estoque.cadastraProduto();
            }
            System.out.println(estoque.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
