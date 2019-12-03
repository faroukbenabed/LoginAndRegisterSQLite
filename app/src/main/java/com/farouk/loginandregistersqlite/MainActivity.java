package com.farouk.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
EditText e1,e2,e3;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.opass);
        b1=(Button) findViewById(R.id.register);
        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if (s1.equals("")||s2.equals("")||e3.equals("")){
                    Toast.makeText(getApplicationContext(),"Filde empty",Toast.LENGTH_LONG);
                }else{
                    if (s2.equals(s3)){
                        Boolean checkemail=db.checkmail(s1);
                        if (checkemail==true){
                            Boolean insert =db.insert(s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"registred succefully",Toast.LENGTH_LONG);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"email exist",Toast.LENGTH_LONG);
                        }
                    }
                }
            }
        });
    }
}
