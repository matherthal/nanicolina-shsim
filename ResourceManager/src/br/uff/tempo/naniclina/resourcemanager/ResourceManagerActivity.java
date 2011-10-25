package br.uff.tempo.naniclina.resourcemanager;

import java.util.ArrayList;



import br.uff.tempo.naniclina.resources.Device;
import br.uff.tempo.naniclina.resources.Local;
import br.uff.tempo.naniclina.resources.DangerDevice;
import br.uff.tempo.naniclina.resources.VisualDevice;
import br.uff.tempo.naniclina.resources.PresenceSensor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ResourceManagerActivity extends Activity {
    /** Called when the activity is first created. */
    
	EditText mEditX;
	EditText mEditY;
	
	Spinner spinner;
	Spinner spinnerReg;
	
	ArrayList<String> arraySpinnerReg;
	
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
        spinnerReg = (Spinner) findViewById(R.id.spinner2);
        
        disponibleRes = new ArrayList<Device>();
    	registeredRes = new ArrayList<Device>();
        
        arraySpinner=new String[5];
        arraySpinnerReg=new ArrayList<String>();
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
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerReg);
        spinnerReg.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(mRegisterListener);
        button = (Button) findViewById(R.id.button3);
        mEditX = (EditText) findViewById(R.id.editText1);
        mEditY = (EditText) findViewById(R.id.editText2);
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/
    }
    
    private OnClickListener mRegisterListener = new OnClickListener() {
        public void onClick(View v) {
            String resName = (String) spinner.getSelectedItem();
            arraySpinnerReg.add(resName);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ResourceManagerActivity.this,
                    android.R.layout.simple_spinner_item, arraySpinnerReg);
            spinnerReg.setAdapter(adapter);
            Device dev = disponibleRes.get(spinner.getSelectedItemPosition());
            dev.setLocalization(new Local(Integer.valueOf(mEditX.getText().toString()),Integer.valueOf(mEditY.getText().toString())));
            registeredRes.add(dev);
        }
    };
}