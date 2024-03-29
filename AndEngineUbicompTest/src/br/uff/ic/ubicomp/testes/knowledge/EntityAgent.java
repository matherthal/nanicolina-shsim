package br.uff.ic.ubicomp.testes.knowledge;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public abstract class EntityAgent extends Service{
	
	private Handler serviceHandler;
	private Task myTask = new Task();
	

	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(getClass().getSimpleName(), "onBind()");
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
			serviceHandler.postDelayed(this,1000L);
			Log.i(getClass().getSimpleName(), "Incrementing counter in the run method");
		}
	}

}
