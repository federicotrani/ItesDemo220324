package com.example.ites220324;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPantalla, btnIngresar;
    Button btnSaludar;
    EditText edtMainNombreUsuario;

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Vovi a Primer Plano, Restaurando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.generarUI();

        this.CalcularEdad(1978, "Luis Perez");
    }

    private void CalcularEdad(int anioNacimiento, String nombrePersona) {
        Toast.makeText(this, "Hola " + nombrePersona, Toast.LENGTH_LONG);
    }
    
    private void generarUI(){
        // instancia de controles UI
        btnIngresar = findViewById(R.id.btnIngresar);
        btnPantalla = findViewById(R.id.btnPantalla);
        edtMainNombreUsuario = findViewById(R.id.edtMainNombreUsuario);
        btnSaludar = findViewById(R.id.btnSaludar);

        btnPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Evento Clic", Toast.LENGTH_SHORT).show();
            }
        });

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Bienvenido " + edtMainNombreUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}