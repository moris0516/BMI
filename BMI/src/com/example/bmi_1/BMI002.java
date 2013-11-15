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
import android.widget.ImageButton;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BMI002 extends Activity {
	/** Called when the activity is first created. */
//	TextView json_res;
	EditText facebookid;
	ImageButton fb_button[]=new ImageButton[20];
	
	private SQLiteDatabase mSQLiteDatabase = null;
	private static final String DATABASE_NAME = "food_kcal.db";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi002);
        Initialization();
        

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);


        
        button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI002.this, BMI.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI002.this, BMI001.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI002.this, BMI003.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI002.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num"); 
        
        

        
    }

	private void Initialization() {
		// TODO Auto-generated method stub


 	 	mSQLiteDatabase = this.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);		
       	String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS detail(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, json_string TEXT ,picture_string TEXT)";
        mSQLiteDatabase.execSQL(CREATE_TABLE);
	}        

   
}