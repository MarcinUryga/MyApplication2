package com.example.marci.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.marci.myapplication.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerView;

  List<Offer> sellOffers = new ArrayList<>();
  List<Offer> buyOffers = new ArrayList<>();
  OfferAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initOffers();
    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new OfferAdapter(sellOffers, buyOffers);
    recyclerView.setAdapter(adapter);
    adapter.publishSellPrice.subscribe(offer -> Toast.makeText(getBaseContext(), offer.getPrice().toString(), Toast.LENGTH_SHORT).show());
    adapter.publishBuyPrice.subscribe(offer -> Toast.makeText(getBaseContext(), offer.getPrice().toString(), Toast.LENGTH_SHORT).show());
  }

  private void initOffers() {
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
    /*sellOffers.add(new Offer(13.0, "2", 2.0));
    sellOffers.add(new Offer(14.0, "2", 2.0));
    sellOffers.add(new Offer(15.0, "2", 2.0));
    sellOffers.add(new Offer(16.0, "2", 2.0));
    sellOffers.add(new Offer(17.0, "2", 2.0));
    sellOffers.add(new Offer(18.0, "2", 2.0));
    sellOffers.add(new Offer(19.0, "2", 2.0));*/
    sellOffers.add(new Offer(20.0, "2", 2.0));
    sellOffers.add(new Offer(21.0, "2", 2.0));
    sellOffers.add(new Offer(22.0, "2", 2.0));
    sellOffers.add(new Offer(23.0, "2", 2.0));
    sellOffers.add(new Offer(24.0, "2", 2.0));
    sellOffers.add(new Offer(25.0, "2", 2.0));

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
  }
}
