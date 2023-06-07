package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText celsiusEditText;
    private Button convertBtn;
    private TextView fahrenheitResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusEditText = findViewById(R.id.celsiusEditText);
        convertBtn = findViewById(R.id.convertBtn);
        fahrenheitResultTextView = findViewById(R.id.fahrenheitResultTextView);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusString = celsiusEditText.getText().toString().trim();

                if (!celsiusString.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusString);
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    fahrenheitResultTextView.setText(String.valueOf(fahrenheit));
                } else {
                    fahrenheitResultTextView.setText("");
                }
            }
        });
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
