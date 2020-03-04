package com.example.datatransfertoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button btnSend;

    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.edt_nama);
        btnSend = (Button) findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String nama = name.getText().toString();
                    if ( nama!=null && !nama.isEmpty() && !nama.equals("null") ){
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);

                    } else {
                        Toast.makeText(MainActivity.this, "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT);
                    }

                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "ERROR, TRY AGAIN !", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT);
                }

            }
        });
    }
}