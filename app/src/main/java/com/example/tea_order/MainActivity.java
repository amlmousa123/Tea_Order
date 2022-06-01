package com.example.tea_order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   {
   Switch teaSwitch;
   CheckBox milkCB , sugarCB ;
   Spinner suggerSpinner ;
   Button orderButton ;
   boolean teaState , milkState , sugerState  ;
   int sugarItem ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teaSwitch =findViewById(R.id.tea_sw);
        milkCB = findViewById(R.id.milk_cb);
        sugarCB = findViewById(R.id.suger_cb);
        suggerSpinner =findViewById(R.id.sugar_sp);
        suggerSpinner.setVisibility(View.INVISIBLE);
        orderButton = findViewById(R.id.order_btn);

        teaSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teaState = teaSwitch.isChecked();
                if (teaState)
                    Toast.makeText(MainActivity.this, "your tea is hot", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "your tea is cold", Toast.LENGTH_SHORT).show();
            }
        });

        milkCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                milkState = b ;
            }
        });
        // milkState = milkCB.isChecked();

         sugarCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 suggerSpinner.setVisibility(View.VISIBLE);
                 sugerState = b;

             }
         });
         suggerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 sugarItem =i ;
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });




    }


    public void order(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("teaState",teaState);
        intent.putExtra("milkState",milkState);
        intent.putExtra("sugarState",sugerState);
        intent.putExtra("numOfSpoons",sugarItem);
        startActivity(intent);
    }
}