package com.example.marci.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marci.myapplication.model.Offer;
import com.example.marci.myapplication.viewmodel.BuySellOffer;

/**
 * * Created by marci on 2018-07-26.
 */
public class OfferViewHolder extends RecyclerView.ViewHolder {

  TextView buyPrice;
  TextView buyAmount;
  TextView buySomething;

  TextView sellPrice;
  TextView sellAmount;
  TextView sellSomething;

  private OfferViewHolder(View itemView) {
    super(itemView);
    buyPrice = itemView.findViewById(R.id.buyPrice);
    buyAmount = itemView.findViewById(R.id.buyAmount);
    buySomething = itemView.findViewById(R.id.buySomething);

    sellPrice = itemView.findViewById(R.id.sellPrice);
    sellAmount = itemView.findViewById(R.id.sellAmount);
    sellSomething = itemView.findViewById(R.id.sellSomething);
  }

  public void bind(BuySellOffer buySellOffer) {
    setUpBuyOffer(buySellOffer.getBuyOffer());
    setUpSellOffer(buySellOffer.getSellOffer());
  }

  private void setUpBuyOffer(Offer buyOffer) {
    if (buyOffer != null) {
      buyPrice.setText(buyOffer.getPrice() + " ");
      buyAmount.setText(buyOffer.getAmount() + " ");
      buySomething.setText(buyOffer.getSomething() + " ");
    } else {
      buyPrice.setText("");
      buyAmount.setText("");
      buySomething.setText("");
    }
  }

  private void setUpSellOffer(Offer sellOffer) {
    if (sellOffer != null) {
      sellPrice.setText(sellOffer.getPrice() + " ");
      sellAmount.setText(sellOffer.getAmount() + " ");
      sellSomething.setText(sellOffer.getSomething() + " ");
    } else {
      sellPrice.setText("");
      sellAmount.setText("");
      sellSomething.setText("");
    }
  }

  public static OfferViewHolder create(ViewGroup parent) {
    return new OfferViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item, parent, false));
  }
}
