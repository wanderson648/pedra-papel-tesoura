package com.wo.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }


   public void selecionarPedra(View v) {
      this.opcaoSelecionada("Pedra");
   }

   public void selecionarPapel(View v) {
      this.opcaoSelecionada("Papel");
   }

   public void selecionarTesoura(View v) {
      this.opcaoSelecionada("Tesoura");
   }

   public void opcaoSelecionada(String opUser) {
      ImageView imageResult = findViewById(R.id.img_result);
      TextView txtResult = findViewById(R.id.txt_result);

      int number = new Random().nextInt(3);

      String[] options = {"Pedra", "Papel", "Tesoura"};
      String opApp = options[number];

      switch (opApp) {
         case "Pedra":
            imageResult.setImageResource(R.drawable.pedra);
            break;
         case "Papel":
            imageResult.setImageResource(R.drawable.papel);
            break;
         case "Tesoura":
            imageResult.setImageResource(R.drawable.tesoura);
            break;
      }

      if ((opApp.equals("Pedra") && opUser.equals("Tesoura")) ||
          (opApp.equals("Papel") && opUser.equals("Pedra")) ||
          (opApp.equals("Tesoura") && opUser.equals("Papel"))
      ) {
         txtResult.setText("Você perdeu :(");
      } else if ((opUser.equals("Pedra") && opApp.equals("Tesoura")) ||
                 (opUser.equals("Papel") && opApp.equals("Pedra")) ||
                 (opUser.equals("Tesoura") && opApp.equals("Papel"))
      ) {
         txtResult.setText("Você ganhou :)");
      } else {
         txtResult.setText("Empatamos :|");
      }

   }
}