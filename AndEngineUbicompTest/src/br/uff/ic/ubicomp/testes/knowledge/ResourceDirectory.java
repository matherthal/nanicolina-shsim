package br.uff.ic.ubicomp.testes.knowledge;


import java.util.HashMap;
import java.util.Map;


import br.uff.ic.ubicomp.testes.andengine.R;
import br.uff.ic.ubicomp.testes.andengine.Main;



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import br.uff.ic.ubicomp.testes.base.Position;
import br.uff.ic.ubicomp.testes.base.Resource;

public class ResourceDirectory{
	
	boolean started;
	HashMap<String, IMyResourceService> resources;
	
	private RemoteServiceConnection conn = null;
	private IMyResourceService remoteService;
	
	private Main instance;
	public ResourceDirectory(Main instance)
	{
		started = false;
		this.instance = instance;
		resources = new HashMap<String, IMyResourceService>();
		
	}
	
	public void addResource(Resource resource)
	{
		remoteService = null;
		conn = null;
		updateServiceStatus();
		startService();
		updateServiceStatus();
		bindService();
		updateServiceStatus();
		try {
			while (remoteService == null)
			{}
			remoteService.createResource(resource.getName(), resource.getId(), resource.getOnOff(),
					resource.getLocalization().getX(), resource.getLocalization().getY());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d( getClass().getSimpleName(), "Not Registered..." );
		}
		updateServiceStatus();
		try {
			String resStr = remoteService.getResource();
			Log.d( getClass().getSimpleName(), "Registered..."+resStr );
			Resource res = Resource.convert(resStr);
			Log.d( getClass().getSimpleName(), "Registered..."+res.toString() );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resources.put(resource.getId(),remoteService);
		Log.d( getClass().getSimpleName(), "Adding... "+resources.size() );
	}
	
	public Resource getResource(String id)
	{
		try {
			return Resource.convert(resources.get(id).getResource());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.d( getClass().getSimpleName(), "RemoteExcption") ;
			return null;
		}
	}
	
	public void startService(){
   		if (false){
   			Log.d( getClass().getSimpleName(), "Service already started" );
   		}else{
   			
   			Intent i = new Intent();
   			i.setClassName("br.uff.ic.ubicomp.testes.knowledge", "REMOTE_SERVICE");
   			instance.startService(i);
   			started = true;
   			updateServiceStatus();
   			Log.d( getClass().getSimpleName(), "startService()" );
   		}
   		
	}
   
	public void stopService() {
  		if (!started) {
  			Log.d( getClass().getSimpleName(),"Service not yet started");
  		} else {
   			Intent i = new Intent("br.uff.ic.ubicomp.testes.knowledge.REMOTE_SERVICE");
   			//i.setClassName("br.uff.ic.ubicomp.testes.knowledge", "br.uff.ic.ubicomp.testes.knowledge.ResourceAgent");
   			instance.stopService(i);
   			started = false;
   			updateServiceStatus();
   			Log.d( getClass().getSimpleName(), "stopService()" );
  		}
	}
  
	public void bindService() {
		if(true) {
			conn = new RemoteServiceConnection();
			Intent i = new Intent("br.uff.ic.ubicomp.testes.knowledge.REMOTE_SERVICE");
			instance.bindService(i, conn, Context.BIND_AUTO_CREATE);
			updateServiceStatus();
			Log.d( getClass().getSimpleName(), "bindService()" );
		} else {
			Log.d( getClass().getSimpleName(), "Cannot bind - service already bound" );
		}
	}

	public void releaseService() {
		if(conn != null) {
			instance.unbindService(conn);
			conn = null;
			updateServiceStatus();
			Log.d( getClass().getSimpleName(), "releaseService()" );
		} else {
			//Toast.makeText(this, "Cannot unbind - service not bound", Toast.LENGTH_SHORT).show();
		}
	}
    
	/*private void invokeService() {
		if(conn == null) {
			Toast.makeText(this, "Cannot invoke - service not bound", Toast.LENGTH_SHORT).show();
		} else {
			try {
				int counter = remoteService.getCounter();
				  TextView t = (TextView)findViewById(R.id.notApplicable);
				  t.setText( "Counter value: "+Integer.toString( counter ) );
				  Log.d( getClass().getSimpleName(), "invokeService()" );
			} catch (RemoteException re) {
				Log.e( getClass().getSimpleName(), "RemoteException" );
			}
		}
   	}*/	        	
	public void updateServiceStatus() {
  	  String bindStatus = conn == null ? "unbound" : "bound";
  	  String startStatus = started ? "started" : "not started";
  	  String remoteStatus = remoteService == null ? "not instance" : "instance";
  	  String statusText;
	  statusText = "Service status: "+
								bindStatus+
								","+
								startStatus+
								remoteStatus;
      //TextView t = (TextView)findViewById(R.id.serviceStatus);
  	  //t.setText( statusText );	
    }
	public class RemoteServiceConnection implements ServiceConnection {
		  
		  public void onServiceConnected(ComponentName className, 
				IBinder boundService ) {
	        remoteService = IMyResourceService.Stub.asInterface((IBinder)boundService);
	        //TextView t = (TextView)findViewById(R.id.notApplicable);
			//t.setText( "Service Connected:"+remoteService );
	        Log.d( getClass().getSimpleName(), "onServiceConnected()" );
	      }

	      public void onServiceDisconnected(ComponentName className) {
	        remoteService = null;
			   Log.d( getClass().getSimpleName(), "onServiceDisconnected" );
	      }
	 };
	 
	 
  

}
