package com.example.e0046479.day1_workshop;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private void convert(EditText t, double factor, EditText r) {
        double i = Double.parseDouble(t.getText().toString());
        r.setText(String.format("%5f", i*factor));
    }

    private double getConversion() {
        final Spinner s = (Spinner) findViewById(R.id.spinner1);
        int i = s.getSelectedItemPosition();

        Resources res = getResources();
        String[] va = res.getStringArray(R.array.currencyV);
        return(Double.parseDouble(va[i]));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText t1 = (EditText) findViewById(R.id.editText1);
        final EditText t2 = (EditText) findViewById(R.id.editText2);
        t1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    double f = getConversion();
                    convert(t1, 1/f, t2);
                }
            }
        });
        t2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    double f = getConversion();
                    convert(t2, f, t1);
                }
            }
        });
        final Button buttonNextDesign = (Button) findViewById(R.id.buttonNextDesign);
        buttonNextDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this,getString(R.string.next_design_layout),Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("eieimaw","the the is pel pel");
                startActivity(intent);
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
}
