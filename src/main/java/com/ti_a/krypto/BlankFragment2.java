package com.ti_a.krypto;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    EditText plaint,key,hasil;
    Button subm,reset;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        plaint = (EditText)v.findViewById(R.id.textin);
        key = (EditText)v.findViewById(R.id.kunci);
        hasil = (EditText)v.findViewById(R.id.hasil);
        subm = (Button)v.findViewById(R.id.set);
        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = new String();
                text = plaint.getText().toString();
                int kun = Integer.parseInt(key.getText().toString());
                hasil.setText(dekrip(text,kun));
            }
        });
        return v;
    }
    public static String dekrip(String plaintext, int keyIn){
        String cipher="";
        for (int i = 0;i < plaintext.length();i++){
            int charIndext = plaintext.charAt(i);
            int hsl = charIndext-(keyIn%26);
            cipher += (char)hsl;
        }
        return cipher;
    }

}
