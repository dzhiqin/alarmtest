package com.example.alarmtest;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmService extends Service{


	@Override
	public IBinder onBind(Intent intent) {
		// TODO 自动生成的方法存根
		return null;
	}

	public int onStartCommand(Intent intent,int flags,int startId){
		AlarmManager manager=(AlarmManager)getSystemService(ALARM_SERVICE);		
		Calendar calendar=Calendar.getInstance();
	    calendar.setTimeInMillis(System.currentTimeMillis());
	    //  calendar.add(Calendar.SECOND, 5);
	
	    SharedPreferences prefs=getSharedPreferences("data",MODE_PRIVATE);
	    int minute=prefs.getInt("minute", 0);
	    int hour=prefs.getInt("hour", 0);
	    Log.v("TAG", "设定的时间是："+hour+"时"+minute+"分0秒");
	    calendar.set(Calendar.HOUR_OF_DAY, hour);
	    calendar.set(Calendar.MINUTE,minute);
	    calendar.set(Calendar.SECOND, 0);
	    
	    
		Intent i=new Intent(this,AlarmReceiver.class);
		PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);
		manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
		
	/*	int timer=5*1000;
		long triggerAtTime=SystemClock.elapsedRealtime()+timer;
		Intent i=new Intent(this,AlarmReceiver.class);
		PendingIntent pi=PendingIntent.getBroadcast(this, 0, i, 0);
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);*/
		
		return super.onStartCommand(intent, flags, startId);
	}
}
