import java.text.DecimalFormat;
import java.time.LocalDateTime;

import Products.Products;
import Shop.Shop;

public class App {
    public static void main(String[] args) throws Exception {
         DecimalFormat formatValue = new DecimalFormat("#0.00");
        Products prod1 = new Products ("detergente", 2.5, 2);
        Products prod2 = new Products ("farinha", 5, 1);
        Products prod3 = new Products ("arroz", 20, 1);
        Products prod4 = new Products ("bolacha", 3.95, 6);
        Products prod5 = new Products ("suco", 7.48, 1);
        Products prod6 = new Products ("leite", 3.5, 2);
        Products prod7 = new Products ("café", 4.5, 3);
        Products prod8 = new Products ("açucar", 2.85, 1);
        Products prod9 = new Products ("feijão", 10, 1);
        Products prod10 = new Products ("macarrão", 8.74, 2);
        Products prod11 = new Products ("molho de tomate", 3.5, 3);
        Shop shop1 = new Shop(prod1, 1, LocalDateTime.now(), 0, 0, 0);
        shop1.addItem(prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11);
        System.out.println("O valor total da compra : " + shop1.totalValue());
        shop1.setValueShot(117.8);
        System.out.println("O palpite do valor pelo cliente : " + shop1.getValueShot());
        String discount = formatValue.format(shop1.discount()*100);
        System.out.println("O desconto e de : " + discount + "%");
        String finalValue = formatValue.format(shop1.payment());
        System.out.println("O valor a ser pago : " + finalValue);

    }
}

