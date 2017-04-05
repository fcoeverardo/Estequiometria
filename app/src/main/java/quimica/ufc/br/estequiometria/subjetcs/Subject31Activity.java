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
import quimica.ufc.br.estequiometria.interactions.MassaMolecularInteractionActivity;

public class Subject31Activity extends BasicActivity {

    TextView tv31_1,tv31_2,tv31_3,tv31_4,tv31_5,
            tv31_6,tv31_7,tv31_8,tv31_9,tv31_10,
            tv31_11,tv31_12,tv31_13,tv31_14,tv31_15,
            tv31_16,tv31_17,tv31_18,tv31_19,tv31_20,
            tv31_21,tv31_22,tv31_23,tv31_24,tv31_25,
            tv31_26;

    Button btInt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject31);

        btInt10 = (Button) findViewById(R.id.btInteraction10);

        tv31_1 = (TextView) findViewById(R.id.tv31_1);
        tv31_2 = (TextView) findViewById(R.id.tv31_2);
        tv31_3 = (TextView) findViewById(R.id.tv31_3);
        tv31_4 = (TextView) findViewById(R.id.tv31_4);
        tv31_5 = (TextView) findViewById(R.id.tv31_5);
        tv31_6 = (TextView) findViewById(R.id.tv31_6);
        tv31_7 = (TextView) findViewById(R.id.tv31_7);
        tv31_8 = (TextView) findViewById(R.id.tv31_8);
        tv31_9 = (TextView) findViewById(R.id.tv31_9);
        tv31_10 = (TextView) findViewById(R.id.tv31_10);
        tv31_11 = (TextView) findViewById(R.id.tv31_11);
        tv31_12 = (TextView) findViewById(R.id.tv31_12);
        tv31_13 = (TextView) findViewById(R.id.tv31_13);
        tv31_14 = (TextView) findViewById(R.id.tv31_14);
        tv31_15 = (TextView) findViewById(R.id.tv31_15);
        tv31_16 = (TextView) findViewById(R.id.tv31_16);
        tv31_17 = (TextView) findViewById(R.id.tv31_17);
        tv31_18 = (TextView) findViewById(R.id.tv31_18);
        tv31_19 = (TextView) findViewById(R.id.tv31_19);
        tv31_20 = (TextView) findViewById(R.id.tv31_20);
        tv31_21 = (TextView) findViewById(R.id.tv31_21);
        tv31_22 = (TextView) findViewById(R.id.tv31_22);
        tv31_23 = (TextView) findViewById(R.id.tv31_23);
        tv31_24 = (TextView) findViewById(R.id.tv31_24);
        tv31_25 = (TextView) findViewById(R.id.tv31_25);
        tv31_26 = (TextView) findViewById(R.id.tv31_26);

        tv31_1.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_1)));

        tv31_2.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_2)));
        tv31_3.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_3)));
        tv31_4.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_4)));
        tv31_5.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_5)));

        tv31_6.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_6)));
        tv31_7.setText(getString(R.string.m3t1_7));
        tv31_8.setText(getString(R.string.m3t1_8));
        tv31_9.setText(getString(R.string.m3t1_9));

        tv31_10.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_10)));
        tv31_11.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_11)));
        tv31_12.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_12)));
        tv31_13.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_13)));

        tv31_14.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_14)));
        tv31_15.setText(getString(R.string.m3t1_15));
        tv31_16.setText(getString(R.string.m3t1_16));
        tv31_17.setText(getString(R.string.m3t1_17));

        tv31_18.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_18)));
        tv31_19.setText(getString(R.string.m3t1_19));
        tv31_20.setText(getString(R.string.m3t1_20));
        tv31_21.setText(getString(R.string.m3t1_21));

        tv31_22.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_22)));
        tv31_23.setText(getString(R.string.m3t1_23));
        tv31_24.setText(getString(R.string.m3t1_24));
        tv31_25.setText(getString(R.string.m3t1_25));

        tv31_26.setText(HtmlCompat.fromHtml(getString(R.string.m3t1_26)));

        btInt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject31Activity.this, Interaction10Activity.class));
            }
        });


        setUpToolbar(getResources().getStringArray(R.array.module3Topics)[0]);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
