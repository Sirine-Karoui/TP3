package tn.karoui.tp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText msgTxt;
    private TextView HeaderMsg;
    private TextView ReponseMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTxt = (EditText) findViewById(R.id.txt1);
        HeaderMsg = (TextView) findViewById(R.id.msg_header);
        ReponseMsg = (TextView) findViewById(R.id.msg_reponse);
    }

    public void LaunchActivity(View v){
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        String msg = msgTxt.getText().toString();
        i.putExtra("lfig3",msg);
        startActivityForResult(i,3);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 3) {
            if (resultCode == RESULT_OK)
            {
                String reply = i.getStringExtra("lfigRep");
                ReponseMsg.setVisibility(View.VISIBLE);
                ReponseMsg.setText(reply);
                HeaderMsg.setVisibility(View.VISIBLE);
                HeaderMsg.setText("Message Reçu");
            }else Toast.makeText(getApplicationContext(), "chaine vide", Toast.LENGTH_LONG).show();
        }
    }
}