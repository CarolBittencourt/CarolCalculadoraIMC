package com.example.trabalhocalculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalculoIMC_Activity extends AppCompatActivity {

    private Button btnT2Set;
    private Button btnT2Reset;
    private Button btnT2Fechar;
    private EditText textT2Peso;
    private EditText textT2Altura;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imc);

        Log.i("Ciclo de Vida", "Tela 2 - onCreate");

        btnT2Set = findViewById(R.id.btnT2Set);
        btnT2Reset = findViewById(R.id.btnT2Reset);
        btnT2Fechar = findViewById(R.id.btnT2Fechar);
        textT2Peso = findViewById(R.id.textT2Peso);
        textT2Altura = findViewById(R.id.textT2Altura);


        //Chama a tela correspondente ao imc:

        btnT2Set.setOnClickListener(view ->{

            float peso = Float.parseFloat(textT2Peso.getText().toString());
            float altura = Float.parseFloat(textT2Altura.getText().toString());
            float imc;
            imc = peso / ((altura) * (altura));
            DecimalFormat df = new DecimalFormat("#.##");

            // Condicional fará a conta de IMC e direcionará para a tela correspondente ao resultado
            Class activity = MainActivity.class;

            if(imc<18.5){
                activity = AbaixoDoPeso_Activity.class;
            }
            else if(imc>=18.5 && imc<25){
                activity = PesoNormal_Activity.class;
            }
            else if (imc>=25 && imc<30) {
                activity = Sobrepeso_Activity.class;
            }
            else if (imc>=30 && imc<35){
                activity = Obesidade1_Activity.class;
            }
            else if (imc>=35 && imc <40) {
                activity = Obesidade2_Activity.class;
            }
            else if (imc>=40) {
                activity = Obesidade3_Activity.class;
            }
            Intent intent = new Intent(this, activity);
            intent.putExtra("peso",peso);
            intent.putExtra("altura",altura);
            intent.putExtra("imc",imc);
            startActivity(intent);
        });

        //Botão para limpar os valores de altura e peso:
        btnT2Reset.setOnClickListener(view ->{
            textT2Peso.setText("");
            textT2Altura.setText("");
        });

        // Botão para fechar e ir para a tela inicial
        btnT2Fechar = findViewById(R.id.btnT2Fechar);
        btnT2Fechar.setOnClickListener(view ->{
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
        Log.i("Ciclo de Vida", "Tela 2 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 2 - onPause");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 2 - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 2 - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 2 - onRestart");
    }

    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 2 - onStart");
    }
}