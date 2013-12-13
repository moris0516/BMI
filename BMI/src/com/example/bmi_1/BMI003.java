package com.example.bmi_1;

import java.net.Proxy.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BMI003 extends Activity {

	private Timer timer = new Timer();  
    private TimerTask task;  
    private Handler handler;  
    private String title = "熱量攝取";  
    private XYSeries series;  
    private XYMultipleSeriesDataset mDataset;  
    private GraphicalView chart;  
    private XYMultipleSeriesRenderer renderer;  
    private Context context;  
    private int addX = -1, addY;  
    
    int[] xv = new int[100];  
    int[] yv = new int[100]; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi003);
        
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        
        

        
        button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI003.this, BMI.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});       
        
        button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI003.this, BMI001.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
        button3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI003.this, BMI002.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        
        button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				Intent intent = new Intent();
				intent.setClass(BMI003.this, BMI004.class);
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});
        
        Bundle bundle = this.getIntent().getExtras();
        int guess = bundle.getInt("Guess_Num") ;
        

        
 
        context = getApplicationContext();  
        
        //这里获得main界面上的布局，下面会把图表画在这个布局里面  
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout1);  
          
        //这个类用来放置曲线上的所有点，是一个点的集合，根据这些点画出曲线  
        series = new XYSeries(title);  
          
        //创建一个数据集的实例，这个数据集将被用来创建图表  
        mDataset = new XYMultipleSeriesDataset();  
          
        //将点集添加到这个数据集中  
        mDataset.addSeries(series);  
          
        //以下都是曲线的样式和属性等等的设置，renderer相当于一个用来给图表做渲染的句柄  
        int color = Color.BLUE;  
        PointStyle style = PointStyle.CIRCLE;  
        renderer = buildRenderer(color, style, true);  
          
        //设置好图表的样式   
        setChartSettings(renderer, 0, 2000, Color.BLACK);
        double[] xAxisCoord=new double[]{1,2,3,4,5,6,7};
        double[] yAxisCoord=new double[]{1450,1320,1580,1150,1380,1510,1270};
        String[] xAxisLabel=new String[]{"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        series.clear();
        for (int i = 0; i < xAxisLabel.length; i++) {
        series.add(xAxisCoord[i], yAxisCoord[i]);
        renderer.addXTextLabel(xAxisCoord[i], xAxisLabel[i]);
        }
        
        //生成图表  
        chart = ChartFactory.getLineChartView(context, mDataset, renderer);  
          
        //将图表添加到布局中去  
        layout.addView(chart);  
          
        //这里的Handler实例将配合下面的Timer实例，完成定时更新图表的功能  
        handler = new Handler() {  
            @Override  
            public void handleMessage(Message msg) {  
                //刷新图表  
                super.handleMessage(msg);  
            }  
        };  
          
        task = new TimerTask() {  
            @Override  
            public void run() {  
                Message message = new Message();  
                message.what = 1;  
                handler.sendMessage(message);  
            }  
        };  
          
        timer.schedule(task, 500, 500);  
          
    }  
      
    @Override  
    public void onDestroy() {  
        //当结束程序时关掉Timer  
        timer.cancel();  
        super.onDestroy();  
    }  
      
    protected XYMultipleSeriesRenderer buildRenderer(int color, PointStyle style, boolean fill) {  
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();  
          
        //设置图表中曲线本身的样式，包括颜色、点的大小以及线的粗细等  
        XYSeriesRenderer r = new XYSeriesRenderer();  
        r.setColor(color);  
        r.setPointStyle(style);  
        r.setFillPoints(fill);  
        r.setLineWidth(3);  
        renderer.addSeriesRenderer(r);  
          
        return renderer;  
    }  
      
    protected void setChartSettings(XYMultipleSeriesRenderer renderer, double yMin, double yMax, int axesColor) {
        renderer.setChartTitle(title); // 折線圖名稱
        renderer.setChartTitleTextSize(24); // 折線圖名稱字形大小
        renderer.setXLabelsColor(Color.BLACK); // X軸線顏色
        renderer.setYAxisMin(yMin); // Y軸顯示最小值
        renderer.setYAxisMax(yMax); // Y軸顯示最大值
        renderer.setAxesColor(axesColor); // 設定坐標軸顏色
        renderer.setYLabelsColor(0, Color.BLACK); // Y軸線顏色
        renderer.setLabelsColor(Color.BLACK); // 設定標籤顏色
        renderer.setMarginsColor(Color.WHITE); // 設定背景顏色
        renderer.setShowGrid(true); // 設定格線
    
      
    }        

   
}