package quimica.ufc.br.estequiometria.subjetcs;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject22Activity extends BasicActivity {


    TextView tv22_1,tv22_2,tv22_3,tv22_4,
            tv22_5,tv22_6,tv22_7,tv22_8,tv22_9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject22);

        setUpToolbar(getResources().getStringArray(R.array.module2Topics)[1]);


        tv22_1 = (TextView) findViewById(R.id.tv22_1);
        tv22_2 = (TextView) findViewById(R.id.tv22_2);
        tv22_3 = (TextView) findViewById(R.id.tv22_3);
        tv22_4 = (TextView) findViewById(R.id.tv22_4);
        tv22_5 = (TextView) findViewById(R.id.tv22_5);
        tv22_6 = (TextView) findViewById(R.id.tv22_6);
        tv22_7 = (TextView) findViewById(R.id.tv22_7);
        tv22_8 = (TextView) findViewById(R.id.tv22_8);
        tv22_9 = (TextView) findViewById(R.id.tv22_9);

        tv22_1.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_1)));
        tv22_2.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_2)));
        tv22_3.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_3)));
        tv22_4.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_4)));
        tv22_5.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_5)));
        tv22_6.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_6)));
        tv22_7.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_7)));
        tv22_8.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_8)));
        tv22_9.setText(HtmlCompat.fromHtml(getString(R.string.m2t2_9)));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
