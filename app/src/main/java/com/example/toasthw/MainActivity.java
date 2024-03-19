package com.example.toasthw;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    TextView tV1,tV2,tV3,tV4,tV5,tV6;
    EditText eT1,eT2,eT3;
    ImageView iW1,iW2,iW3;
    Button btn1,btn2,btn3,resetBtn;
    Random rnd = new Random();

    int num1,num6;
    int num2;
    int num3;
    int num4;


    String st1;
    String st2;
    String st3;
    int answer1;
    int answer2;
    int answer3;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV1 = findViewById(R.id.tV1);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        tV5 = findViewById(R.id.tV5);
        tV6 = findViewById(R.id.tV6);


        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);

        iW1 = findViewById(R.id.iW1);
        iW2 = findViewById(R.id.iW2);
        iW3 = findViewById(R.id.iW3);

        btn1=  findViewById(R.id.btn1);
        btn2=  findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        resetBtn= findViewById(R.id.btn4);




        tV3.setVisibility(View.INVISIBLE);
        tV4.setVisibility(View.INVISIBLE);
        tV5.setVisibility(View.INVISIBLE);
        tV6.setVisibility(View.INVISIBLE);

        eT2.setVisibility(View.INVISIBLE);
        eT3.setVisibility(View.INVISIBLE);

        iW2.setVisibility(View.INVISIBLE);
        iW3.setVisibility(View.INVISIBLE);

        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        resetBtn.setVisibility(View.INVISIBLE);

        num1=rnd.nextInt(90)+10;
        num2=rnd.nextInt(90)+10;
        num3=rnd.nextInt(90)+10;
        num4=rnd.nextInt(90)+10;

        tV1.setText(num1 + " ");
        tV2.setText(num2 + " ");
        tV4.setText(num3 + " ");
        tV6.setText(num4 + " ");

        tV3.setText(num1+num2 +" ");
        tV5.setText(num1+num2+num3+ " ");


    }

    public void dodge1(View view)
    {
        st1 = eT1.getText().toString();
        if(!st1.isEmpty())
        {

            answer1 = Integer.parseInt(st1);

            if(answer1 == num1+num2)
            {
                score++;
                iW1.setImageResource(R.drawable.v);
            }
            else
            {
                iW1.setImageResource(R.drawable.x);
            }
            tV3.setVisibility(View.VISIBLE);
            tV4.setVisibility(View.VISIBLE);
            eT2.setVisibility(View.VISIBLE);
            iW2.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn1.setEnabled(false);
        }
    }

    public void dodge2(View view)
    {
        st2 = eT2.getText().toString();
        if(!st2.isEmpty())
        {

            answer2 = Integer.parseInt(st2);

            if(answer2 == answer1+num3)
            {
                score++;
                iW2.setImageResource(R.drawable.v);
            }
            else
            {
                iW2.setImageResource(R.drawable.x);
            }

            tV5.setVisibility(View.VISIBLE);
            tV6.setVisibility(View.VISIBLE);
            eT3.setVisibility(View.VISIBLE);
            iW3.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn2.setEnabled(false);

        }
    }

    public void dodge3(View view)
    {
        st3 = eT3.getText().toString();
        if(!st3.isEmpty())
        {

            answer3 = Integer.parseInt(st3);

            if (answer3 == answer2 + num4)
            {
                score++;
                iW3.setImageResource(R.drawable.v);
            }
            else
            {
                iW3.setImageResource(R.drawable.x);
            }

            resetBtn.setVisibility(View.VISIBLE);
            resetBtn.setText(Math.round(33.33*score) +"% "+ score + "/3");
            btn3.setEnabled(false);
            Toast.makeText(this, Math.round(33.33*score) +"% "+ score + "/3", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Wrong Input", Toast.LENGTH_SHORT).show();
        }
    }

    public void bigDodge(View view)
    {
        tV3.setVisibility(View.INVISIBLE);
        tV4.setVisibility(View.INVISIBLE);
        tV5.setVisibility(View.INVISIBLE);
        tV6.setVisibility(View.INVISIBLE);

        eT2.setVisibility(View.INVISIBLE);
        eT3.setVisibility(View.INVISIBLE);
        eT1.setText("");
        eT2.setText("");
        eT3.setText("");


        iW1.setVisibility(View.INVISIBLE);
        iW2.setVisibility(View.INVISIBLE);
        iW3.setVisibility(View.INVISIBLE);

        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        resetBtn.setVisibility(View.INVISIBLE);

        num1=rnd.nextInt(90)+10;
        num2=rnd.nextInt(90)+10;
        num3=rnd.nextInt(90)+10;
        num4=rnd.nextInt(90)+10;

        tV1.setText(num1 + " ");
        tV2.setText(num2 + " ");
        tV4.setText(num3 + " ");
        tV6.setText(num4 + " ");

        tV3.setText(num1+num2 +" ");
        tV5.setText(num1+num2+num3+ " ");

        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);

        iW2.setImageBitmap(null);
        iW3.setImageBitmap(null);
        score = 0;


    }
}