package com.example.mp2_mvp;

import java.util.Arrays;

public class Item {
    public int id = 0;
    public String name = "";
    public int quantityInShop = 0;
    public double price = 0;
    private double newPrice;

    public Item(int id, String name, double price,double newPrice, int quantityInShop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.newPrice = newPrice;
        this.quantityInShop = quantityInShop;
    }

    //==============================================getters, setters=========================================================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityInShop() {
        return quantityInShop;
    }

    public void setQuantityInShop(int quantityInShop) {
        this.quantityInShop = quantityInShop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void displayWares(String location) {

        Item[] items = new Item[22];

        double x = 0;

        items[0] = new Item(0,"Coffee",0.10, x, 10);
        items[1] = new Item(1,"Flour",0.02, x, 10);
        items[2] = new Item(2,"Bacon",0.05, x, 10);
        items[3] = new Item(3,"Clothing",5, x, 10);
        items[4] = new Item(4,"Rifle",20, x, 10);
        items[5] = new Item(5,"Shotgun",10, x, 10);
        items[6] = new Item(6,"Shots",5, x, 10);
        items[7] = new Item(7,"Oxen",50, x, 10);
        items[8] = new Item(8,"Spare Wagon Wheel",8, x, 10);
        items[9] = new Item(9,"Spare Axle",3, x, 10);
        items[10] = new Item(10,"Spare Wagon Tongue",3, x, 10);
        items[11] = new Item(11,"Medical Supply Box",1.5, x, 10);
        items[12] = new Item(12,"Sewing Kit",0.50, x, 10);
        items[13] = new Item(13,"Fire Starting Kit",0.25, x, 10);
        items[14] = new Item(14,"Kids' Toys",0.05, x, 10);
        items[15] = new Item(15,"Family Keepsakes",0, x, 10);
        items[16] = new Item(16,"Seed Packages",0.01, x, 10);
        items[17] = new Item(17,"Shovel",2.5, x, 10);
        items[18] = new Item(18,"Coffee Mill",1, x, 10);
        items[19] = new Item(19,"Frying Pan",1.5, x, 10);
        items[20] = new Item(20,"Pan",0.25, x, 10);
        items[21] = new Item(21,"Enchantment Table",400, x, 10);

        for (int i = 0; i < items.length; i++) {
            if (location == "Independence, Missouri") {
                items[i].price = items[i].price;
            } else if (location == "Fort Leavenworth") {
                items[i].price = items[i].price * 2;
            } else if (location == "Kansas River Crossing") {
                items[i].price = items[i].price * 4;
            } else if (location == "Fort Kearny") {
                items[i].price = items[i].price * 8;
            } else if (location == "Ash Hollow, Nebraska") {
                items[i].price = items[i].price * 16;
            } else {
                items[i].price = items[i].price * 1000000;
                System.out.println("error: Item.displayWares()");
            }
        }

        System.out.println(Arrays.toString(items));

    }

    //===================================toString override=============================================
    @Override
    public String toString() { return "id = " + id + ", name = " + name + ", price = " + price + "\n"; }

}
