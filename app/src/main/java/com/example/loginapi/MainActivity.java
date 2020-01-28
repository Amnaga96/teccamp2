package com.example.loginapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
EditText emailEditText;
EditText passwordEditText;
    String url = "http://192.168.1.105/phy/public/api/user/auth/login?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
    }

    public void login(View view) {
     String email= emailEditText.getText().toString();
     String password= passwordEditText.getText().toString();
     String AuthUlr = url + "email=" + email + "&password=" + password;

        RequestQueue  requestqueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, AuthUlr, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parseJson(response);
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error.networkResponse == null){
                    error.printStackTrace();
                    Toast.makeText(MainActivity.this, "error timeot", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this, "Auth error" + error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
                }

            }
        });
    requestqueue.add(request);


    }
    //private void parseJson(String response){}

}
