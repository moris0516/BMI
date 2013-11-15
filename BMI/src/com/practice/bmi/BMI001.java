package com.practice.bmi;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI001 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi001);
        
        Button button1 = (Button) findViewById(R.id.button1);        
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        
        button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI002.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI003.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button6.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, Addfood.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num"); 
    }        

   
}