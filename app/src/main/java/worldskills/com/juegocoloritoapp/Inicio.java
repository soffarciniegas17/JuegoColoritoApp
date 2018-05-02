package worldskills.com.juegocoloritoapp;


import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Inicio extends AppCompatActivity  {

    Dialog pantalla_puntajes;
    private int m1, m2, m3, m4, m5;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        pantalla_puntajes = new Dialog(this);
        pantalla_puntajes.setCanceledOnTouchOutside(false);
         pantalla_puntajes.setContentView(R.layout.activity_puntajes);
        pantalla_puntajes.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    public void onResume() {
        super.onResume();
        SharedPreferences datos= PreferenceManager.getDefaultSharedPreferences(this);
        m1= datos.getInt("m1",0);
        m2= datos.getInt("m2", 0);
        m3= datos.getInt("m3", 0);
        m4= datos.getInt("m4", 0);
        m5= datos.getInt ("m5", 0);

        TextView t1, t2, t3, t4, t5;

        t1= (TextView) findViewById(R.id.t1);
        t2= (TextView) findViewById(R.id.t2);
        t3= (TextView) findViewById(R.id.t3);
        t4= (TextView) findViewById(R.id.t4);
        t5= (TextView) findViewById(R.id.t5);

        t1.setText(""+m1);
        t2.setText(""+m2);
        t3.setText(""+m3);
        t4.setText(""+m4);
        t5.setText(""+m5);

    }

    public void  Botones (View v){
        ImageButton play, settings, scores;
        play= (ImageButton) findViewById(R.id.jugar);
        settings= (ImageButton)findViewById(R.id.configuracion);
        scores= (ImageButton) findViewById(R.id.puntajes);


        switch (v.getId()){
            case R.id.jugar:

                Intent i = new Intent(this, Partida.class);
                i.putExtra("Tipo_Partida", 1);
                startActivity(i);
                break;

            case R.id.configuracion :
                Intent intent = new Intent(this, Configuracion.class);
                startActivity(intent);
                break;

            case R.id.puntajes:
                TextView salir_x;
                salir_x= (TextView) findViewById(R.id.salir);
                salir_x.setOnClickListener(this );

                pantalla_puntajes.show();

        }
    }


}