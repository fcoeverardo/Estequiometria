package quimica.ufc.br.estequiometria.subjetcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.interactions.Interaction11Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction13Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction14Activity;

public class Subject34Activity extends BasicActivity {

    TextView tv34_1;

    Button btIntm3t4, btIntm3t42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject34);

        setUpToolbar(getResources().getStringArray(R.array.module3Topics)[3]);

        tv34_1 = (TextView) findViewById(R.id.tv34_1);

        tv34_1.setText(HtmlCompat.fromHtml(getString(R.string.m3t4_1)));

        btIntm3t4 = (Button) findViewById(R.id.btIntm3t4);
        btIntm3t42 = (Button) findViewById(R.id.btIntm3t42);

        btIntm3t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject34Activity.this, Interaction13Activity.class));
            }
        });

        btIntm3t42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject34Activity.this, Interaction11Activity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
