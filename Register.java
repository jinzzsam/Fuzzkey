package com.example.nelson.fuzzydb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button reg;
    EditText pwd,cpwd,email,userid;
    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg= (Button) findViewById(R.id.reg);
        pwd= (EditText) findViewById(R.id.pwd);
        cpwd= (EditText) findViewById(R.id.cpwd);
        email= (EditText) findViewById(R.id.email);
        userid= (EditText) findViewById(R.id.uid);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag=false;
                boolean flag2=false;

                String username = userid.getText().toString();
                String password = pwd.getText().toString();
                String cpassword = cpwd.getText().toString();
                String emailid = email.getText().toString();

                flag= passwordValidation(username,password,cpassword,emailid);

                if(flag==true)
                {
                        Contact c=new Contact();

                        c.setPass(password);
                        c.setUid(username);
                        c.setEmail(emailid);

                    helper.insertData(c);



                        Toast.makeText(Register.this, "Registration successful.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                        // Closing regstration screen
                        // Switching to Login Screen/closing register screen
                        finish();

                     }

                else
                    Toast.makeText(Register.this, "Registration unsuccessful.", Toast.LENGTH_SHORT).show();




            }
            /*public void AddData()
            {
                boolean flag2=false;
                flag2=insertData(usern,email,pwd);

            }*/

            public boolean passwordValidation(String username, String password, String cpassword, String email)
            {
                boolean valid = true;

                if (username.length()<3)
                {
                    Toast.makeText(Register.this, "Username should be more than 3 characters in length.", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (password.length() > 15 || password.length() < 8)
                {
                    Toast.makeText(Register.this, "Password should be less than 15 and more than 8 characters in length.", Toast.LENGTH_LONG).show();
                    return false;
                }

                String upperCaseChars = "(.*[A-Z].*)";
                if (!password.matches(upperCaseChars ))
                {
                    Toast.makeText(Register.this, "Password should contain atleast one upper case alphabet.", Toast.LENGTH_LONG).show();
                    return false;
                }
                String lowerCaseChars = "(.*[a-z].*)";
                if (!password.matches(lowerCaseChars ))
                {
                    Toast.makeText(Register.this, "Password should contain atleast one lower case alphabet.", Toast.LENGTH_LONG).show();
                    return false;
                }
                String numbers = "(.*[0-9].*)";
                if (!password.matches(numbers ))
                {
                    Toast.makeText(Register.this, "Password should contain atleast one number.", Toast.LENGTH_LONG).show();
                    return false;
                }
                String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
                if (!password.matches(specialChars ))
                {
                    Toast.makeText(Register.this, "Password should contain atleast one special character.", Toast.LENGTH_LONG).show();
                    return false;
                }

                if( !password.matches(cpassword ))
                {
                    Toast.makeText(Register.this, "Passwords dont match.", Toast.LENGTH_LONG).show();
                    return false;
                }
                if(username == "" && password == "" && cpassword == "" && email =="")
                {
                    Toast.makeText(Register.this, "Missing field", Toast.LENGTH_LONG).show();
                    return false;



                }


                return valid;


            }




        });




}

}
