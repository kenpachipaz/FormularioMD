package com.paz.lolipop;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity {
    Button btnFecha, btnOk;
    EditText ednombre;
    DatePicker fecha;
    private int year, mes, dia;
    TextView tvFecha;
    RadioButton rbtnM, rbtnF;
    static final int DATE_DIALOG_ID = 999;
    String sexo="";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();

        tvFecha= (TextView) findViewById(R.id.tvFecha);
        btnFecha= (Button) findViewById(R.id.button);
        btnOk= (Button) findViewById(R.id.button2);
        ednombre= (EditText) findViewById(R.id.editText);
        rbtnM= (RadioButton) findViewById(R.id.radioButton);
        rbtnF= (RadioButton) findViewById(R.id.radioButton2);

        dia= c.get(Calendar.DAY_OF_MONTH);
        mes= c.get(Calendar.MONTH);
        year=c.get(Calendar.YEAR);
        tvFecha.setText("Fecha de nacimiento: "+dia+"/"+mes+"/"+year);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void resultados(View v){
        if(rbtnM.isChecked())
            sexo=rbtnM.getText().toString();
        else
            sexo=rbtnF.getText().toString();

        if(ednombre.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Ingrese nombre", Toast.LENGTH_LONG).show();
        else{
            Intent i= new Intent(MainActivity.this, Resultados.class);
            i.putExtra("NOMBRE", ednombre.getText().toString());
            i.putExtra("FECHA", tvFecha.getText().toString());
            i.putExtra("SEXO", sexo);

            startActivity(i);
        }
    }

    public void verFecha(View v){
        showDialog(DATE_DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener,
                        year, mes, dia);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            mes = selectedMonth;
            dia = selectedDay;

            tvFecha.setText("Fecha de nacimiento: "+new StringBuilder().append(mes + 1)
                    .append("/").append(dia).append("/").append(year)
                    .append(" "));

        }
    };
}
