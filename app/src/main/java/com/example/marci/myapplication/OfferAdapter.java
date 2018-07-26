package com.example.marci.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.marci.myapplication.model.Offer;
import com.example.marci.myapplication.viewmodel.BuySellOffer;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * * Created by marci on 2018-07-26.
 */
public class OfferAdapter extends RecyclerView.Adapter<OfferViewHolder> {

  PublishSubject<Offer> publishBuyPrice = PublishSubject.create();
  PublishSubject<Offer> publishSellPrice = PublishSubject.create();

  private List<Offer> sellOffers = new ArrayList<>();
  private List<Offer> buyOffers = new ArrayList<>();

  public OfferAdapter(List<Offer> sellOffers, List<Offer> buyOffers) {
    this.sellOffers = sellOffers;
    this.buyOffers = buyOffers;
  }

  @NonNull
  @Override
  public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return OfferViewHolder.create(parent);
  }

  @Override
  public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
    Offer sellOffer = position >= sellOffers.size() ? null : sellOffers.get(position);
    final Offer buyOffer = position >= buyOffers.size() ? null : buyOffers.get(position);
    holder.bind(new BuySellOffer(buyOffer, sellOffer));
    holder.itemView.findViewById(R.id.buyPrice).setOnClickListener(view -> publishBuyPrice.onNext(buyOffer));
    holder.itemView.findViewById(R.id.sellPrice).setOnClickListener(view -> publishSellPrice.onNext(sellOffer));
  }

  public Observable<Offer> getClickedBuyOffer() {
    return publishBuyPrice;
  }

  public Observable<Offer> getClickedSellOffer() {
    return publishSellPrice;
  }

  @Override
  public int getItemCount() {
    if (sellOffers.size() > buyOffers.size()) {
      return sellOffers.size();
    } else {
      return buyOffers.size();
    }
  }
}
