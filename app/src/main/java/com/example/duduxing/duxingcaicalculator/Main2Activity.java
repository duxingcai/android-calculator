package com.example.duduxing.duxingcaicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wper_smile.calc.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //getFragmentManager().findFragmentById(R.id.m_fra).getView().findViewById(R.id.activity_main2).isShown();
        final   EditText edt_10= (EditText)findViewById(R.id.edt_10);
        final TextView tex_show=(TextView)findViewById(R.id.tex_show);

        //进制数控件实例化
        Button btn_change2= (Button) findViewById(R.id.btn_change2);
        Button btn_change8= (Button) findViewById(R.id.btn_change8);
        Button btn_change16= (Button) findViewById(R.id.btn_change16);

        //为控件赋予点击事件
        btn_change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=edt_10.getText().toString();
                int i_10= Integer.parseInt(temp);
                tex_show.setText(Integer.toBinaryString(i_10));
            }
        });
        btn_change8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=edt_10.getText().toString();
                int i_10= Integer.parseInt(temp);
                tex_show.setText(Integer.toOctalString(i_10));
            }
        });
        btn_change16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=edt_10.getText().toString();
                int i_10= Integer.parseInt(temp);
                tex_show.setText(Integer.toHexString(i_10));
            }
        });
    }
}
