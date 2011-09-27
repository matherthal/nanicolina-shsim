package br.uff.tempo.nanicolina.csr;

import br.uff.tempo.nanicolina.devices.Device;
import br.uff.tempo.nanicolina.devices.Lamp;
import br.uff.tempo.nanicolina.devices.Local;
import br.uff.tempo.nanicolina.devices.VisualDevice;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;


public class ApplicationManager {

	ArrayList<String> nonRegDevice;//dispositivos não registrados
	ArrayList<String> regDevice;//dispositivos registrados na casa
	Gson gson = new Gson();
	
	public ApplicationManager()
	{
		nonRegDevice = new ArrayList<String>();
		regDevice = new ArrayList<String>();
	}
	
	public void initDevices() {
		//simula consulta a banco de dados;
		nonRegDevice.add(gson.toJson(new Device("Stove","f01", 0, new Local(0, 0))));
		nonRegDevice.add(gson.toJson(new Lamp("Lamp","l01",0, new Local(0,0),0.0)));
		nonRegDevice.add(gson.toJson(new VisualDevice("Television","t01", 0,new Local(0,0))));
	}
	
	public void registerDevice(String id) {
		int j = 0;
		while (nonRegDevice.get(0).charAt(j) !=':')
			j++;
		j++;
		while (nonRegDevice.get(0).charAt(j) !=':')
			j++;
		int i0= j+2;
		
		int i;
		for (i = 0; i<nonRegDevice.size() && !nonRegDevice.get(i).substring(i0, i0+id.length()).equals(id); i++)
		{}
		if (i!=nonRegDevice.size())
			regDevice.add(nonRegDevice.get(i));
		else
			System.out.println("Dispositivo não encontrado");
	}
	
	public String getDevice(String id)
	{
		int j = 0;
		while (nonRegDevice.get(0).charAt(j) !=':')
			j++;
		j++;
		while (nonRegDevice.get(0).charAt(j) !=':')
			j++;
		int i0= j+2;
		
		int i;
		for (i = 0; i<nonRegDevice.size() && !nonRegDevice.get(i).substring(i0, i0+id.length()).equals(id); i++)
		{}
		if (i!=nonRegDevice.size())
			return nonRegDevice.get(i);
		else
			{
				System.out.println("Dispositivo não registrado");
				return null;
			}
	}
	
	private void setDevice(String id, String json)
	{
		int j = 0;
		while (regDevice.get(0).charAt(j) !=':')
			j++;
		j++;
		while (regDevice.get(0).charAt(j) !=':')
			j++;
		int i0= j+2;
		
		int i;
		for (i = 0; i<regDevice.size() && !regDevice.get(i).substring(i0, i0+id.length()).equals(id); i++)
		{}
		if (i!=regDevice.size())
			regDevice.set(i, json);
		else
			{
				System.out.println("Dispositivo não registrado");
			}
	}
	
	public String toString(){
		String str = "nonRegDevice: \n";
		int i;
		for (i=0; i<nonRegDevice.size();i++)
			str += nonRegDevice.get(i)+"\n";
		str += "regDevice: \n";
		for (; i<regDevice.size();i++)
			str += regDevice.get(i)+"\n";
		return str;
		
	}
	
	public String getDeviceName(String regId)
	{
		String json = getDevice(regId);
		int j = 0;
		while (nonRegDevice.get(0).charAt(j) !=':')
			j++;
		j++;
		int i0 = j+1;
		while (nonRegDevice.get(0).charAt(j) !=',')
			j++;
		return json.substring(i0,j-1);
	}

	
	public void setAttribute(String regId) {
		// TODO Auto-generated method stub
		if (getDeviceName(regId).equals("Lamp"))
		{
			Lamp lamp= gson.fromJson(getDevice(regId), Lamp.class);
			System.out.println("Digite sua localização: (informação da interface)");
			Scanner input = new Scanner (System.in);
			lamp.setLocalization(new Local(input.nextInt(),input.nextInt()));
			setDevice(regId, gson.toJson(lamp));
		}
		else
			if (getDeviceName(regId).equals("Stove")||getDeviceName(regId).equals("Refrigerator"))
			{
				Device dev = gson.fromJson(getDevice(regId), Device.class);
				System.out.println("Digite sua localização: (informação da interface)");
				Scanner input = new Scanner (System.in);
				dev.setLocalization(new Local(input.nextInt(),input.nextInt()));
				setDevice(regId, gson.toJson(dev));
			}
			else
				if (getDeviceName(regId).equals("Television")||getDeviceName(regId).equals("Tablet"))
				{
					VisualDevice vdev = gson.fromJson(getDevice(regId), VisualDevice.class);
					System.out.println("Digite sua localização: (informação da interface)");
					Scanner input = new Scanner (System.in);
					vdev.setLocalization(new Local(input.nextInt(),input.nextInt()));
					setDevice(regId, gson.toJson(vdev));
				}
	}

				
		


}
