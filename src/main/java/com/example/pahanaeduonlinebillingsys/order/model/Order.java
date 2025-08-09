package com.example.pahanaeduonlinebillingsys.order.model;

import java.util.Map;

public class Order {

    private String billid;
    private String accno;
    private Map<String, Integer> items;

  public String getBillid() {
      return billid;
  }

  public void setBillid(String billid) {
      this.billid = billid;
  }

  public String getAccno() {
      return accno;
  }

  public void setAccno(String accno) {
      this.accno = accno;
  }

  public Map<String, Integer> getItems() {
      return items;
  }

  public void setItems(Map<String, Integer> items) {
      this.items = items;
  }

}
