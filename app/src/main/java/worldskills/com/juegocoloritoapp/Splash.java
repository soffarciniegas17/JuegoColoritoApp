package worldskills.com.juegocoloritoapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {


    ImageView imagen;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imagen= (ImageView) findViewById(R.id.imagensplash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Inicio.class);
                startActivity(i);
            }
        }, 3000);
    }
}
