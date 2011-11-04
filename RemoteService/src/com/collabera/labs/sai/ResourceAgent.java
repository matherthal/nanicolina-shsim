package com.collabera.labs.sai;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public abstract class ResourceAgent extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();

	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();

	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);

	}

	
}