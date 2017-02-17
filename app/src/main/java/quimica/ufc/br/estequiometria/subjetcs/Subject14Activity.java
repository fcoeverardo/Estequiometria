package quimica.ufc.br.estequiometria.subjetcs;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject14Activity extends BasicActivity {

    TextView tv14_1;
    Resources resources;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject14);

        tv14_1 = (TextView) findViewById(R.id.tv14_1);
        tv14_1.setText(HtmlCompat.fromHtml(getString(R.string.m1t4_1)));

        resources = getResources();

        title = resources.getStringArray(R.array.module1Topics)[3];

        setUpToolbar(title);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
