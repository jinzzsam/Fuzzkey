package com.example.mansi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;


public class Password extends Activity{
	private EditText pet1;
	private Button pbt1;
	
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password);
		
		addListenerOnButton();
		
	  }
	  
	  public void addListenerOnButton(){
		  pet1 =(EditText)findViewById(R.id.pet1);
		  pbt1 =(Button)findViewById(R.id.pbt1);
		  
			pbt1.setOnClickListener(new OnClickListener() {

				
				@Override
				public void onClick(View v) {
					
					if(pet1.getText().toString().length() < 8 || pet1.getText().toString().length() > 15 ){
				        Toast.makeText(getApplicationContext(), "Password length should be more than 8 and less than 15 characters!",Toast.LENGTH_SHORT).show();

					            }
					else if(!isValidPassword(pet1.getText().toString())){
				        Toast.makeText(getApplicationContext(), "Password should contain atleast 1 number, 1 uppercase alphabet and 1 special character!",
				        		Toast.LENGTH_LONG).show();

					}
					else{

					        Toast.makeText(getApplicationContext(), "Saved Successfully!",Toast.LENGTH_SHORT).show();
					}
				}
					private boolean isValidPassword(final String pet1) {

					    Pattern pattern;
					    Matcher matcher;
					    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
					    pattern = Pattern.compile(PASSWORD_PATTERN);
					    matcher = pattern.matcher(pet1);

					    return matcher.matches();

					}

				

			});
			
			
	  }

}
