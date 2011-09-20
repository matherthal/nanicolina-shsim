package br.uff.tempo.nanicolina.device;

import android.app.Activity;
import android.os.Bundle;

public class DeviceNanicolinaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DeviceServer ds = new DeviceServer(10006);
        System.out.println(ds.receiveStatus());
    }
}