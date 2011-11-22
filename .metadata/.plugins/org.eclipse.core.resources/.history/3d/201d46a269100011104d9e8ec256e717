package br.uff.ic.ubicomp.testes.knowledge;


import br.uff.ic.ubicomp.testes.base.Resource;
import br.uff.ic.ubicomp.testes.base.Position;
import br.uff.ic.ubicomp.testes.knowledge.EntityAgent.Task;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


public class ResourceAgent extends Service{
	
	private Resource resource;
	private Task myTask = new Task();
	

	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(getClass().getSimpleName(), "onBind()");
		return new ResourceImpl();
	}

	private class ResourceImpl extends IMyResourceService.Stub {
		
		
		public void createResource(String name, String id, int onOff, float x, float y)
		{
			resource = new Resource(name,id,onOff, new Position(x,y));
		}
		
		public String getResource()
		{
			return resource.toString();
		}
		
	};
	
	private Handler serviceHandler;
	

	
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
