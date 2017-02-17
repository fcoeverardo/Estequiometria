package quimica.ufc.br.estequiometria.subjetcs;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject25Activity extends BasicActivity {

    TextView tv25_1, tv25_2, tv25_3, tv25_4, tv25_5,
            tv25_6, tv25_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject25);
        setUpToolbar(getResources().getStringArray(R.array.module2Topics)[4]);

        tv25_1 = (TextView) findViewById(R.id.tv25_1);
        tv25_2 = (TextView) findViewById(R.id.tv25_2);
        tv25_3 = (TextView) findViewById(R.id.tv25_3);
        tv25_4 = (TextView) findViewById(R.id.tv25_4);
        tv25_5 = (TextView) findViewById(R.id.tv25_5);
        tv25_6 = (TextView) findViewById(R.id.tv25_6);
        tv25_7 = (TextView) findViewById(R.id.tv25_7);

        tv25_1.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_1)));
        tv25_2.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_2)));
        tv25_3.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_3)));
        tv25_4.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_4)));
        tv25_5.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_5)));
        tv25_6.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_6)));
        tv25_7.setText(HtmlCompat.fromHtml(getString(R.string.m2t5_7)));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
