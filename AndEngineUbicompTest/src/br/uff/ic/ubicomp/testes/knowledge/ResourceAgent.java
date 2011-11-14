package br.uff.ic.ubicomp.testes.knowledge;


import br.uff.ic.ubicomp.testes.base.Resource;
import br.uff.ic.ubicomp.testes.base.Position;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


public class ResourceAgent extends EntityAgent{
	
	private Resource resource;
	private Task myTask = new Task();
	

	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(getClass().getSimpleName(), "onBind()");
		return myResourceServiceStub;
	}

	private IMyResourceService.Stub myResourceServiceStub = new IMyResourceService.Stub() {
		
		public void createResource(String name, String id, int onOff, int x, int y)
		{
			resource = new Resource(name,id,onOff, new Position(x,y));
		}
		
		public String getResource()
		{
			return resource.toString();
		}
		
	};

}
