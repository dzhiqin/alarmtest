package com.example.alarmtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "����ʱ�䵽", Toast.LENGTH_SHORT).show();
		//�ٴο������ӷ���
	//	Intent i=new Intent(context,AlarmService.class);
	//	context.startService(i);
	}

	
}
