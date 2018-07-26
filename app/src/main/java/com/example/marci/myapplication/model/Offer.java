package com.example.marci.myapplication.model;

/**
 * * Created by marci on 2018-07-26.
 */
public class Offer {

  private Double price;
  private String amount;
  private Double something;

  public Offer(Double price, String amount, Double something) {
    this.price = price;
    this.amount = amount;
    this.something = something;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Double getSomething() {
    return something;
  }

  public void setSomething(Double something) {
    this.something = something;
  }
}
