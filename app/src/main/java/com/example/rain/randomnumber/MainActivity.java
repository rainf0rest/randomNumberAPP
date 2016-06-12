package com.example.rain.randomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText begin, end;
    com.gc.materialdesign.views.ButtonRectangle produce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        begin = (EditText) findViewById(R.id.number1);
        end = (EditText) findViewById(R.id.number2);
        produce = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.producebtn);

        produce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(begin.getText().toString());
                int b = Integer.parseInt(end.getText().toString());
                result.setText("" + makeRandom(a, b));
            }
        });

    }

    int makeRandom(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }
}
