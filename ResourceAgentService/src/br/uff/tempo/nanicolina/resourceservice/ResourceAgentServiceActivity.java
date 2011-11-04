package br.uff.tempo.nanicolina.resourceservice;

import java.util.ArrayList;

import br.uff.tempo.nanicolina.resources.DangerDevice;
import br.uff.tempo.nanicolina.resources.Device;
import br.uff.tempo.nanicolina.resources.Local;
import br.uff.tempo.nanicolina.resources.PresenceSensor;
import br.uff.tempo.nanicolina.resources.VisualDevice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ResourceAgentServiceActivity extends Activity {
    /** Called when the activity is first created. */
	
	ResourceListener resource;
	
	private final String MANAGER_IP = "192.168.27";
	private final int MANAGER_PORT = 10006;
	SocketService server;
	
	
	EditText mEditX;
	EditText mEditY;
	EditText mEditDevice;
	
	Spinner spinner;


	
	ArrayList<Device> disponibleRes;
	ArrayList<Device> registeredRes;

	Device stove;
	DangerDevice fireDetector;
	VisualDevice television;
	VisualDevice tablet;
	PresenceSensor psensor;
	String[] arraySpinner;

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        spinner = (Spinner) findViewById(R.id.spinner1);
        
        disponibleRes = new ArrayList<Device>();
    	registeredRes = new ArrayList<Device>();
        
        arraySpinner=new String[5];
        arraySpinner[0]="Fogão 1";
        stove = new Device("Stove",arraySpinner[0],0, new Local(0,0) );
        disponibleRes.add(stove);
        arraySpinner[1]="Detector de Incêndio 1";
        fireDetector = new DangerDevice ("fireDetector", arraySpinner[1], 0, new Local(0,0)); 
        disponibleRes.add(fireDetector);
        arraySpinner[2]="Televisão 1";
        television = new VisualDevice("television", arraySpinner[2], 0, new Local(0,0));
        disponibleRes.add(television);
        arraySpinner[3]="Tablet 1";
        tablet = new VisualDevice("tablet", arraySpinner[3], 0, new Local(0,0));
        disponibleRes.add(tablet);
        arraySpinner[4]="Sensor de Presença";
        psensor = new PresenceSensor("presenceSensor", arraySpinner[4], 0, new Local(0,0));
        disponibleRes.add(psensor);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
        
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(mRegisterListener);
        mEditX = (EditText) findViewById(R.id.editText1);
        mEditY = (EditText) findViewById(R.id.editText2);
        mEditDevice = (EditText) findViewById(R.id.editText3);
        resource = new ResourceListener(this,10007); 
        //resource.start();
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/
        
        
	}
    

    private OnClickListener mRegisterListener = new OnClickListener() {
        public void onClick(View v) {
        	server = new SocketService(MANAGER_IP,MANAGER_PORT);
        	Device dev = disponibleRes.get(spinner.getSelectedItemPosition());
            dev.setLocalization(new Local(Integer.valueOf(mEditX.getText().toString()),Integer.valueOf(mEditY.getText().toString())));
            server.sendStatus(dev.toString());
        }
    };
    
    
    
    public Context getRegisterListener()
    {
    	return (Context) mRegisterListener;
    }

	public void setText(String strDevice) {
		// TODO Auto-generated method stub
		mEditDevice.setText(strDevice);
	}
}