package com.example.activitat3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    //declaración de variables
    private Button boton;
    private EditText entrada;
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.boton);
        entrada = (EditText)findViewById(R.id.introposicion);
        salida = (TextView)findViewById(R.id.resultado);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrada.getText().toString();
                int num=Integer.parseInt(entrada.getText().toString());
                if (num >= 1 && num <= 9999){
                    int result=MainActivity.posicionNumeroPrimo(num);
                    salida.setText(String.valueOf(result));
                } else { //Si le numero no esta comprendido entre el 1 y el 9999 saltará un mensaje de error
                    AlertDialog mensajeError = new AlertDialog.Builder(MainActivity.this).create();
                    mensajeError.setTitle("ERROR");
                    mensajeError.setMessage("El número introducido ha de ser entre el 1 al 9999");
                    mensajeError.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    mensajeError.show();
                }
            }
        });

    }
    public static int posicionNumeroPrimo(int puesto){
        int num = 1;
        int cont = 0;
        while(cont != puesto){
            num++;
            if(primo(num)){
                cont++;
            }
        }
        return num;
    }

    public static boolean primo(int num){
        for (int i = 2; i < num; i++) {
            if((num % i) == 0){
                return false;
            }
        }
        return true;
    }
}
