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

public class Obesidade3_Activity extends AppCompatActivity {

    private Button btnT8Fechar;
    private float peso;
    private float altura;
    //teste
    private float imc;
    private TextView textT8Peso;
    private TextView textT8Altura;
    private TextView textT8IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);

        //Recebendo os dados:
        Bundle bundle = getIntent().getExtras();
        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        float imc = bundle.getFloat("imc");

        textT8Peso = findViewById(R.id.textT8Peso);
        textT8Altura = findViewById(R.id.textT8Altura);
        textT8IMC = findViewById(R.id.textT8IMC);

        textT8Peso.setText(""+peso);
        textT8Altura.setText(""+altura);
        textT8IMC.setText(""+imc);

        // Direcionamento para a tela inicial
        btnT8Fechar = findViewById(R.id.btnT8Fechar);
        btnT8Fechar.setOnClickListener(view ->{
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
        Log.i("Ciclo de Vida", "Tela 8 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 8 - onPause");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 8 - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 8 - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 8 - onRestart");
    }

    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 8 - onStart");
    }
}