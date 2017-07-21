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
import quimica.ufc.br.estequiometria.interactions.Interaction5Activity;

public class Subject41Activity extends BasicActivity {

    TextView tv41;

    Button btIntm4t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject41);

        setUpToolbar(getResources().getStringArray(R.array.module4Topics)[0]);

        tv41 = (TextView) findViewById(R.id.tv41);

        tv41.setText(HtmlCompat.fromHtml(getString(R.string.m4t1)));

        btIntm4t1 = (Button) findViewById(R.id.btIntm4t1);


        btIntm4t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject41Activity.this, Interaction5Activity.class));
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
