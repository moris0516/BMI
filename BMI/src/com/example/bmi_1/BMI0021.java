package com.example.bmi_1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class BMI0021 extends Activity {
	/** Called when the activity is first created. */
//	TextView json_res;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi0021);
        
        
        

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);


        
        button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI001.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI003.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button6.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI002.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button8.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI0022.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button9.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0021.this, BMI0023.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num"); 
        
        ListView list = (ListView) findViewById(R.id.myListView01);
        
        StudentAdapter adapter = new StudentAdapter(this);
        adapter.add(new Student("Äªµ«145g", 30));
        adapter.add(new Student("ªãÂÅ180g", 45));
        adapter.add(new Student("ªáµæ125g", 30));
        adapter.add(new Student("ªàµæ40g", 5));
        adapter.add(new Student("¥É¦Ì140g", 70));
        adapter.add(new Student("¶À¥Ê28g", 5));
        adapter.add(new Student("­»Û£70g", 20));
        adapter.add(new Student("¬v½µ210g", 60));
 
        list.setAdapter(adapter);
    }
 
    class StudentAdapter extends ArrayAdapter<Student> {
        LayoutInflater inflator;
 
        public StudentAdapter(Context context) {
            super(context, 0);
            inflator = LayoutInflater.from(context);
        }
 
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflator.inflate(
                        android.R.layout.simple_list_item_2, parent, false);
            }
 
            TextView text1 = (TextView) convertView
                    .findViewById(android.R.id.text1);
            TextView text2 = (TextView) convertView
                    .findViewById(android.R.id.text2);
 
            Student s = this.getItem(position);
 
            text1.setText(s.name);
            text2.setText("" + s.age);
 
            return convertView;
        }
    }
 
    class Student {
        String name;
        int age;
 
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    
        }

        
}

   
