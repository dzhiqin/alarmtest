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
		Log.v("TAG", "��ʱʱ�䵽����ǰʱ����:"+calendar.get(Calendar.MINUTE)+"��"+calendar.get(Calendar.SECOND)+"��");
		Toast.makeText(context, "����ʱ�䵽", Toast.LENGTH_SHORT).show();
		//�ٴο������ӷ������ʹ��setRepeating����
	//	Intent i=new Intent(context,AlarmService.class);
	//	context.startService(i);
	}

	
}
