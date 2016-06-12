package com.example.alarmtest;

import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		Log.v("TAG", "定时时间到，当前时间是:"+calendar.get(Calendar.MINUTE)+"分"+calendar.get(Calendar.SECOND)+"秒");
		Toast.makeText(context, "闹钟时间到", Toast.LENGTH_SHORT).show();
		//再次开启闹钟服务或者使用setRepeating（）
	//	Intent i=new Intent(context,AlarmService.class);
	//	context.startService(i);
	}

	
}
