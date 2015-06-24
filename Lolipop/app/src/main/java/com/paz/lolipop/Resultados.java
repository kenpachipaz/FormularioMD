package com.paz.lolipop;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Resultados extends Activity {
    TextView tvnombre, tvedad, tvsexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        tvnombre= (TextView) findViewById(R.id.textView3);
        tvedad= (TextView) findViewById(R.id.textView4);
        tvsexo= (TextView) findViewById(R.id.textView5);

        Bundle bolsa= getIntent().getExtras();

        tvnombre.setText("Nombre: "+bolsa.getString("NOMBRE"));
        tvedad.setText(bolsa.getString("FECHA"));
        tvsexo.setText("Sexo: " + bolsa.getString("SEXO"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
