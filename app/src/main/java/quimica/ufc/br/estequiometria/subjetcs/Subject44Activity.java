package quimica.ufc.br.estequiometria.subjetcs;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject44Activity extends BasicActivity {

    TextView tv43;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject44);

        setUpToolbar(getResources().getStringArray(R.array.module4Topics)[0]);

        tv43 = (TextView) findViewById(R.id.tv43);

        tv43.setText(HtmlCompat.fromHtml(getString(R.string.m4t3)));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
