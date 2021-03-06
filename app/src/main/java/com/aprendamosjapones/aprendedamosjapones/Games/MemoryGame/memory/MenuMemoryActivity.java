package com.aprendamosjapones.aprendedamosjapones.Games.MemoryGame.memory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.aprendamosjapones.aprendedamosjapones.R;
import com.aprendamosjapones.aprendedamosjapones.Games.MemoryGame.IntructionMemoryGame;

// Al terminar el juego, vuelva al menu de inicio.
// Pendiente: rotar reinicia el juego
// Pendiente: warning para salir
// Pendiente: custom size, con sus limitaciones y demás

/**
 * Main activity: menu where game mode is selected.
 *
 * @author Mateo Agudelo Toro
 */
public class MenuMemoryActivity extends AppCompatActivity {

    Button goMemoryInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_menu);

        setToolbar(); // Reemplazar toolbar

        final Button goInstructions = (Button) findViewById(R.id.instructionsMemory);
        goInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInstructions = new Intent(MenuMemoryActivity.this, IntructionMemoryGame.class);
                startActivity(goInstructions);
            }
        });


        Button playButton = (Button) findViewById(R.id.buttonJugarConcentrese);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((RadioButton) findViewById(R.id.radioButtonHiragana)).isChecked())
                    MemoryActivity.alphabet = "hiragana";
                else if (((RadioButton) findViewById(R.id.radioButtonKatakana)).isChecked())
                    MemoryActivity.alphabet = "katakana";
                else
                    MemoryActivity.alphabet = "kanji";

                if (((RadioButton) findViewById(R.id.radioButton10)).isChecked()) {
                    MemoryActivity.rows = 4;
                    MemoryActivity.columns = 5;
                    MemoryActivity.matches = 10;
                }
                else if (((RadioButton) findViewById(R.id.radioButton15)).isChecked()) {
                    MemoryActivity.rows = 5;
                    MemoryActivity.columns = 6;
                    MemoryActivity.matches = 15;
                }
                else {
                    MemoryActivity.rows = 5;
                    MemoryActivity.columns = 8;
                    MemoryActivity.matches = 20;
                }

                startActivity(new Intent(MenuMemoryActivity.this, MemoryActivity.class));


                goMemoryInstruction = (Button)findViewById(R.id.instructionsMemory);

                goMemoryInstruction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goMemoryInstruction = new Intent(MenuMemoryActivity.this, IntructionMemoryGame.class);
                        startActivity(goMemoryInstruction);
                    }
                });

            }
        });

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)// Habilitar Up Button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
