package com.example.rain.randomnumber;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText begin, end;
    com.gc.materialdesign.views.ButtonRectangle produce, history;
    SharedPreferences sharedPreferences;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        begin = (EditText) findViewById(R.id.number1);
        end = (EditText) findViewById(R.id.number2);
        produce = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.producebtn);
        history = (com.gc.materialdesign.views.ButtonRectangle) findViewById(R.id.historybtn);
        sharedPreferences = getSharedPreferences("count", MODE_WORLD_READABLE);
        count = sharedPreferences.getInt("count", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", ++count);
        editor.commit();

        produce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(begin.getText().toString());
                int b = Integer.parseInt(end.getText().toString());
                result.setText("" + makeRandom(a, b));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "count: " + count, Toast.LENGTH_SHORT).show();
            }
        });
    }

    int makeRandom(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }
}
