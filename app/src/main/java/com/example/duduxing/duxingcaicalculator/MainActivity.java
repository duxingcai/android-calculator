package com.example.duduxing.duxingcaicalculator;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.wper_smile.calc.R;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MeEval result=new MeEval();

    //声明按钮
    //Button 1-9 和小数点 声明
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_decimal;

    //Button + - × ÷ = 声明
    Button btn_addition;
    Button btn_subtraction;
    Button btn_multiplication;
    Button btn_division;
    Button btn_sum;

    //Button C 和 DEL 声明
    Button btn_clean;
    Button btn_delete;

    //EditText 声明
    EditText edit_show;
    EditText edit_result;

    //三角函数 根号声明
    Button btn_sin;
    Button btn_cos;
    Button btn_tan;
    Button btn_radical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //获取控件id，实例化控件
        btn_0=(Button)findViewById(R.id.btn_0);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);
        btn_5=(Button)findViewById(R.id.btn_5);
        btn_6=(Button)findViewById(R.id.btn_6);
        btn_7=(Button)findViewById(R.id.btn_7);
        btn_8=(Button)findViewById(R.id.btn_8);
        btn_9=(Button)findViewById(R.id.btn_9);

        //小数点实例化
        btn_decimal=(Button)findViewById(R.id.btn_decimal);

        //三角函数实例化
        btn_sin=(Button)findViewById(R.id.btn_sin);
        btn_cos=(Button)findViewById(R.id.btn_cos);
        btn_tan=(Button)findViewById(R.id.btn_tan);

        //根号实例化
        btn_radical=(Button)findViewById(R.id.btn_radical);

        //+-x/=按钮实例化
        btn_addition=(Button)findViewById(R.id.btn_addition);
        btn_subtraction=(Button)findViewById(R.id.btn_subtraction);
        btn_multiplication=(Button)findViewById(R.id.btn_multiplication);
        btn_division=(Button)findViewById(R.id.btn_division);
        btn_sum=(Button)findViewById(R.id.btn_sum);

        //清空、删除按钮实例化
        btn_clean=(Button)findViewById(R.id.btn_clean);
        btn_delete=(Button)findViewById(R.id.btn_delete);

        //输入、结果实例化
        edit_show=(EditText)findViewById(R.id.edit_show);
        edit_result=(EditText)findViewById(R.id.edit_result);


        //以下为设置按钮点击事件
        //为按钮赋予点击事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_decimal.setOnClickListener(this);

        btn_addition.setOnClickListener(this);
        btn_subtraction.setOnClickListener(this);
        btn_multiplication.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        btn_sum.setOnClickListener(this);

        btn_clean.setOnClickListener(this);
        btn_delete.setOnClickListener(this);

        edit_show.setOnClickListener(this);

        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_tan.setOnClickListener(this);
        btn_radical.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String string=edit_show.getText().toString();

        switch (v.getId()) {

            //数字逻辑判断
            //Button 点击事件处理
            case R.id.btn_0:
            {
                try {
                    if (string.equals(""))
                        edit_show.setText(string + ((Button)v).getText());
                    else
                    {
                        if (!string.substring(string.length()-1,string.length()).equals("÷"))
                            edit_show.setText(string + ((Button)v).getText());
                    }

                }
                catch (Exception e){}
                break;
            }
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            {
                edit_show.setText(string + ((Button)v).getText());
                if (!string.matches("[-+÷×]$"))
                    edit_result.setText(result.eval(string+((Button)v).getText()+"="));
                break;
            }
            case R.id.btn_decimal:
            {
                try {
                    if (string.substring(string.length()-1,string.length()).matches("[0-9]$"))
                        edit_show.setText(string + ((Button)v).getText());
                }
                catch (Exception e){}
                break;
            }


            //运算符+逻辑判断
            case R.id.btn_addition:
            {
                try {
                    if (string.substring(string.length()-1,string.length()).equals("-"))
                        edit_show.setText(string.substring(0,string.length()-1) + ((Button)v).getText());
                    else
                    {
                        if (!string.substring(string.length()-1,string.length()).equals("+"))
                            edit_show.setText(string + ((Button)v).getText());
                    }
                }
                catch (Exception e){}
                break;
            }

            //运算符-逻辑判断
            case R.id.btn_subtraction:
            {
                try {
                    if (string.substring(string.length()-1,string.length()).equals("+"))
                        edit_show.setText(string.substring(0,string.length()-1) + ((Button)v).getText());
                    else
                    {
                        if (!string.substring(string.length()-1,string.length()).equals("-"))
                            edit_show.setText(string + ((Button)v).getText());
                    }
                }
                catch (Exception e){}
                break;
            }

            //运算符x逻辑判断
            case R.id.btn_multiplication:
            {
                try {
                    if (string.substring(string.length()-1,string.length()).equals("÷"))
                        edit_show.setText(string.substring(0,string.length()-1) + ((Button)v).getText());
                    else
                    {
                        if (!string.substring(string.length()-1,string.length()).equals("×"))
                            edit_show.setText(string + ((Button)v).getText());
                    }
                }
                catch (Exception e){}
            }
            break;

            //运算符/逻辑判断
            case R.id.btn_division:
            {
                try {
                    if (string.substring(string.length()-1,string.length()).equals("×"))
                        edit_show.setText(string.substring(0,string.length()-1) + ((Button)v).getText());
                    else
                    {
                        if (!string.substring(string.length()-1,string.length()).equals("÷"))
                            edit_show.setText(string + ((Button)v).getText());
                    }
                }
                catch (Exception e){}
            }
            break;

            //"清空"按钮逻辑判断
            case R.id.btn_clean:
                edit_show.setText(null);
                edit_result.setText(null);
                break;

            //"删除"按钮逻辑判断
            case R.id.btn_delete:
            {
                try {
                    if (string!=null&&!string.equals(""))
                        edit_show.setText(string.substring(0,string.length()-1));
                    if (!string.substring(string.length()-1,string.length()).equals("÷")||
                            !string.substring(string.length()-1,string.length()).equals("+")||
                            !string.substring(string.length()-1,string.length()).equals("-")||
                            !string.substring(string.length()-1,string.length()).equals("×"))
                        edit_result.setText(result.eval(string.substring(0,string.length()-1)+"="));
                }
                catch (Exception e){}
            }
                break;


            //temp为角度 全部转弧度计算
            //sin函数逻辑判断
            case R.id.btn_sin:
            {
                try {
                    double temp = Double.parseDouble(string);
                    edit_show.setText(Math.sin(temp * Math.PI / 180.0) + "");
                    edit_result.setText("");
                }
                catch (Exception e){}
                break;
            }

            //cos函数逻辑判断
            case R.id.btn_cos:
            {
                try {
                    double temp = Double.parseDouble(string);
                    edit_show.setText(Math.cos(temp*Math.PI /180.0) + "");
                    edit_result.setText("");
                }
                catch (Exception e){}
                break;
            }

            //tan函数逻辑判断
            case R.id.btn_tan:
            {
                try {
                    double temp = Double.parseDouble(string);
                    edit_show.setText(Math.tan(temp * Math.PI / 180.0) + "");
                    edit_result.setText("");
                }
                catch (Exception e){}
                break;
            }

            //根号运算符逻辑判断
            case R.id.btn_radical:
            {
                try {
                    double temp = Double.parseDouble(string);
                    edit_show.setText(Math.sqrt(temp) + "");
                    edit_result.setText("");
                }
                catch (Exception e){}
                break;
            }

            //=运算符逻辑判断
            case R.id.btn_sum:
                edit_show.setText(result.eval(string+"="));
                edit_result.setText("");
                break;
        }
    }

    //输出字符串
    public String getString() {
        String str = edit_show.getText().toString();
        return str;
    }

    //创建一个菜单，进制转换菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);//获取自定义菜单
        return true;
    }

//菜单点击事件
//弹出一个对话框，版本说明
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about:
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("版本1.0\n" +
                        "编译日期：2017.10.06\n" +
                        "制作人:duxingcai")//显示对话框消息内容
                        .setTitle("简单计算器");//对话框标题
                builder.show();
            }
            break;
            case R.id.item_change:
            {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
