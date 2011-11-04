package br.uff.tempo.nanicolina.resourceservice;

import android.widget.ArrayAdapter;
import br.uff.tempo.nanicolina.resources.Device;

public class ResourceListener extends Thread{
	
	ResourceAgentServiceActivity activity;
	
	SocketService server;
	
	public ResourceListener(ResourceAgentServiceActivity activity, int serverPort)
	{
		server = new SocketService(serverPort);
		this.activity = activity;
	}	
	
	public void run()
	{
		int i = 0;
		while (i!=10)
		{
			i++;
			String strDevice = server.receiveStatus();
			activity.setText(strDevice);
		}
	}

}
