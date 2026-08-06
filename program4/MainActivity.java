package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText1 = findViewById(R.id.text2);
        EditText editText2 = findViewById(R.id.text3);
        EditText editText3 = findViewById(R.id.text4);
        EditText editText4 = findViewById(R.id.text5);
        EditText editText5 = findViewById(R.id.text6);
        Button bt1 = findViewById(R.id.but1);
        sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text2 = editText1.getText().toString().trim();
                String text3 = editText2.getText().toString().trim();
                String text4 = editText3.getText().toString().trim();
                String text5 = editText4.getText().toString().trim();
                String text6 = editText5.getText().toString().trim();
                if (text2.isEmpty()) {
                    editText1.setError("Enter your name");
                    editText1.requestFocus();
                    return;
                }
                if (text3.isEmpty()) {
                    editText2.setError("Enter your phone number");
                    editText2.requestFocus();
                    return;
                }
                if (text4.isEmpty()) {
                    editText3.setError("Enter your email");
                    editText3.requestFocus();
                    return;
                }
                if (text5.length() < 6) {
                    editText4.setError("Password must be at least 6 characters");
                    editText4.requestFocus();
                    return;
                }
                if (text6.isEmpty()) {
                    editText5.setError("Confirm your password");
                    editText5.requestFocus();
                    return;
                }
                if (!text5.equals(text6)) {
                    editText5.setError("Passwords do not match");
                    editText5.requestFocus();
                    return;
                }
                editor.putString("keytext2", text2);
                editor.putString("keytext3", text3);
                editor.putString("keytext4", text4);
                editor.putString("keytext5", text5);
                editor.apply();
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("username", text2);
                intent.putExtra("phone", text3);
                intent.putExtra("email", text4);
                intent.putExtra("password", text5);
                startActivity(intent);
            }
        });
    }
}