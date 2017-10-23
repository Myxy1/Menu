package com.example.petrik.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_next, btn_mentes, btn_info, btn_exit;
    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        listeners();
    }

    public void init(){

        btn_next = (Button) findViewById(R.id.btn_next);
        btn_mentes = (Button) findViewById(R.id.btn_save);
        btn_info = (Button) findViewById(R.id.btn_inform);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setMessage("Ki akarsz lépni?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener(){     //Pozitív gomb = jobb oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which){

                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener(){    //Negatív gomb = bal oldali gomb
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }

    public void listeners(){

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intentet kell itt használni (első adat amit megadtunk = itteni Activity neve, második adat amit megadtunk = másik Activity neve)
                Intent intent = new Intent(MainActivity.this,Masodik_Activity.class);
                startActivity(intent);      //elindítjuk ezt a folyamatot.
            }
        });

        btn_mentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mentes_Activityre = new Intent(MainActivity.this,Mentes_Activity.class);
                startActivity(Mentes_Activityre);
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mi is az a sharedpreferences?....Ez egy úgynevezett globális változó. Ezt arra szoktuk használni, ha egy értéket a másik activityben is akarjuk
                //használni. Sok fajta változatai vannak és ezt biztos fogjuk még használni.

                //Itt most azt csináltuk, hogy a Mentes_Activitybe beírt nevünket ki fogjuk írni Toastal

                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);           //Létrehozzuk a file-t (ebben az activityben)
                String informacio = sharedPreferences.getString("name","");                                         //Lekérjük a name adatott amibe beletettünk egy stringet a Mentes_Activity-nél és beletesszük egy stringbe
                Toast.makeText(MainActivity.this,"SharedPreference adat:"+informacio,Toast.LENGTH_SHORT).show();                             //Toast-ban kiíratjuk az adatott.
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        });
    }
}
