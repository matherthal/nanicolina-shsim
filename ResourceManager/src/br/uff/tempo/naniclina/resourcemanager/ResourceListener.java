package br.uff.tempo.naniclina.resourcemanager;

import android.widget.ArrayAdapter;
import br.uff.tempo.naniclina.resources.Device;

public class ResourceListener extends Thread{
	
	private final String RESOURCE_IP = "192.168.1.29";
	private final int RESOURCE_PORT = 10007;
	
	ResourceManagerActivity activity;
	
	SocketService server; 
	
	
	public ResourceListener(ResourceManagerActivity activity, int serverPort)
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
			if (!strDevice.equals("Registrado"))
			{
				Device device = server.getDevice(strDevice);
				activity.arraySpinnerReg.add(strDevice);
	            ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity.getRegisterListener(),
	                    android.R.layout.simple_spinner_item, activity.arraySpinnerReg);
	            activity.spinnerReg.setAdapter(adapter);
	            activity.registeredRes.add(device);
	            SocketService sender = new SocketService(RESOURCE_IP,RESOURCE_PORT);
	            sender.sendStatus("Registrado");
	            activity.setText(strDevice);
			}
			else
				activity.setText(strDevice);
		}
	}

}
