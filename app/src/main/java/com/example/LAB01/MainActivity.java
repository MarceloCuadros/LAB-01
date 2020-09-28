package com.example.LAB01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static String PESO="PESO";
    public static String ESTATURA="ESTATURA";
    public static String IDIOMA="IDIOMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para el boton calcular imc
        Button btnCalcular = (Button)findViewById(R.id.btnCalcularImc);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try{
                //
                EditText edtEstatura =(EditText)findViewById(R.id.TxtEstatura);
                EditText edtPeso =(EditText)findViewById(R.id.TxtPeso);
                //
                String estatura = edtEstatura.getText().toString();
                String peso = edtPeso.getText().toString();
                //
                if (!peso.trim().isEmpty() || !estatura.trim().isEmpty()){
                    if(!peso.trim().isEmpty()){
                        if(!estatura.trim().isEmpty()){
                            Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
                            intent.putExtra(PESO,peso);
                            intent.putExtra(ESTATURA,estatura);
                            intent.putExtra(IDIOMA,Locale.getDefault().getLanguage());
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(),R.string.error1,Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),R.string.error2,Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),R.string.error3,Toast.LENGTH_SHORT).show();
                }
            }catch(Exception e){
                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}