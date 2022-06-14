package ifal.cantina;

import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private String senha;
    private int codigo;

    public Funcionario(int codigo, String nome, String senha){
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public static boolean verifica(int codigo, String nome, String senha, ArrayList<Funcionario> funcionarios){
        for(Funcionario x : funcionarios){
            return x.getCodigo() == codigo && x.getNome().equals(nome) && x.getSenha().equals(senha);
        }
        return false;
    }

}
