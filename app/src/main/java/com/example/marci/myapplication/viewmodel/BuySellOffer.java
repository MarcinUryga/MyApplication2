package com.example.marci.myapplication.viewmodel;

import com.example.marci.myapplication.model.Offer;

/**
 * * Created by marci on 2018-07-26.
 */
public class BuySellOffer {

  private Offer buyOffer;
  private Offer sellOffer;

  public BuySellOffer(Offer buyOffer, Offer sellOffer) {
    this.buyOffer = buyOffer;
    this.sellOffer = sellOffer;
  }

  public Offer getBuyOffer() {
    return buyOffer;
  }

  public void setBuyOffer(Offer buyOffer) {
    this.buyOffer = buyOffer;
  }

  public Offer getSellOffer() {
    return sellOffer;
  }

  public void setSellOffer(Offer sellOffer) {
    this.sellOffer = sellOffer;
  }
}
