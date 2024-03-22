package Shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Products.Products;


public class Shop {
    List<Products> items;
    int numPayment;
    LocalDateTime dayAndHour;
    double totalValue;
    double valueShot;
    double discount;
    double paymentValue;

    public Shop(Products item, int numPayment, LocalDateTime dayAndHour, double totalValue, double valueShot, double discount) {
        this.items = new ArrayList<>();
        this.numPayment = numPayment;
        this.dayAndHour = dayAndHour;
        this.totalValue = totalValue;
        this.valueShot = valueShot;
        this.discount = discount;
       
    }
    public void addItem(Products... items) {
        for (Products item : items) {
            this.items.add(item);
        }
    }
    public void removeItem(Products item) {
        this.items.remove(item);
    }
    public double getTotalValue() {
        return totalValue;
    }
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
    public double getValueShot() {
        return valueShot;
    }
    public void setValueShot(double valueShot) {
        if (valueShot > 0) {
            this.valueShot = valueShot;
         } else {
            throw new IllegalArgumentException("Valor do palpite não pode ser menor ou igual a zero");
         }
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public int getNumPayment() {
        return numPayment;
    }
    public void setNumPayment(int numPayment) {
        this.numPayment = numPayment;
    }
    public LocalDateTime getDayAndHour() {
        return dayAndHour;
    }
    public void setDayAndHour(LocalDateTime dayAndHour) {
        if (dayAndHour == null) {
            throw new NullPointerException("Data e hora não podem ser nulas");
        }
        this.dayAndHour = dayAndHour;
    }
    public double totalValue() {
        double total = 0;
        for (Products item : items) {
            total += item.prodTotalValue();
        }
        return this.totalValue = total;
    }

    public double calculatedDiscount() {
        double percentageDiscount; 
        percentageDiscount = (this.totalValue) - Math.floor(this.valueShot);
        return this.discount = percentageDiscount;    
    }
    public double discount() {
        if(Math.floor(totalValue) == Math.floor(valueShot)){
            return this.calculatedDiscount();
        } else if(totalValue == valueShot) {
            return 1;
        } else {
            return 0;
        }
    }
    public double payment(){
        if(totalValue == valueShot) {
            return this.paymentValue = 0;
        } else if (Math.floor(totalValue) == Math.floor(valueShot)) {
            return this.paymentValue = this.calculatedDiscount() * totalValue;
        } else {
            return this.paymentValue = totalValue;
        }
    }
}