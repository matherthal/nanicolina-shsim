package br.uff.tempo.nanicolina.resource;

import android.app.Activity;
import android.os.Bundle;

public class ResourceLayerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ResourceServer rs = new ResourceServer(10006);
        System.out.println(rs.receiveStatus());
    }
}