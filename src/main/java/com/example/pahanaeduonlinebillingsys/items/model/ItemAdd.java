package com.example.pahanaeduonlinebillingsys.items.model;

public class ItemAdd {

    private String itemno;
    private String itemname;
    private String quantity;
    private String unitprice;

    public ItemAdd(String itemno, String itemname, String quantity, String unitprice) {
        this.itemno = itemno;
        this.itemname = itemname;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

}
