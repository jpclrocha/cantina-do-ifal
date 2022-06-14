package ifal.cantina;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    private Connection connection;
    public ProdutoDAO(){
        try{
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String login = "root";
            String senha = "";
            this.connection = null;
            this.connection = DriverManager.getConnection(url, login, senha);
            System.out.println("Conectado.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Produtos> readProduto(){
        String sql = "SELECT * FROM produto";
        ArrayList<Produtos> estoqueDeProdutos = new ArrayList<Produtos>();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Produtos produto = new Produtos(result.getInt("id"), result.getString("nome"), result.getString("descricao"), result.getDouble("buyPrice"), result.getDouble("sellPrice"), result.getInt("amountBought"), result.getInt("availableAmount"), result.getInt("amountSold"));
                estoqueDeProdutos.add(produto);

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return estoqueDeProdutos;
    }

    public boolean insertProduto(Produtos produto){
        String sql = "INSERT INTO produto(nome, descricao, buyPrice, sellPrice, amountBought, availableAmount, amountSold) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getName());
            stmt.setString(2, produto.getDescription());
            stmt.setDouble(3, produto.getBuyPrice());
            stmt.setDouble(4, produto.getSellPrice());
            stmt.setInt(5, produto.getAmountBought());
            stmt.setInt(6, produto.getAvailableAmount());
            stmt.setInt(7, produto.getAmountSold());
            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateProduto(Produtos produto, int id){
        try{
            String sql = "UPDATE produto SET nome=?, descricao=?, buyPrice=?, sellPrice=?, amountBought=?, availableAmount=?, amountSold=? WHERE id =" + id;
            System.out.println(produto.getAvailableAmount());
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getName());
            stmt.setString(2, produto.getDescription());
            stmt.setDouble(3, produto.getBuyPrice());
            stmt.setDouble(4, produto.getSellPrice());
            stmt.setInt(5, produto.getAmountBought());
            stmt.setInt(6, produto.getAvailableAmount());
            stmt.setInt(7, produto.getAmountSold());

            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean deleteProduto(Integer id){
        String sql = "DELETE FROM produto WHERE id =" + id;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
