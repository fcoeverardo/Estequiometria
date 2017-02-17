package quimica.ufc.br.estequiometria.subjetcs;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject11Activity extends BasicActivity {

    private TextView tv11_1,tv11_2,tv11_3;
    private Resources resources;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject11);

        tv11_1 = (TextView) findViewById(R.id.tv11_1);
        tv11_2 = (TextView) findViewById(R.id.tv11_2);
        tv11_3 = (TextView) findViewById(R.id.tv11_3);

        tv11_1.setText(HtmlCompat.fromHtml(getString(R.string.m1t1_1)));
        tv11_2.setText(HtmlCompat.fromHtml(getString(R.string.m1t1_2)));
        tv11_3.setText(HtmlCompat.fromHtml(getString(R.string.m1t1_3)));

        resources = getResources();

        title = resources.getStringArray(R.array.module1Topics)[0];

        setUpToolbar(title);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
