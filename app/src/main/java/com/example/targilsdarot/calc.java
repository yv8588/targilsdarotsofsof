package com.example.targilsdarot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class calc extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    TextView td, tsn, tx, tn;
    ListView list;
    int i;
    double x1, d2, a, n = 2;
    boolean kind;
    String sa,sx,sd;
    String[] sidra = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        Intent gi = getIntent();
        tx = (TextView) findViewById(R.id.tx);
        tsn = (TextView) findViewById(R.id.tsn);
        tn = (TextView) findViewById(R.id.tn);
        td = (TextView) findViewById(R.id.td);
        list = (ListView) findViewById(R.id.list);
        list.setChoiceMode(list.CHOICE_MODE_SINGLE);
        ArrayAdapter<String>adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,sidra);
        list.setAdapter(adp);
        list.setOnItemClickListener(this);

        x1 = gi.getDoubleExtra("a", 1);
        kind = gi.getBooleanExtra("k", false);
        d2 = gi.getDoubleExtra("b", 1);
        sx=String.valueOf(x1);
        sd=String.valueOf(d2);
        tx.setText(sx);
        td.setText(sd);
        if (kind) {
            for ( i = 0; i < 20; i++) {
                a = x1 + (d2 * (n - 1));
                sa=String.valueOf(a);
                sidra[i] = sa;
                n++;
            }

        }
        else{

            for ( i = 0; i < 20; i++){
                a=x1*Math.pow(d2,(n-1));
                sa=String.valueOf(a);
                 sidra[i]=sa;
                n++;
            }

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         tn.setText(sidra[position]);
         Integer m=position+2;
         tsn.setText(m.toString());
    }
}
