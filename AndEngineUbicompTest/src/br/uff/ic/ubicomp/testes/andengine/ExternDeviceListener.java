package br.uff.ic.ubicomp.testes.andengine;

import java.util.Observable;
import java.util.Observer;

import android.util.Log;
import android.widget.Toast;
import br.uff.ic.ubicomp.testes.knowledge.Widget;

import com.google.gson.Gson;

public class ExternDeviceListener extends Observable implements Runnable {
	
	private SocketService ss;
	private int port;
	
	public ExternDeviceListener(Observer observer, int port) {
		
		
		addObserver(observer);
		ss = new SocketService(port);
	}

	@Override
	public void run() {
		
		while (true) {
			Log.d("Ubicomp", "Thread rodando");
			
			String received = ss.receiveStatus();
			Log.d("Ubicomp", "Msg recebida");
			Gson g = new Gson();
			Widget res = g.fromJson(received, Widget.class);
			
			notifyObservers(res);
			setChanged();
			
		}
	}
	
	

}
