package com.example.mp2_mvp;

import java.util.Arrays;

public class Item {
    public int id = 0;
    public String name = "";
    public int quantityInShop = 0;
    public double price = 0;

    public Item(int id, String name, double price, int quantityInShop) {
        this.id = id;
        this.name = name;
        this.price = price;
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

        items[0] = new Item(0,"Coffee",0.10, 10);
        items[1] = new Item(1,"Flour",0.02,10);
        items[2] = new Item(2,"Bacon",0.05, 10);
        items[3] = new Item(3,"Clothing",5, 10);
        items[4] = new Item(4,"Rifle",20, 10);
        items[5] = new Item(5,"Shotgun",10, 10);
        items[6] = new Item(6,"Shots",5, 10);
        items[7] = new Item(7,"Oxen",50, 10);
        items[8] = new Item(8,"Spare Wagon Wheel",8, 10);
        items[9] = new Item(9,"Spare Axle",3, 10);
        items[10] = new Item(10,"Spare Wagon Tongue",3, 10);
        items[11] = new Item(11,"Medical Supply Box",1.5, 10);
        items[12] = new Item(12,"Sewing Kit",0.50, 10);
        items[13] = new Item(13,"Fire Starting Kit",0.25, 10);
        items[14] = new Item(14,"Kids' Toys",0.05, 10);
        items[15] = new Item(15,"Family Keepsakes",0, 10);
        items[16] = new Item(16,"Seed Packages",0.01, 10);
        items[17] = new Item(17,"Shovel",2.5, 10);
        items[18] = new Item(18,"Coffee Mill",1, 10);
        items[19] = new Item(19,"Frying Pan",1.5, 10);
        items[20] = new Item(20,"Pan",0.25, 10);
        items[21] = new Item(21,"Enchantment Table",400, 10);

        for (int i = 0; i < items.length; i++) {
            if (location.equals("Independence, Missouri")) {
                items[i].price = items[i].price;
            } else if (location.equals("Fort Leavenworth")) {
                items[i].price = items[i].price * 2;
            } else if (location.equals("Kansas River Crossing")) {
                items[i].price = items[i].price * 4;
            } else if (location.equals("Fort Kearny")) {
                items[i].price = items[i].price * 8;
            } else if (location.equals("Ash Hollow, Nebraska")) {
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
