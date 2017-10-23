package com.example.petrik.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mentes_Activity extends AppCompatActivity {

    private EditText input;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        input = (EditText) findViewById(R.id.editText_input);
        save = (Button) findViewById(R.id.btn_back);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Itt hozzuk létre a sharedpreference-t
                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);       //Maga a file neve mi legyen.
                SharedPreferences.Editor editor=sharedPreferences.edit();                                       //Editort létre kell hozni, hogy lehessen szerkeszteni
                editor.putString("name", input.getText().toString());                                           //editorba beleteszünk egy string-et
                editor.commit();                                                                                //Commit meg, hogy véglegesítjük.

                Intent Vissza_Menube = new Intent(Mentes_Activity.this,MainActivity.class);
                startActivity(Vissza_Menube);
                Toast.makeText(Mentes_Activity.this, "Adat mentve!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
