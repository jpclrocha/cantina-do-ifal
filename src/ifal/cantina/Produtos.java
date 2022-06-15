package ifal.cantina;

public class Produtos {
        private int id;
        private String name;
        private String description;
        private double buyPrice;
        private double sellPrice;
        private int amountBought;
        private int availableAmount;
        private int amountSold;

    public Produtos(String name, String description, double buyPrice, double sellPrice, int amountBought){
        // Verifico se os valores são válidos antes de cadastrar no estoque
        this.name = name;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.amountBought =  amountBought;
        this.availableAmount = amountBought;

    }

    public Produtos(int id, String nome, String descricao, double buyPrice, double sellPrice, int amountBought, int amountBought1, int amountSold) {
        this.id = id;
        this.name = nome;
        this.description = descricao;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.amountBought =  amountBought;
        this.availableAmount = amountBought1;
        this.amountSold = amountSold;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountSold() {
        return amountSold;
    }
    public void setAmountSold(int amountSold) {
        this.amountSold += amountSold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getAmountBought() {
        return amountBought;
    }

    public void setAmountBought(int amountBought) {
        this.amountBought = amountBought;
    }

    public boolean sellItem(int amount){

    	if (this.availableAmount >= amount ) {
    		this.availableAmount -= amount;
    		this.amountSold += amount;
    		this.toString();
            return true;
    	}
    	else {
    		System.out.println("Quantidade Indispon�vel.");
            return false;
    	}
        
    }
    public void atualizaProduto(String name, String description, double buyPrice, double sellPrice, int amountBought, int amountSold){
        this.name = name;
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.amountBought =  amountBought;
        this.availableAmount = amountBought;
        this.amountSold = amountSold;
    }


    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount -= availableAmount;
    }


    public String QtdeNome(){
        return "Nome: " + getName() + " Quantidade Disponivel: " + getAvailableAmount();
    }

    @Override
    public String toString(){
        String word = "";
        word += "Name: "+ getName() + "\n";
        word += "Description: " + getDescription() + "\n";
        word += "Available Amount: " + getAvailableAmount();
        return word;
    }
}
