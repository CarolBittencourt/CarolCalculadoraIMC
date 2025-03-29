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

public class Obesidade2_Activity extends AppCompatActivity {

    private Button btnT7Fechar;
    private float peso;
    private float altura;
    private float imc;
    private TextView textT7Peso;
    private TextView textT7Altura;
    private TextView textT7IMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);

        //Recebendo os dados:
        Bundle bundle = getIntent().getExtras();
        float peso = bundle.getFloat("peso");
        float altura = bundle.getFloat("altura");
        float imc = bundle.getFloat("imc");

        textT7Peso = findViewById(R.id.textT7Peso);
        textT7Altura = findViewById(R.id.textT7Altura);
        textT7IMC = findViewById(R.id.textT7IMC);

        textT7Peso.setText(""+peso);
        textT7Altura.setText(""+altura);
        textT7IMC.setText(""+imc);

        // Direcionamento para a tela inicial
        btnT7Fechar = findViewById(R.id.btnT7Fechar);
        btnT7Fechar.setOnClickListener(view ->{
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
        Log.i("Ciclo de Vida", "Tela 7 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 7 - onPause");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 7 - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 7 - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 7 - onRestart");
    }

    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 7 - onStart");
    }
}