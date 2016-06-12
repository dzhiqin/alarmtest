package com.example.alarmtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "闹钟时间到", Toast.LENGTH_SHORT).show();
		//再次开启闹钟服务
	//	Intent i=new Intent(context,AlarmService.class);
	//	context.startService(i);
	}

	
}
