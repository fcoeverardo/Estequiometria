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
import quimica.ufc.br.estequiometria.interactions.Interaction14Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction15Activity;

public class Subject24Activity extends BasicActivity {

    TextView tv24_1;
    Button btIntM2T4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject24);

        setUpToolbar(getResources().getStringArray(R.array.module2Topics)[3]);

        tv24_1 = (TextView) findViewById(R.id.tv24_1);
        tv24_1.setText(HtmlCompat.fromHtml(getString(R.string.m2t4_1)));

        btIntM2T4 = (Button) findViewById(R.id.btIntM2T4);
        btIntM2T4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject24Activity.this, Interaction15Activity.class));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
