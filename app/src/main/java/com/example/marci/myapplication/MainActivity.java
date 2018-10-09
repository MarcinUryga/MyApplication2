package com.example.marci.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.marci.myapplication.model.Offer;
import com.example.marci.myapplication.model.Offers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.schedulers.TimeInterval;

public class MainActivity extends AppCompatActivity {

  Button buyButton;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.communicate_activity);
    buyButton = findViewById(R.id.buyButton);
    buyButton.setEnabled(true);
  }

  /* RecyclerView recyclerView;

  OfferAdapter adapter = new OfferAdapter();

  Context thisContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Offers offers = createOffers();
    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    adapter = new OfferAdapter(sellOffers, buyOffers);
    adapter.update(offers.getBuyOffer(), offers.getSellOffer());
    recyclerView.setAdapter(adapter);
    thisContext = getBaseContext();
    getObservableOffers()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(result ->
            update(result.getBuyOffer(), result.getSellOffer())
        );
    adapter.publishSellPrice.subscribe(offer -> Toast.makeText(getBaseContext(), offer.getPrice().toString(), Toast.LENGTH_SHORT).show());
    adapter.publishBuyPrice.subscribe(offer -> Toast.makeText(getBaseContext(), offer.getPrice().toString(), Toast.LENGTH_SHORT).show());
  }

  public void update(List<Offer> buyOffers, List<Offer> sellOffers) {
    adapter.clearAll();
    adapter.update(buyOffers, sellOffers);
  }

  private Observable<Offers> getObservableOffers() {
    return Observable.interval(5, TimeUnit.SECONDS).timeInterval()
        .flatMap((Func1<TimeInterval<Long>, Observable<Offers>>) longTimeInterval -> Observable.just(createOffers()));
  }

  private Offers createOffers() {
    List<Offer> sellOffers = new ArrayList<>();
    sellOffers.add(new Offer(1.0, "2", 2.0));
    sellOffers.add(new Offer(2.0, "2", 2.0));
    sellOffers.add(new Offer(3.0, "2", 2.0));
    sellOffers.add(new Offer(4.0, "2", 2.0));
    sellOffers.add(new Offer(55555.0, "2", 2.0));
    sellOffers.add(new Offer(6.0, "2", 2.0));
    sellOffers.add(new Offer(7.0, "2", 2.0));
    sellOffers.add(new Offer(8.0, "2", 2.0));
    sellOffers.add(new Offer(9.0, "2", 2.0));
    sellOffers.add(new Offer(10.0, "2", 2.0));
    sellOffers.add(new Offer(11.0, "2", 2.0));
    sellOffers.add(new Offer(12.0, "2", 2.0));
    sellOffers.add(new Offer(13.0, "2", 2.0));
    sellOffers.add(new Offer(14.0, "2", 2.0));
    sellOffers.add(new Offer(15.0, "2", 2.0));
    sellOffers.add(new Offer(16.0, "2", 2.0));
    sellOffers.add(new Offer(17.0, "2", 2.0));
    sellOffers.add(new Offer(18.0, "2", 2.0));
    sellOffers.add(new Offer(19.0, "2", 2.0));
    sellOffers.add(new Offer(20.0, "2", 2.0));
    sellOffers.add(new Offer(21.0, "2", 2.0));
    sellOffers.add(new Offer(22.0, "2", 2.0));
    sellOffers.add(new Offer(23.0, "2", 2.0));
    sellOffers.add(new Offer(24.0, "2", 2.0));
    sellOffers.add(new Offer(25.0, "2", 2.0));
    sellOffers.add(new Offer(26.0, "2", 2.0));
    sellOffers.add(new Offer(27.0, "2", 2.0));
    sellOffers.add(new Offer(28.0, "2", 2.0));
    sellOffers.add(new Offer(29.0, "2", 2.0));
    sellOffers.add(new Offer(30.0, "2", 2.0));
    sellOffers.add(new Offer(31.0, "2", 2.0));
    sellOffers.add(new Offer(32.0, "2", 2.0));
    sellOffers.add(new Offer(33.0, "2", 2.0));
    sellOffers.add(new Offer(34.0, "2", 2.0));
    sellOffers.add(new Offer(35.0, "2", 2.0));
    sellOffers.add(new Offer(36.0, "2", 2.0));
    sellOffers.add(new Offer(37.0, "2", 2.0));
    sellOffers.add(new Offer(38.0, "2", 2.0));
    sellOffers.add(new Offer(39.0, "2", 2.0));
    sellOffers.add(new Offer(40.0, "2", 2.0));
    sellOffers.add(new Offer(41.0, "2", 2.0));
    sellOffers.add(new Offer(42.0, "2", 2.0));
    sellOffers.add(new Offer(43.0, "2", 2.0));
    sellOffers.add(new Offer(44.0, "2", 2.0));
    sellOffers.add(new Offer(45.0, "2", 2.0));

    List<Offer> buyOffers = new ArrayList<>();
    buyOffers.add(new Offer(25.0, "2", 2.0));
    buyOffers.add(new Offer(24.0, "2", 2.0));
    buyOffers.add(new Offer(23.0, "2", 2.0));
    buyOffers.add(new Offer(22.0, "2", 2.0));
    buyOffers.add(new Offer(21.0, "2", 2.0));
    buyOffers.add(new Offer(20.0, "2", 2.0));
    buyOffers.add(new Offer(19.0, "2", 2.0));
    buyOffers.add(new Offer(18.0, "2", 2.0));
    buyOffers.add(new Offer(17.0, "2", 2.0));
    buyOffers.add(new Offer(16.0, "2", 2.0));
//    buyOffers.add(new Offer(15.0, "2", 2.0));
    buyOffers.add(new Offer(14.0, "2", 2.0));
    buyOffers.add(new Offer(13.0, "2", 2.0));
    buyOffers.add(new Offer(12.0, "2", 2.0));
    buyOffers.add(new Offer(11.0, "2", 2.0));
    buyOffers.add(new Offer(10.0, "2", 2.0));
    buyOffers.add(new Offer(99999.0, "2", 2.0));
    buyOffers.add(new Offer(8.0, "2", 2.0));
    buyOffers.add(new Offer(7.0, "2", 2.0));
    buyOffers.add(new Offer(6.0, "2", 2.0));
    buyOffers.add(new Offer(5.0, "2", 2.0));
    buyOffers.add(new Offer(4.0, "2", 2.0));
    buyOffers.add(new Offer(3.0, "2", 2.0));
    buyOffers.add(new Offer(2.0, "2", 2.0));
    return new Offers(buyOffers, sellOffers);
  }*/
}
