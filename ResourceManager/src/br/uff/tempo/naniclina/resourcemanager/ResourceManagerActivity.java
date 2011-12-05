package br.uff.tempo.naniclina.resourcemanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.uff.tempo.naniclina.knowledge.Bed;
import br.uff.tempo.naniclina.knowledge.Cooker;
import br.uff.tempo.naniclina.knowledge.Position;
import br.uff.tempo.naniclina.knowledge.Refrigerator;
import br.uff.tempo.naniclina.knowledge.TV;
import br.uff.tempo.naniclina.knowledge.Widget;

import com.google.gson.Gson;


public class ResourceManagerActivity extends Activity {
    /** Called when the activity is first created. */
	
	ResourceListener resource;
	
	EditText mEditX;
	EditText mEditY;
	EditText mEditDevice;
	
	Spinner spinner;
	Spinner spinnerReg;
	
	ArrayList<String> arraySpinnerReg;
	
	ArrayList<Widget> disponibleRes;
	ArrayList<Widget> registeredRes;
	
	SocketService socket;

	Cooker cooker;
	Bed bed;
	TV television;
	Refrigerator refrigerator;
	String[] arraySpinner;

	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        spinner = (Spinner) findViewById(R.id.spinner1);
        spinnerReg = (Spinner) findViewById(R.id.spinner2);
        
        disponibleRes = new ArrayList<Widget>();
    	registeredRes = new ArrayList<Widget>();
        
        arraySpinner=new String[4];
        arraySpinnerReg=new ArrayList<String>();
        arraySpinner[0]="cooker1";
        cooker = new Cooker(arraySpinner[0],"localhost", new Position(0,0));
        disponibleRes.add(cooker);
        arraySpinner[1]="bed1";
        bed = new Bed(arraySpinner[1], "localhost", new Position(0,0)); 
        disponibleRes.add(bed);
        arraySpinner[2]="tv1";
        television = new TV(arraySpinner[2], "localhost", new Position(0,0));
        disponibleRes.add(television);
        arraySpinner[3]="refrigerator1";
        refrigerator = new Refrigerator(arraySpinner[3], "localhost", new Position(0,0));
        disponibleRes.add(refrigerator);
                
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnerReg);
        spinnerReg.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(mRegisterListener);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(mSearchResource);
        mEditX = (EditText) findViewById(R.id.editText1);
        mEditY = (EditText) findViewById(R.id.editText2);
        mEditDevice = (EditText) findViewById(R.id.editText3);
        //resource.start();
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
            Widget dev = disponibleRes.get(spinner.getSelectedItemPosition());
            dev.setPosition(new Position(Float.valueOf(mEditX.getText().toString()),Float.valueOf(mEditY.getText().toString())));
            registeredRes.add(dev);
            socket = new SocketService(mEditDevice.getText().toString(),8085);
            Toast.makeText(ResourceManagerActivity.this, "Mensagem enviada", Toast.LENGTH_LONG).show();
            socket.sendStatus((new Gson()).toJson(dev));
        }
    };
    
    private OnClickListener mSearchResource = new OnClickListener() {
        public void onClick(View v) {
        	 String resName = (String) spinnerReg.getSelectedItem();
        	 setText(searchDevice(resName).toString());
        }
    };
    
    private Widget searchDevice(String id)
    {
    	int i = 0;
    	for (; i< registeredRes.size() && !id.equals(registeredRes.get(i).getURN()); i++)
    	{}
    	return registeredRes.get(i);
    }
    
    public Context getRegisterListener()
    {
    	return (Context) mRegisterListener;
    }

	public void setText(String strDevice) {
		// TODO Auto-generated method stub
		mEditDevice.setText(strDevice);
	}
}