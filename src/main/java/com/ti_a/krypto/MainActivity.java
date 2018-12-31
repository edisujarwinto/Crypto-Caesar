package com.ti_a.krypto;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar tool;
    FrameLayout tempat;
    FragmentTransaction ft;
    Button toDekripCaes;
    int lay ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempat = (FrameLayout)findViewById(R.id.tangkak);
        tool = (Toolbar)findViewById(R.id.toolbar);
        toDekripCaes = (Button)findViewById(R.id.caesarTo);
        toDekripCaes.setEnabled(false);
        toDekripCaes.setVisibility(View.INVISIBLE);
        setSupportActionBar(tool);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pilih,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.caesar:
                BlankFragment fragment1 = new BlankFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.tangkak,fragment1);
                ft.commit();
                tool.setTitle("Caesar Code");
                tool.setSubtitle("Enkripsi");
                toDekripCaes.setEnabled(true);
                toDekripCaes.setVisibility(View.VISIBLE);
                lay = 1;
            case R.id.ascii:
                tool.setTitle("Ascii Code");
                tool.setSubtitle("Enkripsi");
                /*BlankFragment ascii = new BlankFragment();
                ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.tangkak,ascii);
                ft.commit();*/
        }
        return true;
    }

    public void panggilDekripsi(View view) {
        if (lay==1){
            tool.setSubtitle("Dekrip");
            tool.setTitle("Caesar Code");
            BlankFragment2 dekrip = new BlankFragment2();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tangkak,dekrip);
            ft.commit();
            lay=0;
            toDekripCaes.setText("Enkrip");
        } else if(lay==0){
            BlankFragment fragment1 = new BlankFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tangkak,fragment1);
            ft.commit();
            lay=1;
            tool.setSubtitle("Enkripsi");
            toDekripCaes.setText("Dekrip");
            tool.setTitle("Caesar Code");
        }

    }
}
