package com.abdur.applicationsqlite_abdurrahman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
//        getSupportActionBar().setTitle("Selamat Datang Pendidikan Ra Genah");
    }
    public void onButtonClick (View v)
    {
        if (v.getId()==R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.TFusername);
            EditText b = (EditText) findViewById(R.id.TFpassword);
            String str = a.getText().toString();
            String pass = b.getText().toString();
            String password = helper.searchPass(str);
            if (a.length() == 0 && b.length() == 0) {
                a.setError("Mohon di isi");
                b.setError("Mohon di isi");
            } else if (a.length() == 0) {
                a.setError("Mohon di isi");
            } else if (b.length() == 0) {
                b.setError("Mohon di isi");
            } else if (pass.equals(password)) {
                Intent i = new Intent(Login.this, Menu.class);
                startActivity(i);
            } else {
                Toast.makeText(Login.this, "Password don't match", Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId()==R.id.bregister)
        {
            Intent i = new Intent(Login.this, RegisterActivity.class);
            startActivity(i);
        }

    }
}
