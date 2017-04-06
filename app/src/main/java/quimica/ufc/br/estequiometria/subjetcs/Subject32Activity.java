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
import quimica.ufc.br.estequiometria.interactions.Interaction12Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction4Activity;

public class Subject32Activity extends BasicActivity {

    TextView tv32_1,tv32_2;
    Button btM3T2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject32);

        setUpToolbar(getResources().getStringArray(R.array.module3Topics)[1]);

        tv32_1 = (TextView) findViewById(R.id.tv32_1);
        tv32_2 = (TextView) findViewById(R.id.tv32_2);

        btM3T2 = (Button) findViewById(R.id.btIntM3T2);

        tv32_1.setText(HtmlCompat.fromHtml(getString(R.string.m3t2_1)));
        tv32_2.setText(HtmlCompat.fromHtml(getString(R.string.m3t2_11)));

        btM3T2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chamar Interacao correta
                Intent i = new Intent(Subject32Activity.this, Interaction12Activity.class);

                Bundle b = new Bundle();
                b.putInt("subject", 32); //Your id
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
