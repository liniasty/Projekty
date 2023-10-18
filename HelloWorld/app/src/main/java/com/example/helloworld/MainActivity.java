package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pobieranie id
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(Kalkulator.wyswietl());
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttondziel = (Button) findViewById(R.id.buttondziel);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button buttonrazy = (Button) findViewById(R.id.buttonrazy);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button buttonminu = (Button) findViewById(R.id.buttonminu);
        Button button0 = (Button) findViewById(R.id.button0);
        Button buttonkrop = (Button) findViewById(R.id.buttonkrop);
        Button buttonrown = (Button) findViewById(R.id.buttonrown);
        Button buttondplus = (Button) findViewById(R.id.buttonplus);
        Button buttond10 = (Button) findViewById(R.id.button10);


    }

    public void klik(String i) {
        if (Kalkulator.list.size() < 10) {
            Kalkulator.list.add(i);
            TextView text = (TextView) findViewById(R.id.textView);
            text.setText(Kalkulator.wyswietl());
        }
    }
    public void checkKlik(String i){
        if(!Kalkulator.list.contains(i)){
            klik(i);
        }
    }

    public void kButton0(View view) {
        klik("0");
    }

    public void kButton1(View view) {
        klik("1");
    }

    public void kButton2(View view) {
        klik("2");
    }

    public void kButton3(View view) {
        klik("3");
    }

    public void kButton4(View view) {
        klik("4");
    }

    public void kButton5(View view) {
        klik("5");
    }

    public void kButton6(View view) {
        klik("6");
    }

    public void kButton7(View view) {
        klik("7");
    }

    public void kButton8(View view) {
        klik("8");
    }

    public void kButton9(View view) {
        klik("9");
    }

    public void kButtonkrop(View view) {
        checkKlik(".");

    }

    public void kButton10(View view) {
        if (Kalkulator.list.size() != 0) {
            Kalkulator.list.remove(Kalkulator.list.size() - 1);
            TextView text = (TextView) findViewById(R.id.textView);
            text.setText(Kalkulator.wyswietl());
        }
    }

    public void kButton11(View view) {
        Kalkulator.list.clear();
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(Kalkulator.wyswietl());
    }

    public void kButtonplus(View view) {
        checkKlik(" + ");
    }

    public void kButtonminu(View view){
        checkKlik(" - ");
    }
    public void kButtonrazy(View view){
        checkKlik(" * ");
    }
    public void kButtondzie(View view){
        checkKlik(" / ");
    }
    public void kButtonrown(View view){
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(Kalkulator.przelicz(Kalkulator.list));
    }
}