package Products;
public class Products {
    String name;
    double price;
    int quantity; 

    public Products(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
         } else {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
         }
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if (price > 0) {
            this.price = price;
         } else {
            throw new IllegalArgumentException("Preço não pode ser menor ou igual a zero");
         }
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        if (quantity > 0) {
            this.quantity = quantity;
         } else {
            throw new IllegalArgumentException("Quantidade não pode ser menor ou igual a zero");
         }
    }
    public double prodTotalValue(){
        return getPrice() * getQuantity();
    }
}