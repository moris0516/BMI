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


public class BMI0023 extends Activity {
	/** Called when the activity is first created. */
//	TextView json_res;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi0023);
        
        
        

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);


        
        button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI001.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI003.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button6.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI002.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button7.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI0021.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button8.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI0023.this, BMI0022.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num"); 
        
        ListView list = (ListView) findViewById(R.id.myListView01);
        
        StudentAdapter adapter = new StudentAdapter(this);
        adapter.add(new Student("全蛋1個", 80));
        adapter.add(new Student("皮蛋1個", 73));
        adapter.add(new Student("鹹蛋1個", 73));
        adapter.add(new Student("油煎1個", 85));
        adapter.add(new Student("水煮1個", 80));
        adapter.add(new Student("炒蛋1個", 95));
        adapter.add(new Student("荷包蛋1個", 80));
        adapter.add(new Student("鵪鶉蛋5粒", 73));
 
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

   
