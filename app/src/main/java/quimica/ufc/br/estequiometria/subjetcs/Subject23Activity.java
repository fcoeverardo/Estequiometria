package quimica.ufc.br.estequiometria.subjetcs;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject23Activity extends BasicActivity {

    TextView tv23_1,tv23_2,tv23_3,tv23_4,
            tv23_5,tv23_6,tv23_7,tv23_75,tv23_8,tv23_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject23);

        setUpToolbar(getResources().getStringArray(R.array.module2Topics)[2]);

        tv23_1 = (TextView) findViewById(R.id.tv23_1);
        tv23_2 = (TextView) findViewById(R.id.tv23_2);
        tv23_3 = (TextView) findViewById(R.id.tv23_3);
        tv23_4 = (TextView) findViewById(R.id.tv23_4);
        tv23_5 = (TextView) findViewById(R.id.tv23_5);
        tv23_6 = (TextView) findViewById(R.id.tv23_6);
        tv23_7 = (TextView) findViewById(R.id.tv23_7);
        tv23_75 = (TextView) findViewById(R.id.tv23_7_5);
        tv23_8 = (TextView) findViewById(R.id.tv23_8);
        tv23_9 = (TextView) findViewById(R.id.tv23_9);

        tv23_1.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_1)));
        tv23_2.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_2)));
        tv23_3.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_3)));
        tv23_4.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_4)));
        tv23_5.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_5)));
        tv23_6.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_6)));
        tv23_7.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_7)));
        tv23_75.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_7_5)));
        tv23_8.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_8)));
        tv23_9.setText(HtmlCompat.fromHtml(getString(R.string.m2t3_9)));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
