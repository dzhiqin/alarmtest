package com.example.alarmtest;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button setAlarmBtn;
	private Button cancelAlarmBtn;
	private Calendar myCalendar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setAlarmBtn=(Button)findViewById(R.id.alarm_btn);
		cancelAlarmBtn=(Button)findViewById(R.id.cancel_btn);
	
		setAlarmBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Toast.makeText(MainActivity.this, "设定闹钟", Toast.LENGTH_SHORT).show();
				myCalendar=Calendar.getInstance();
				//把myCalendar 的时间设定为当前系统时间
				myCalendar.setTimeInMillis(System.currentTimeMillis());
				int hour=myCalendar.get(Calendar.HOUR_OF_DAY);
				int minute=myCalendar.get(Calendar.MINUTE);
				new TimePickerDialog(MainActivity.this,new OnTimeSetListener(){

					@Override
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						myCalendar.setTimeInMillis(System.currentTimeMillis());
						myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
						myCalendar.set(Calendar.MINUTE, minute);
						myCalendar.set(Calendar.SECOND, 0);
						myCalendar.set(Calendar.MILLISECOND, 0);		
						Log.v("TAG", "Calendar="+myCalendar.toString());	
						//把时间保存在Sharedpreferences
						SharedPreferences prefs=getSharedPreferences("data",MODE_PRIVATE);
						SharedPreferences.Editor editor=prefs.edit();
						
						editor.putInt("hour", hourOfDay);
						editor.putInt("minute", minute);
						editor.commit();
					
						
						//可以定义类AlarmService，实现闹钟设置
						//也可以在本MainActivity里实现闹钟设置
						Intent intent=new Intent(MainActivity.this,AlarmService.class);
						startService(intent);		
					}
					
				},hour,minute,true).show();
				
			}
		});
		
		cancelAlarmBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(MainActivity.this,AlarmReceiver.class);
				PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this, 0, i, 0);
				AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
				alarm.cancel(pi);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
