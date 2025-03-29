package com.example.trabalhocalculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoDoPeso_Activity extends AppCompatActivity {

    private Button btnT3Fechar;
    private float peso;
    private float altura;
    private float imc;
    private TextView textT3Peso;
    private TextView textT3Altura;
    private TextView textT3IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);

        //Recebendo os dados:
        Bundle bundle = getIntent().getExtras();
        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        float imc = bundle.getFloat("imc");

        textT3Peso = findViewById(R.id.textT3Peso);
        textT3Altura = findViewById(R.id.textT3Altura);
        textT3IMC = findViewById(R.id.textT3IMC);

        textT3Peso.setText(""+peso);
        textT3Altura.setText(""+altura);
        textT3IMC.setText(""+imc);

        // Direcionamento para a tela inicial
        btnT3Fechar = findViewById(R.id.btnT3Fechar);
        btnT3Fechar.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 3 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 3 - onPause");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 3 - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 3 - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 3 - onRestart");
    }

    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 3 - onStart");
    }
}