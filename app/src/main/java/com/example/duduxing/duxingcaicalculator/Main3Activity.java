package com.example.duduxing.duxingcaicalculator;
//进制转换activity

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wper_smile.calc.R;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener {


    //Button 0-9 delete edt 声明
    Button btn_zero;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_A;
    Button btn_B;
    Button btn_C;
    Button btn_D;
    Button btn_E;
    Button btn_F;
    Button btn_delete;
    EditText edt_old;
    Button btn_dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //显现布局文件activity_main3.xml
        setContentView(R.layout.activity_main3);


        //透明状态栏
       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //获取控件id，实例化控件
        btn_zero=(Button)findViewById(R.id.btn_zero);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);
        btn_5=(Button)findViewById(R.id.btn_5);
        btn_6=(Button)findViewById(R.id.btn_6);
        btn_7=(Button)findViewById(R.id.btn_7);
        btn_8=(Button)findViewById(R.id.btn_8);
        btn_9=(Button)findViewById(R.id.btn_9);
        btn_A=(Button)findViewById(R.id.btn_A);
        btn_B=(Button)findViewById(R.id.btn_B);
        btn_C=(Button)findViewById(R.id.btn_C);
        btn_D=(Button)findViewById(R.id.btn_D);
        btn_E=(Button)findViewById(R.id.btn_E);
        btn_F=(Button)findViewById(R.id.btn_F);
        btn_delete=(Button)findViewById(R.id.btn_delete);
        btn_dec=(Button)findViewById(R.id.btn_dec);

        //为控件赋予点击事件
        btn_zero.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_A.setOnClickListener(this);
        btn_B.setOnClickListener(this);
        btn_C.setOnClickListener(this);
        btn_D.setOnClickListener(this);
        btn_E.setOnClickListener(this);
        btn_F.setOnClickListener(this);

        btn_delete.setOnClickListener(this);
        btn_dec.setOnClickListener(this);

        edt_old= (EditText)findViewById(R.id.edt_old);
        final TextView tex_show=(TextView)findViewById(R.id.tex_show);
        Button btn_change= (Button) findViewById(R.id.btn_change);
        //Spinner复数
        final Spinner spin_old=(Spinner)findViewById(R.id.spin_old);
        final Spinner spin_new=(Spinner)findViewById(R.id.spin_new);

        //输入类型为没有指定明确的类型的特殊内容类型
        edt_old.setInputType(InputType.TYPE_NULL);

        spin_old.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] old= getResources().getStringArray(R.array.old);
                if (old.equals("2"))
                {
                    String[] news=getResources().getStringArray(R.array.news);
                    if (news.equals("2"))
                    {
                        tex_show.setText(edt_old.getText().toString());
                    }
                }
            }

            @Override
            // parent为适配器指针
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_old=(String) spin_old.getSelectedItem();

                //Pattern pattern = Pattern.compile("[0-1]+");
                //Matcher matcher = pattern.matcher(str_old);


                //进制2转 2 8 10 16
                if (str_old.equals("2"))
                {
                    try {

                        String str_news=(String) spin_new.getSelectedItem();
                        if (str_news.equals("2"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toBinaryString(Integer.parseInt(old,2)));
                        }
                        if (str_news.equals("8"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toOctalString(Integer.parseInt(old,2)));
                        }
                        if (str_news.equals("10"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.valueOf(old,2).toString());
                        }
                        if (str_news.equals("16"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toHexString(Integer.parseInt(old,2)));
                        }
                    }
                    catch (Exception e){
                        tex_show.setText("哎呀这不是二进制数啊，请检查下吧");
                    }
                }
                //进制8转 2 8 10 16
                if (str_old.equals("8"))
                {
                    try {
                        String str_news=(String) spin_new.getSelectedItem();
                        if (str_news.equals("2"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toBinaryString(Integer.parseInt(old,8)));
                        }
                        if (str_news.equals("8"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toOctalString(Integer.parseInt(old,8)));
                        }
                        if (str_news.equals("10"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.valueOf(old,8).toString());
                        }
                        if (str_news.equals("16"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toHexString(Integer.parseInt(old,8)));
                        }
                    }
                    catch (Exception e){tex_show.setText("输入有误，请检查下吧");}
                }

                //进制10转 2 8 10 16
                if (str_old.equals("10"))
                {
                    try {
                        String str_news=(String) spin_new.getSelectedItem();
                        if (str_news.equals("2"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toBinaryString(Integer.parseInt(old,10)));
                        }
                        if (str_news.equals("8"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toOctalString(Integer.parseInt(old,10)));
                        }
                        if (str_news.equals("10"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.valueOf(old,10).toString());
                        }
                        if (str_news.equals("16"))
                        {
                            String old=edt_old.getText().toString();
                            tex_show.setText(Integer.toHexString(Integer.parseInt(old,10)));
                        }
                    }
                    catch (Exception e){tex_show.setText("输入有误，请检查下吧");}
                }

                //进制16转 2 8 10 16
                if (str_old.equals("16"))
                {


                    String str_news=(String) spin_new.getSelectedItem();
                    if (str_news.equals("2"))
                    {
                        String old=edt_old.getText().toString();
                        tex_show.setText(Integer.toBinaryString(Integer.parseInt(old,16)));
                    }
                    if (str_news.equals("8"))
                    {
                        String old=edt_old.getText().toString();
                        tex_show.setText(Integer.toOctalString(Integer.parseInt(old,16)));
                    }
                    if (str_news.equals("10"))
                    {
                        String old=edt_old.getText().toString();
                        tex_show.setText(Integer.valueOf(old,16).toString());
                    }
                    if (str_news.equals("16"))
                    {
                        String old=edt_old.getText().toString();
                        tex_show.setText(Integer.toHexString(Integer.parseInt(old,16)));
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        String str_old=edt_old.getText().toString();
        switch (v.getId())
        {
            //Button 点击事件处理
            case R.id.btn_zero:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_A:
            case R.id.btn_B:
            case R.id.btn_C:
            case R.id.btn_D:
            case R.id.btn_E:
            case R.id.btn_F:
                edt_old.setText(str_old + ((Button)v).getText());
                break;

            case R.id.btn_delete:
                edt_old.setText("");
                break;
            case R.id.btn_dec:
                if (str_old!=null &&!str_old.equals(""))
                    edt_old.setText(str_old.substring(0,str_old.length()-1));
                break;
        }
    }
}
