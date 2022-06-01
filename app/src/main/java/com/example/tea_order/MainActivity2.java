package com.example.tea_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = findViewById(R.id.tv);
        Intent intent = getIntent();
        if(intent.getBooleanExtra("teaState",false) ){
            textView.setText("Here you are ,your tea is hot");
        }else{
            textView.setText("Here you are ,your tea is cold");
        }
        if(intent.getBooleanExtra("milkState",false) ) {
            textView.append(" with milk");
        }else {
            textView.append(" without milk");
        }
        if(intent.getBooleanExtra("sugarState",false) ) {
            int numOfSpoons= intent.getIntExtra("numOfSpoons",0);
            if (numOfSpoons==0){
                textView.append(" and one sugar spoon on it");
            } else if (numOfSpoons==1){
                textView.append(" and two sugar spoons on it");
            }else{
                textView.append(" and three sugar spoons on it");
            }
        }else{
            textView.append(" without sugar");
        }
    }
}
