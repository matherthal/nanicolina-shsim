package com.collabera.labs.sai;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.collabera.labs.sai.RemoteService.Task;

public class CookerAgent extends ResourceAgent {

	private Handler serviceHandler;
	private int counter;
	private Task myTask = new Task();
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(getClass().getSimpleName(),"onCreate()");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		serviceHandler.removeCallbacks(myTask);
		serviceHandler = null;
		Log.d(getClass().getSimpleName(),"onDestroy()");
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		serviceHandler = new Handler();
		serviceHandler.postDelayed(myTask, 1000L);
		Log.d(getClass().getSimpleName(), "onStart()");
	}
	
	class Task implements Runnable {
		public void run() {
			++counter;
			serviceHandler.postDelayed(this,1000L);
			Log.i(getClass().getSimpleName(), "Incrementing counter in the run method");
		}
	}
	

}
