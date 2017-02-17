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
import quimica.ufc.br.estequiometria.interactions.Interaction1Activity;

public class Subject21Activity extends BasicActivity {

    TextView tv21_1,tv21_2,tv21_3,tv21_4,tv21_5,tv21_6,
            tv21_7,tv21_8,tv21_9,tv21_10,tv21_11;

    Button btIntPer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject21);

        setUpToolbar(getResources().getStringArray(R.array.module2Topics)[0]);

        tv21_1 = (TextView) findViewById(R.id.tv21_1);
        tv21_2 = (TextView) findViewById(R.id.tv21_2);
        tv21_3 = (TextView) findViewById(R.id.tv21_3);
        tv21_4 = (TextView) findViewById(R.id.tv21_4);
        tv21_5 = (TextView) findViewById(R.id.tv21_5);
        tv21_6 = (TextView) findViewById(R.id.tv21_6);
        tv21_7 = (TextView) findViewById(R.id.tv21_7);
        tv21_8 = (TextView) findViewById(R.id.tv21_8);
        tv21_9 = (TextView) findViewById(R.id.tv21_9);
        tv21_10 = (TextView) findViewById(R.id.tv21_10);
        tv21_11 = (TextView) findViewById(R.id.tv21_11);

        tv21_1.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_1)));
        tv21_2.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_2)));
        tv21_3.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_3)));
        tv21_4.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_4)));
        tv21_5.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_5)));
        tv21_6.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_6)));
        tv21_7.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_7)));
        tv21_8.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_8)));
        tv21_9.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_9)));
        tv21_10.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_10)));
        tv21_11.setText(HtmlCompat.fromHtml(getString(R.string.m2t1_11)));

        btIntPer = (Button) findViewById(R.id.btIntPer);

        btIntPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject21Activity.this, Interaction14Activity.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
