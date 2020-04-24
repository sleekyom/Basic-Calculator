package com.example.simple_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView result;

    EditText editText1;
    EditText editText2;
    Button btnAdd, btnSub, btnDiv, btnMul, btnPower, reset, converterBtn;

    int num1, num2;
    double resultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = findViewById(R.id.result);

        editText1 = findViewById(R.id.editTextNumber1);

        editText2 = findViewById(R.id.editTextNumber2);

        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.subtraction);
        btnDiv = findViewById(R.id.division);
        btnMul = findViewById(R.id.multiply);
        btnPower = findViewById(R.id.exponent);
        reset = findViewById(R.id.reset);
        converterBtn = findViewById(R.id.converterBtn);


        // Adding button eventListeners

        //Addition
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(String.valueOf(editText1.getText()));
                num2 = Integer.parseInt(String.valueOf(editText2.getText()));

                resultNum = num1 + num2;
                result.setText(String.valueOf(resultNum));

                String finalAnswer = String.valueOf(resultNum);
                result.setText(String.valueOf(resultNum));
                String saveToDb = num1 + "+" + num2 + "=" + finalAnswer;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                HashMap<String, Object> equation = new HashMap<>();
                equation.put("equation: ", saveToDb);
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });

        //Subtraction
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());

                resultNum = num1 - num2;
                result.setText(String.valueOf(resultNum));

                String finalAnswer = String.valueOf(resultNum);
                result.setText(String.valueOf(resultNum));
                String saveToDb = num1 + "-" + num2 + "=" + finalAnswer;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                HashMap<String, Object> equation = new HashMap<>();
                equation.put("equation: ", saveToDb);
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });

        //Division
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());

                resultNum = num1 / num2;
                result.setText(String.valueOf(resultNum));

                String finalAnswer = String.valueOf(resultNum);
                result.setText(String.valueOf(resultNum));
                String saveToDb = num1 + "/" + num2 + "=" + finalAnswer;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                HashMap<String, Object> equation = new HashMap<>();
                equation.put("equation: ", saveToDb);
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });

        //Multiplication
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());

                resultNum = num1 * num2;


                String finalAnswer = String.valueOf(resultNum);
                result.setText(String.valueOf(resultNum));
                String saveToDb = num1 + "*" + num2 + "=" + finalAnswer;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                HashMap<String, Object> equation = new HashMap<>();
                equation.put("equation: ", saveToDb);
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });

        //PowerOf
        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(editText1.getText().toString());
                num2 = Integer.parseInt(editText2.getText().toString());

                resultNum = (Math.pow(num1, num2));


                String finalAnswer = String.valueOf(resultNum);
                result.setText(String.valueOf(resultNum));
                String saveToDb = num1 + "+" + num2 + "=" + finalAnswer;
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                HashMap<String, Object> equation = new HashMap<>();
                equation.put("equation: ", saveToDb);
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });

        // Reset button Listener
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(null);
                editText2.setText(null);

                result.setText(null);
            }
        });

        // Converter button Listener
        converterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KilometerToMilesConverter.class);
                startActivity(intent);
            }
        });
    }
}
