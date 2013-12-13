package com.example.bmi_1;

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

public class BMI extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        
        //Listen for button clicks
        Button button = (Button)findViewById(R.id.buttonCalculate);
        button.setOnClickListener(calcBMI);
        
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        
        button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI.this, BMI001.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}	
		});
        
        button3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI.this, BMI002.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI.this, BMI003.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bmi, menu);
        return true;
    }

    private OnClickListener calcBMI = new OnClickListener()
    {
    	public void onClick(View v)
    	{
    		DecimalFormat nf = new DecimalFormat("0.00");
    		EditText fieldheight = (EditText)findViewById(R.id.inputHeight);
    		EditText fieldweight = (EditText)findViewById(R.id.inputWeight);
    		double height = Double.parseDouble(fieldheight.getText().toString())/100;
    		double weight = Double.parseDouble(fieldweight.getText().toString());
    		double BMI = weight / (height * height);
    		
    		TextView result = (TextView)findViewById(R.id.textResult);
    		result.setText("Your BMI is " + nf.format(BMI));
    		
    		//Give health advice
    		TextView fieldsuggest = (TextView)findViewById(R.id.textSuggest);
    		if(BMI>25){
    			fieldsuggest.setText(R.string.advice_heavy);
    		}else if(BMI<20){
    			fieldsuggest.setText(R.string.advice_light);
    		}else {
    			fieldsuggest.setText(R.string.advice_average);
    		}
    		
    	}
    };
   
}