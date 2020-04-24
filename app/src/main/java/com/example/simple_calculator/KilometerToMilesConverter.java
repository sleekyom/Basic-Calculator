package com.example.simple_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KilometerToMilesConverter extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button covertBtn;
    Button mileBtn;

    double kilometer;
    double miles;
    double kilo = 0.621371;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilometer_to_miles_converter);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.convertedValue);
        covertBtn = findViewById(R.id.convertBtn);
        mileBtn = findViewById(R.id.mileBtn);

        covertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kilometer = Double.parseDouble(String.valueOf(editText.getText()));

                miles = kilometer * kilo;
                textView.setText(String.valueOf(miles)+ " miles");
            }
        });

        mileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KilometerToMilesConverter.this, MilesToKilometer.class);
                startActivity(intent);
            }
        });


    }
}
