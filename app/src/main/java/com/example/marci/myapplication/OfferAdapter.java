package com.example.marci.myapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

  public OfferAdapter() {
  }

  public void update(List<Offer> buyOffers, List<Offer> sellOffers) {
    this.buyOffers = buyOffers;
    this.sellOffers = sellOffers;
    notifyDataSetChanged();
  }

  public void clearAll() {
    this.sellOffers.clear();
    this.buyOffers.clear();
  }

  @NonNull
  @Override
  public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return OfferViewHolder.create(parent);
  }

  @Nullable
  private Offer getCurrentOfferFromList(int position, List<Offer> offerList) {
    return position >= offerList.size() ? null : offerList.get(position);
  }


  @Override
  public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
    Offer sellOffer = getCurrentOfferFromList(position, sellOffers);
    final Offer buyOffer = getCurrentOfferFromList(position, buyOffers);
    holder.bind(new BuySellOffer(buyOffer, sellOffer));
  /*  holder.itemView.findViewById(R.id.buyPrice).setOnClickListener(view -> publishBuyPrice.onNext(buyOffer));
    holder.itemView.findViewById(R.id.sellPrice).setOnClickListener(view -> publishSellPrice.onNext(sellOffer));*/
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
