package br.uff.tempo.nanicolina.csr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.uff.tempo.nanicolina.devices.Device;
import br.uff.tempo.nanicolina.devices.Lamp;
import br.uff.tempo.nanicolina.devices.Local;
import br.uff.tempo.nanicolina.devices.VisualDevice;

import com.google.gson.Gson;

public class CSRMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		CSRClient cc = new CSRClient("localhost",10006);
		
		cc.sendStatus("OK!");
		System.out.println("Feito!");
		*/
		ApplicationManager appManag = new ApplicationManager();
		appManag.initDevices();
		Scanner input = new Scanner(System.in);
		String regId= "";
		System.out.println(appManag);
		while (!regId.equals("0"))
		{
			System.out.println("Digite aqui para registrar um dispositivo: (digite 0 pra cancelar)");
			regId= input.nextLine();
			if (!regId.equals("0"))
			{
				appManag.registerDevice(regId);
				System.out.println("Digite aqui as configurações do dispositivo "+ regId+":");
				appManag.setAttribute(regId);
			}
		}
		regId= "";
		while (!regId.equals("0"))
			{
				System.out.println("Digite aqui o dispositivo o qual deseja consultar: (0 para encerrar)");
				regId= input.nextLine();
				if (!regId.equals("0"))
				{
					Gson gson = new Gson();
					String name = appManag.getDeviceName(regId);
					if (name.equals("Lamp"))
					{
						Lamp lamp= gson.fromJson(appManag.getDevice(regId), Lamp.class);
						System.out.println(lamp);
					}
					else
						if (name.equals("Stove")||name.equals("Refrigerator"))
						{
							Device dev = gson.fromJson(appManag.getDevice(regId), Device.class);
							System.out.println(dev);
						}
						else
							if (name.equals("Television")||name.equals("Tablet"))
							{
								VisualDevice vdev = gson.fromJson(appManag.getDevice(regId), VisualDevice.class);
								System.out.println(vdev);
							}
					
				}
			}
		
	}

}
