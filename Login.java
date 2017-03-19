package com.example.nelson.fuzzydb;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login, forgotPassword;
    EditText userid,password;
    DatabaseHelper helper=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            login= (Button) findViewById(R.id.login);
            forgotPassword= (Button) findViewById(R.id.forgot);
            userid= (EditText) findViewById(R.id.userid);
            password= (EditText) findViewById(R.id.pwd);

            login.setOnClickListener(new View.OnClickListener()
                                     {
                                         @Override
                                         public void onClick(View v) {
                                             String Userid = userid.getText().toString();
                                             String pwd = password.getText().toString();


                                             String pass=helper.searchPass(Userid);

                                             if (pass.equals(pwd))
                                             {
                                                 Intent i = new Intent(getApplicationContext(), Applist.class);
                                                 i.putExtra("Username",Userid);
                                                 startActivity(i);
                                                 // Closing regstration screen
                                                 // Switching to Login Screen/closing register screen


                                             }

                                             else

                                             {Toast.makeText(Login.this, "Invalid Credentials",Toast.LENGTH_SHORT).show();}





                                             //    Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();

                                                 // Toast.makeText(Login.this, "Registration successful.", Toast.LENGTH_SHORT).show();




                                         }
                                     }



            );





        }
}
