package com.practice.bmi;

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

public class Addfood extends Activity {
	
	private static final String DB_FILE = "foods.db",
								DB_TABLE = "foods";
	private SQLiteDatabase mFriDbRW;
	
	private EditText mEdtName,
	 mEdtSex,
	 mEdtAddr,
	 mEdtList;
	
	private Button mBtnAdd,
	mBtnQuery,
	mBtnList;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfood);
                        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num"); 
        
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
        
    }     
    
    private void setupViewComponent() {
    	mEdtName = (EditText)findViewById(R.id.edtName);
		mEdtSex = (EditText)findViewById(R.id.edtSex);
		mEdtAddr = (EditText)findViewById(R.id.edtAddr);
		mEdtList = (EditText)findViewById(R.id.edtList);

		mBtnAdd = (Button)findViewById(R.id.btnAdd);
		mBtnQuery = (Button)findViewById(R.id.btnQuery);
		mBtnList = (Button)findViewById(R.id.btnList);

		mBtnAdd.setOnClickListener(onClickBtnAdd);
		mBtnList.setOnClickListener(onClickBtnList);
    }
    
    private Button.OnClickListener onClickBtnAdd = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
	        
	        ContentValues newRow = new ContentValues();
	        newRow.put("name", mEdtName.getText().toString());
	        newRow.put("sex", mEdtSex.getText().toString());
	        newRow.put("address", mEdtAddr.getText().toString());
	        mFriDbRW.insert(DB_TABLE, null, newRow);
		}
    };
    
    
    
    private Button.OnClickListener onClickBtnList = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Cursor c = mFriDbRW.query(true, DB_TABLE, new String[]{"address", "sex", "name"},
						null, null, null, null, null, null);
			
			if (c == null)
				return;

			if (c.getCount() == 0) {
				mEdtList.setText("");
				Toast.makeText(Addfood.this, "沒有資料", Toast.LENGTH_LONG)
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