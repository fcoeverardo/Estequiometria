package quimica.ufc.br.estequiometria.subjetcs;

import android.os.Bundle;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Subject35Activity extends BasicActivity {

    TextView tv35_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject35);

        setUpToolbar(getResources().getStringArray(R.array.module3Topics)[4]);

        tv35_1 = (TextView) findViewById(R.id.tv35_1);

        tv35_1.setText(HtmlCompat.fromHtml(getString(R.string.m3t5_1)));

    }
}
