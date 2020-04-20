package com.example.projetoabastecer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText alcool, gasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcool = findViewById(R.id.valorAlcool);
        gasolina = findViewById(R.id.valorGasolina);
        resultado = findViewById(R.id.resultado);
    }

    public void calcular(View view){

        //recuperar os valores digitados
        String valorAlcool = alcool.getText().toString();
        String valorGasolina = gasolina.getText().toString();

        //validar os campos

        if(validacao(valorAlcool, valorGasolina)) {
            //conversão de String para Double
            Double precoAlcool = Double.parseDouble(valorAlcool);
            Double precoGasolina = Double.parseDouble(valorGasolina);
            double melhorOpcao = precoAlcool/precoGasolina;
            if(melhorOpcao  < 0.7){
                resultado.setText("Abasteça com álcool!");
            }else{
                resultado.setText("Abasteça com gasolina!");
            }

        }else{
            resultado.setText("Valores inválidos");
        }
    }

    public Boolean validacao(String valorAlcool, String valorGasolina){
        Boolean validacaoCampos = true;

        if(valorAlcool == null || valorAlcool.equals("")){
            validacaoCampos = false;
        } else if(valorGasolina == null || valorGasolina.equals("")){
            validacaoCampos = false;
        }
        return validacaoCampos;
    }
}
