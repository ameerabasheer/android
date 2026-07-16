package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float mvalue1,mvalue2;
    boolean add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText result=findViewById(R.id.editid1);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        Button badd=findViewById(R.id.button4);
        Button button5=findViewById(R.id.button5);
        Button button6=findViewById(R.id.button6);
        Button button7=findViewById(R.id.button7);
        Button bsub=findViewById(R.id.button8);
        Button button9=findViewById(R.id.button9);
        Button button10=findViewById(R.id.button10);
        Button button11=findViewById(R.id.button11);
        Button bdiv=findViewById(R.id.button12);
        Button button13=findViewById(R.id.button13);
        Button button14=findViewById(R.id.button14);
        Button button15=findViewById(R.id.button15);
        Button bmul=findViewById(R.id.button16);
        Button bequal=findViewById(R.id.button17);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"1");
                    }
                }
        );
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"2");
                    }
                }
        );
        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"3");
                    }
                }
        );

        button5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"4");
                    }
                }
        );
        button6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"5");
                    }
                }
        );
        button7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"6");
                    }
                }
        );

        button9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"7");
                    }
                }
        );
        button10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"8");
                    }
                }
        );
        button11.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"9");
                    }
                }
        );
        button13.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+".");
                    }
                }
        );
        button14.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText(result.getText()+"0");
                    }
                }
        );
        button15.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        result.setText("");
                    }
                }
        );
        badd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(result==null){
                            result.setText(" ");
                        }
                        else{
                            mvalue1=Float.parseFloat((result.getText()+" "));
                            add=true;
                            result.setText(null);
                        }
                    }
                }
        );
        bsub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(result==null){
                            result.setText(" ");
                        }
                        else{
                            mvalue1=Float.parseFloat((result.getText()+" "));
                            sub=true;
                            result.setText(null);
                        }
                    }
                }
        );
        bmul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(result==null){
                            result.setText(" ");
                        }
                        else{
                            mvalue1=Float.parseFloat((result.getText()+" "));
                            mul=true;
                            result.setText(null);
                        }
                    }
                }
        );
        bdiv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(result==null){
                            result.setText(" ");
                        }
                        else{
                            mvalue1=Float.parseFloat((result.getText()+" "));
                            div=true;
                            result.setText(null);
                        }
                    }
                }
        );
        bequal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mvalue2=Float.parseFloat(result.getText().toString());
                        if(add)
                        {
                            result.setText(String.valueOf(mvalue1+mvalue2) );
                            add=false;
                        }
                        if(sub)
                        {
                            result.setText (String.valueOf(mvalue1-mvalue2));
                            sub=false;
                        }
                        if(mul)
                        {
                            result.setText(String.valueOf(mvalue1*mvalue2));
                            mul=false;
                        }
                        if(div)
                        {
                            result.setText(String.valueOf(mvalue1/mvalue2));
                            div=false;
                        }
                    }
                }
        );

    }
}