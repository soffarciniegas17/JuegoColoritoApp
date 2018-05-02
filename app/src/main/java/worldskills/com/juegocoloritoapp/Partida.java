package worldskills.com.juegocoloritoapp;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Partida extends AppCompatActivity{

    int Tipo_Partida, PalabraColor, PalabraLetra, puntaje, intentos, mal, bien, palabras;
    Long tiempoPalabra, tiempoPartida;
    private String colores[]= {"AMARILLO", "ROJO", "AZUL", "VERDE"};
    Boolean timeOn;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);
        Bundle recuperar;
        try {
            recuperar= getIntent().getExtras();
            Tipo_Partida= recuperar.getInt("Tipo_Partida");

        }  catch (Exception e){
            Tipo_Partida= 0;
        }

        puntaje=0; mal=0; bien=0; palabras=0;

    }

    public int aleatorio(){
        Random azar= new Random();
        int numeroA= azar.nextInt(colores.length);
        return numeroA;
    }

    public void AsignarColores (){
        TextView palabra= (TextView) findViewById(R.id.palabra);
        PalabraColor= aleatorio();
        switch (PalabraColor){
            case 0:
                palabra.setTextColor(Color.YELLOW);
                break;
            case 1:
                palabra.setTextColor(Color.RED);
                break;
            case 2:
                palabra.setTextColor(Color.BLUE);
                break;
            case 3:
                palabra.setTextColor(Color.GREEN);
                break;
        }

    }


    public void MostrarJuego (){
        palabras++;
        TextView score, palabrasC, palabra, bienmal;
        score= (TextView) findViewById(R.id.score);
        palabrasC= (TextView) findViewById(R.id.words);
        bienmal= (TextView) findViewById(R.id.bien_mal);
        palabra= (TextView) findViewById(R.id.palabra);
        score.setText(""+puntaje);
        bienmal.setText(""+bien+" / "+ mal);
        palabrasC.setText(""+ palabras);
        AsignarColores();
        PalabraLetra= aleatorio();
        palabra.setText(colores[PalabraLetra]);
    }

    public void Juego (){
        if (Tipo_Partida==1){
            intentos= 3;
            tiempoPalabra=3000l;
        }
        MostrarJuego();
        TiempoPalabra();
            ImageButton bcorrecto, bincorrecto;
            bcorrecto= (ImageButton) findViewById(R.id.botonCorrecto);
            bincorrecto= (ImageButton) findViewById(R.id.botonIncorrecto);

            bcorrecto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (PalabraColor==PalabraLetra){
                        bien++;
                        puntaje++;
                    } else {
                        mal++;
                        intentos--;
                    }
                    Juego();
                }
            });

            bcorrecto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (PalabraColor!=PalabraLetra){
                        bien++;
                        puntaje++;
                    } else {
                        mal++;
                        intentos--;
                    }
                    Juego();


                }
            });
    }

    public void TiempoPalabra(){
        CountDownTimer a = new CountDownTimer(tiempoPalabra,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                mal++;
                intentos--;
                Juego();

            }
        }.start();
    }

    public void IniciarPartida (){

    }
}

