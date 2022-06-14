package ifal.cantina;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VendaDAO {
    private Connection connection;
    public VendaDAO(){
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

    public ArrayList<Venda> readVenda(){
        String sql = "SELECT * FROM venda";
        ArrayList<Venda> vendas = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Venda venda = new Venda(result.getInt("cod_venda"), result.getDate("data_venda"), result.getDouble("desconto"), result.getDouble("total_venda"), result.getString("forma_de_pagamento"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vendas;
    }
    public boolean insertVenda(Produtos produto, double desconto, String formaDePagamento){
        String sql = "INSERT INTO venda(data_venda, desconto, total_venda, forma_de_pagamento) VALUES (?,?,?,?)";

        double valorTotal = produto.getSellPrice() - (produto.getSellPrice() * desconto / 100);

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setDouble(2, desconto);
            stmt.setDouble(3, valorTotal);
            stmt.setString(4, formaDePagamento);
            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void vendasMes(){
        String sql = "SELECT EXTRACT(MONTH FROM data_venda) as Mes, EXTRACT(YEAR FROM data_venda) as Ano, format(sum(total_venda),2, 'de_DE') as TotalVendas FROM venda GROUP BY Mes, Ano ORDER BY Ano, Mes";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                System.out.println("Mês " +result.getLong("Mes") + " | " + "Ano " + result.getLong("Ano") + " | " + "Total " + result.getString("totalVendas"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void vendasDia(){
        String sql = "SELECT EXTRACT(DAY FROM data_venda) as Dia ,EXTRACT(MONTH FROM data_venda) as Mes, EXTRACT(YEAR FROM data_venda) as Ano, format(sum(total_venda),2, 'de_DE') as TotalVendas FROM venda GROUP BY Dia, Mes, Ano ORDER BY Ano, Mes, Dia";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                System.out.println("Dia " +result.getLong("Dia") + " | " + "M~es " + result.getLong("Mes")+ " | " + "Ano " + result.getLong("Ano") + " | " + "Total " + result.getString("totalVendas"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
