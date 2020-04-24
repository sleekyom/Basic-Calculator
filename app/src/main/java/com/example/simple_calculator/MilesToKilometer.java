package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MilesToKilometer extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button covertBtn;

    double mile;
    double mileConst = 1.60934;
    double kilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miles_to_kilometer);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.convertedValue);
        covertBtn = findViewById(R.id.convertBtn);

        covertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mile = Double.parseDouble(String.valueOf(editText.getText()));

                kilo = mileConst * mile;
                textView.setText(String.valueOf(kilo) + " km");
            }
        });
    }


}
