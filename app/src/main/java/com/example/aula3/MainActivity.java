package com.example.aula3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

    public void CalculeoPresso(View view){
        EditText arco = findViewById(R.id.editTextNumberSigned);
        EditText gasosa = findViewById(R.id.editTextNumberSigned2);
        TextView result = findViewById(R.id.Resultado);

        if (Float.parseFloat((arco.getText().toString())) > Float.parseFloat((gasosa.getText().toString()))){
            float alcool = Float.parseFloat(arco.getText().toString());
            float gasolina = Float.parseFloat(gasosa.getText().toString());
            float Barato = alcool - gasolina;
            float galosinaDesconto = Barato/ gasolina;


            result.setText("Gasolina é melhor e "  + Math.abs(galosinaDesconto) + "% \n Mais Barato");
        }else {
            float alcool = Float.parseFloat(arco.getText().toString());
            float gasolina = Float.parseFloat(gasosa.getText().toString());
            float Barato = alcool - gasolina;
            float alcoolaDesconto = Barato/ alcool;


            result.setText("Alcool é melhor e " + Math.abs(alcoolaDesconto) + "% \n Mais Barato");
        }

        }
    }
