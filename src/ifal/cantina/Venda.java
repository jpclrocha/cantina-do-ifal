package ifal.cantina;
import java.time.LocalDate;
import java.util.Date;


public class Venda {
    private int codVenda;
    private Date dataVenda;
    private double desconto;
    private double totalVenda;
    private String formaDePagamento;

    public Venda(int codVenda, Date dataVenda, double desconto, double totalVenda, String formaDePagamento){
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.desconto = desconto;
        this.formaDePagamento = formaDePagamento;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
}
