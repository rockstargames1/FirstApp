package com.example1.kishlay.f1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    TextView hideShowTextView;
    Button increment,decrement,newGame;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideShowTextView = (TextView)findViewById(R.id.hideShowTextView);
        increment = (Button)findViewById(R.id.increment);
        decrement = (Button)findViewById(R.id.decrement);
        newGame = (Button)findViewById(R.id.newGame);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = Integer.parseInt(hideShowTextView.getText().toString());
                Random rand = new Random();
                n += (rand.nextInt(40)+1);
                hideShowTextView.setText(Integer.toString(n));
                if(n%10==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "You Got It!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration).show();

                    increment.setVisibility(View.INVISIBLE);
                    decrement.setVisibility(View.INVISIBLE);
                    increment.setClickable(false);
                    decrement.setClickable(false);
                }
                            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = Integer.parseInt(hideShowTextView.getText().toString());
                Random rand = new Random();
                n -= (rand.nextInt(40)+1);
                hideShowTextView.setText(Integer.toString(n));
                if(n%10==0)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "You Got It!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration).show();

                    increment.setBackgroundColor(0);
                    decrement.setBackgroundColor(0);
                    increment.setVisibility(View.INVISIBLE);
                    decrement.setVisibility(View.INVISIBLE);
                    increment.setClickable(false);
                    decrement.setClickable(false);
                }
            }
        });
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideShowTextView.setText("0");
                increment.setBackgroundColor(0xFF0000FF);
                decrement.setBackgroundColor(0xFF0000FF);
                increment.setVisibility(View.VISIBLE);
                decrement.setVisibility(View.VISIBLE);
                increment.setClickable(true);
                decrement.setClickable(true);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
