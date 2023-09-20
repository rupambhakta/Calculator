package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import  java.util.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    Button btnClear,btnPersent,btnSals,btn7,btn8,btn9,btnStar,btn4,btn5,btn6,btnMainas,btn1,btn2,btn3,btnPlus,btnPlasMainas,btn0,btnDot,btnEqulTo,btnLeftPatenthasis,btnRightPatenthasis,txtDel,txtSquare;
    TextView txtCal;
    double currentValue=0;
    String currentOperator="";
    int b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCal=findViewById(R.id.txtCal);
        btnClear=findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCal.setText("");
            }
        });

        btnLeftPatenthasis=findViewById(R.id.btnLeftparnthesys);
        btnLeftPatenthasis.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"(");
            }
        });

        btnRightPatenthasis=findViewById(R.id.btnRightparnthesys);
        btnRightPatenthasis.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+")");
            }
        });

        btnPersent=findViewById(R.id.btnPersent);
        btnPersent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"%");
            }
        });
        btnSals=findViewById(R.id.btnSlas);
        btnSals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"/");
            }
        });
        btn7=findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"7");
            }
        });
        btn8=findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"8");
            }
        });
        btn9=findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"9");
            }
        });
        btnStar=findViewById(R.id.btnStar);
        btnStar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"*");
            }
        });
        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"4");
            }
        });
        btn5=findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"5");
            }
        });
        btn6=findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"6");
            }
        });
        btnMainas=findViewById(R.id.btnMainas);
        btnMainas.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String currString=txtCal.getText().toString();
                if(currString.isEmpty()){
                    Toast.makeText(MainActivity.this, "Invalid format used", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    txtCal.setText(txtCal.getText().toString() + "-");
                }
            }
        });
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"1");
            }
        });
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"2");
            }
        });
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"3");
            }
        });
        btnPlus=findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"+");
            }
        });
        btnPlasMainas=findViewById(R.id.btnPlusMainus);
        btnPlasMainas.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String curString=txtCal.getText().toString();
                if(!curString.isEmpty() ){
                    double value = Double.parseDouble(curString);
                    if (value<0){
                        return;
                    }
                    double newValue = -value;
                    txtCal.setText("( "+Double.toString(newValue));
                }
            }
        });
        btn0=findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"0");
            }
        });
        btnDot=findViewById(R.id.btnDot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+".");
            }
        });

        txtDel=findViewById(R.id.txtDel);
        txtDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currString=txtCal.getText().toString();
                if(!currString.isEmpty()){
                   String newString = currString.substring(0,currString.length()-1);
                    txtCal.setText(newString);
                }
            }
        });

        txtSquare=findViewById(R.id.txtSquare);
        txtSquare.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                txtCal.setText(txtCal.getText().toString()+"^");
            }
        });


        btnEqulTo= findViewById(R.id.btnEqalTo);

        btnEqulTo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String expression = txtCal.getText().toString();
                if(expression.isEmpty()){
                    Toast.makeText(MainActivity.this, "Invalid click", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    Expression expressionObj = new ExpressionBuilder(expression).build();
                    double result = expressionObj.evaluate();
                    txtCal.setText(Double.toString(result));
                } catch(Exception e){
                    txtCal.setText("Error!");
                }

            }
        });



    }
}