package com.example.bmi_1;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI001 extends Activity {


	private static final String DB_FILE = "foods.db",
								DB_TABLE = "foods";
	private SQLiteDatabase mFriDbRW;
	
	private EditText mEdtName,
	 mEdtCal,
	 mEdtAddr,
	 mEdtList;
	
	private Button mBtnAdd,
	mBtnQuery,
	mBtnList;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi001);
        
        setupViewComponent();

        // 建立自訂的 FriendDbHelper 物件
        FoodDbHelper friDbHp = new FoodDbHelper(
        		getApplicationContext(), DB_FILE,
        		null, 1);
        
        // 設定建立 table 的指令
        friDbHp.sCreateTableCommand = "CREATE TABLE " + DB_TABLE + "(" +
        							"_id INTEGER PRIMARY KEY," +
        							"name TEXT NOT NULL," +
        							"sex TEXT," +
        							"address TEXT);";

        // 取得上面指定的檔名資料庫，如果該檔名不存在就會自動建立一個資料庫檔案
        mFriDbRW = friDbHp.getWritableDatabase();
        
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
				finish();
			}
		});
        
        button3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI002.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI003.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI001.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num"); 
    }        

    private void setupViewComponent() {
    	mEdtName = (EditText)findViewById(R.id.edtName);
		mEdtCal = (EditText)findViewById(R.id.edtCal);
		mEdtAddr = (EditText)findViewById(R.id.edtAddr);
		mEdtList = (EditText)findViewById(R.id.edtList);

		mBtnAdd = (Button)findViewById(R.id.btnAdd);
		mBtnQuery = (Button)findViewById(R.id.btnQuery);
		mBtnList = (Button)findViewById(R.id.btnList);

		mBtnAdd.setOnClickListener(onClickBtnAdd);
		mBtnQuery.setOnClickListener(onClickBtnQuery);
		mBtnList.setOnClickListener(onClickBtnList);
    }

    private Button.OnClickListener onClickBtnAdd = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	        
	        ContentValues newRow = new ContentValues();
	        newRow.put("name", mEdtName.getText().toString());
	        newRow.put("sex", mEdtCal.getText().toString());
	        newRow.put("address", mEdtAddr.getText().toString());
	        mFriDbRW.insert(DB_TABLE, null, newRow);
		}
    };

    private Button.OnClickListener onClickBtnQuery = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Cursor c = null;
			
			if (mEdtName.getText().toString().isEmpty() == false) {
				c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						"name=" + "\"" + mEdtName.getText().toString() + "\"",
						null, null, null, null, null);
			}
			else if (mEdtCal.getText().toString().isEmpty() == false) {
				c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						"sex=" + "\"" + mEdtCal.getText().toString() + "\"",
						null, null, null, null, null);
			}
			else if (mEdtAddr.getText().toString().isEmpty() == false) {
				c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						"address=" + "\"" + mEdtAddr.getText().toString() + "\"",
						null, null, null, null, null);
			}
			
			if (c == null)
				return;

			if (c.getCount() == 0) {
				mEdtList.setText("");
				Toast.makeText(BMI001.this, "沒有這筆資料", Toast.LENGTH_LONG)
					.show();
			}
			else {
				c.moveToFirst();
				mEdtList.setText(c.getString(0) + c.getString(1)  + c.getString(2));
				
				while (c.moveToNext())
					mEdtList.append("\n" + c.getString(0) + c.getString(1)  + c.getString(2));
			}
		}
    };

    private Button.OnClickListener onClickBtnList = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor c = mFriDbRW.query(true, DB_TABLE, new String[]{"name", "sex", "address"},
						null, null, null, null, null, null);
			
			if (c == null)
				return;

			if (c.getCount() == 0) {
				mEdtList.setText("");
				Toast.makeText(BMI001.this, "沒有資料", Toast.LENGTH_LONG)
					.show();
			}
			else {
				c.moveToFirst();
				mEdtList.setText(c.getString(0) + c.getString(1)  + c.getString(2));
				
				while (c.moveToNext())
					mEdtList.append("\n" + c.getString(0) + c.getString(1)  + c.getString(2));
			}
		}
    };
    
    
    
    
    
   
}