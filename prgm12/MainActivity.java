package com.example.database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private Button btnInsert;
    private Button btnSelect;
    private TextView tvResult;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Java variables to XML views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        tvResult = findViewById(R.id.tvResult);

        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        // Insert button
        btnInsert.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(
                        MainActivity.this,
                        "Please enter name and email",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            boolean inserted = dbHelper.insertData(name, email);

            if (inserted) {

                Toast.makeText(
                        MainActivity.this,
                        "Data inserted successfully",
                        Toast.LENGTH_SHORT
                ).show();

                etName.setText("");
                etEmail.setText("");

                // Refresh the displayed records
                tvResult.setText(dbHelper.getAllData());

            } else {

                Toast.makeText(
                        MainActivity.this,
                        "Insertion failed",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Select button
        btnSelect.setOnClickListener(v -> {

            String data = dbHelper.getAllData();
            tvResult.setText(data);

        });
    }

    @Override
    protected void onDestroy() {
        if (dbHelper != null) {
            dbHelper.close();
        }

        super.onDestroy();
    }
}