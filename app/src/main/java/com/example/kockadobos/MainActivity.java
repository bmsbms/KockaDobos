package com.example.kockadobos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewCim,textViewJatekos,textViewGep,textViewEredmeny;
    ImageView imageViewJatekos,imageViewGep;
    Button buttonDobas;
    Random rnd = new Random();
    int gepDobas ;
    int gepPont=0;
    int jatekosDobas;
    int jatekosPont=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonDobas.setOnClickListener(this);
    }

    public void init()
    {
        textViewCim = findViewById(R.id.textVievCim);
        textViewJatekos = findViewById(R.id.textViewJatekos);
        textViewGep = findViewById(R.id.textViewGep);
        textViewEredmeny = findViewById(R.id.textViewEredmeny);
        imageViewJatekos = findViewById(R.id.imageViewJatekos);
        imageViewGep = findViewById(R.id.imageViewGep);
        buttonDobas = findViewById(R.id.buttonDobas);



    }


    @Override
    public void onClick(View v) {
        gepDobas= rnd.nextInt(6);
        jatekosDobas= rnd.nextInt(6);
        switch (gepDobas)
        {
            case 0:
                imageViewGep.setImageResource(R.drawable.kocka1);
                break;
            case 1:
                imageViewGep.setImageResource(R.drawable.kocka2);
                break;
            case 2:
                imageViewGep.setImageResource(R.drawable.kocka3);
                break;
            case 3:
                imageViewGep.setImageResource(R.drawable.kocka4);
                break;
            case 4:
                imageViewGep.setImageResource(R.drawable.kocka5);
                break;
            case 5:
                imageViewGep.setImageResource(R.drawable.kocka6);
                break;
        }

        switch (jatekosDobas)
        {
            case 0:
                imageViewJatekos.setImageResource(R.drawable.kocka1);
                break;
            case 1:
                imageViewJatekos.setImageResource(R.drawable.kocka2);
                break;
            case 2:
                imageViewJatekos.setImageResource(R.drawable.kocka3);
                break;
            case 3:
                imageViewJatekos.setImageResource(R.drawable.kocka4);
                break;
            case 4:
                imageViewJatekos.setImageResource(R.drawable.kocka5);
                break;
            case 5:
                imageViewJatekos.setImageResource(R.drawable.kocka6);
                break;
        }


        if(gepDobas>jatekosDobas)
        {
            gepPont++;
        }
        if (jatekosDobas>gepDobas)
        {
            jatekosPont++;
        }
        textViewEredmeny.setText(String.format("Jatekos pontok %d - Gep pontok %d",jatekosPont,gepPont));

        if (gepPont==3 )
        {
            AlertDialog alertdialog = new AlertDialog.Builder(MainActivity.this).create();
            alertdialog.setTitle("Vége a játéknak! A gép nyert");
            alertdialog.setMessage("Akarsz újat játszani?");
            alertdialog.setCancelable(false);
            alertdialog.setButton(alertdialog.BUTTON_NEGATIVE, "igen",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent main_activity = new Intent(MainActivity.this,MainActivity.class);
                            finish();
                            startActivity(main_activity);
                        }
                    });
            alertdialog.setButton(alertdialog.BUTTON_POSITIVE, "nem",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();

                        }
                    });
            alertdialog.show();
        }

        if (jatekosPont==3 )
        {
            AlertDialog alertdialog = new AlertDialog.Builder(MainActivity.this).create();
            alertdialog.setTitle("Vége a játéknak! Te nyertél");
            alertdialog.setMessage("Akarsz újat játszani?");
            alertdialog.setCancelable(false);
            alertdialog.setButton(alertdialog.BUTTON_NEGATIVE, "igen",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent main_activity = new Intent(MainActivity.this,MainActivity.class);
                            finish();
                            startActivity(main_activity);
                        }
                    });
            alertdialog.setButton(alertdialog.BUTTON_POSITIVE, "nem",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();

                        }
                    });
            alertdialog.show();
        }


    }
}
