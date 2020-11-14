package tn.karoui.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView txt;
    private EditText reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = (TextView) findViewById(R.id.txtView);
        reponse = (EditText) findViewById(R.id.txt2);

        Intent i = getIntent();
        String msg = i.getStringExtra("lfig3");
        txt.setVisibility(View.VISIBLE);
        txt.setText(msg);
    }

    public void LaunchReply(View v){
        String msgRep = reponse.getText().toString();
        Intent j = new Intent();
        j.putExtra("lfigRep",msgRep);
        if (msgRep.isEmpty()) {
            setResult(RESULT_CANCELED,j);
        }
        else {
            setResult(RESULT_OK,j);
        }
        finish();
        }



}