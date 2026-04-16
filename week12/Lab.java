import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.function.*;

class Product{
    private String  name;
    private double price;
    private boolean inStock;
    public Product(String name,double price, boolean inStock){
        this.price = price;
        this.inStock = inStock;
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public boolean getInStock(){
        return this.inStock;
    }

    @Override
    public String toString(){
        return "[PRODUCT] " + name + ", " + price + ", " + inStock;
    }
}

public class Lab {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<Product>(List.of(
                new Product("salt", 9.99, true),
                new Product("pepper", 7.99, true),
                new Product("potato", 19.99, true),
                new Product("toothbrush", 29.99, false)
        ));

//        Predicate<Product> isAffordable = new Predicate<Product>() {
//            @Override
//            public boolean test(Product p) {
//                return p.getPrice() < 50 && p.getInStock();
//            }
//
//        };

        final int priceLimit = 50;

        Predicate<Product> isAffordable = (p) -> (p.getPrice() < 50 && p.getInStock());
        Predicate<Product> isAffordable2 = (p) -> {
            products.add(null);
            return p.getPrice() < priceLimit && p.getInStock();
        };

        products.removeIf(isAffordable.negate());

        products.forEach(System.out::println);



    }
}
