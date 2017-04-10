package quimica.ufc.br.estequiometria.subjetcs;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.interactions.Interaction3Activity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;

public class Subject15Activity extends BasicActivity {

    TextView tv15_1;
    Button btInt3;
    Resources resources;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject15);

        tv15_1 = (TextView) findViewById(R.id.tv15_1);
        tv15_1.setText(HtmlCompat.fromHtml(getString(R.string.m1t5_1)));

        btInt3 = (Button) findViewById(R.id.btInteraction3);

        resources = getResources();

        title = resources.getStringArray(R.array.module1Topics)[4];

        setUpToolbar(title);

       btInt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Subject15Activity.this, Interaction3Activity.class);

                Bundle b = new Bundle();
                b.putInt("subject", 15); //Your id
                i.putExtras(b);

                startActivity(i);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
