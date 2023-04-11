package com.example.mp2_mvp;

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

    //===================================toString override=============================================
    @Override
    public String toString() { return "id = " + id + ", name = " + name + ", price = " + price + "\n"; }

}
