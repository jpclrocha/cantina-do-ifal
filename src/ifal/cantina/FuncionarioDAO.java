package ifal.cantina;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(){
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

    public ArrayList<Funcionario> readFuncionario(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Funcionario funcionario = new Funcionario(result.getInt("codigo"), result.getString("nome"), result.getString("senha"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return funcionarios;
    }

    public boolean insertFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionario (codigo, nome, senha) VALUES (?,?,?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getCodigo());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getSenha());
            stmt.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
