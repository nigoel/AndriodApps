package com.example.nigoel.stayintouch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        renderCards();
    }

    private void renderCards() {
        Map<CardPrint, CardInfo> cards = loadCards();
        LinearLayout linear = (LinearLayout)findViewById(R.id.cardsButton);
        for(Map.Entry<CardPrint, CardInfo> card : cards.entrySet()) {
            Button myButton = card.getKey().buttonView(this);
            final CardInfo cardInfo = card.getValue();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            final int id_ = myButton.getId();
            linear.addView(myButton, params);
            Button btn1 = ((Button) findViewById(id_));
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    handleButtonDetails(cardInfo);
                }
            });
        }
    }

    private void handleButtonDetails(CardInfo cardInfo) {
    }

    private Map<CardPrint, CardInfo> loadCards() {
        Map<CardPrint, CardInfo> cardsMap = new HashMap<CardPrint, CardInfo>();
        cardsMap.put(CardPrint.getNewCardPrint(), CardInfo.getNewCardInfo());
        for(int i = 0 ; i < 10; i++) {
            CardPrint print = new CardPrint(i);
            CardInfo cardInfo = new CardInfo();
            cardsMap.put(print, cardInfo);
        }

        return cardsMap;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addCard(CardPrint rep, CardInfo info) {

    }
}
