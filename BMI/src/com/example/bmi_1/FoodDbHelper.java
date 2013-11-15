package com.example.bmi_1;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FoodDbHelper extends SQLiteOpenHelper {

	public String sCreateTableCommand;

	public FoodDbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub

		sCreateTableCommand="";
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		if (sCreateTableCommand.isEmpty())
			return;
		
		db.execSQL(sCreateTableCommand);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
		// TODO Auto-generated method stub

	}

}