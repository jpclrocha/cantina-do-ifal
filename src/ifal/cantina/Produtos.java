package ifal.cantina;

public class Produtos {
    private String nome;
    private String descricao;
    private double preco_compra;
    private double preco_venda;
    private int qtd_comprada;
    private int qtdDisponivel;

    private int qtd_vendida;

    public Produtos(String nome, String descricao, double preco_compra, double preco_venda, int qtd_comprada, int qtdDisponivel) throws Exception {
        if(preco_compra <= 0 || preco_venda <= 0 || preco_compra >= preco_venda){
            throw new Exception("Valor de venda invalido!");
        }else{
            this.nome = nome;
            this.descricao = descricao;
            this.preco_compra = preco_compra;
            this.preco_venda = preco_venda;
            this.qtd_comprada =  qtd_comprada;
            this.qtdDisponivel = qtdDisponivel;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd_vendida() {
        return qtd_vendida;
    }

    public void setQtd_vendida(int qtd_vendida) {
        this.qtd_vendida = qtd_vendida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public double getQtd_comprada() {
        return qtd_comprada;
    }

    public void setQtd_comprada(int qtd_comprada) {
        this.qtd_comprada = qtd_comprada;
    }

    public void vendeItem(int quantidade){
        this.qtdDisponivel -= quantidade;
    }


}
