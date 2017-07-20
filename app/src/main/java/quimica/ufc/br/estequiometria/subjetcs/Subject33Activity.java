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
import quimica.ufc.br.estequiometria.interactions.Interaction10Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction12Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction4Activity;

public class Subject33Activity extends BasicActivity {

    TextView tv33_1;
    Button btIntM3T3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject33);

        setUpToolbar(getResources().getStringArray(R.array.module3Topics)[2]);

        tv33_1 = (TextView) findViewById(R.id.tv33_1);

        btIntM3T3 = (Button) findViewById(R.id.btIntM3T3);

        tv33_1.setText(HtmlCompat.fromHtml(getString(R.string.m3t3_1)));

        btIntM3T3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chamar Interacao
                startActivity(new Intent(Subject33Activity.this, Interaction4Activity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
