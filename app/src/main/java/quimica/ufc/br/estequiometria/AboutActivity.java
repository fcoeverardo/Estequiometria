package quimica.ufc.br.estequiometria;

import android.os.Bundle;
import android.widget.TextView;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class AboutActivity extends BasicActivity {

    TextView tvAbout1, tvAbout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setUpToolbar(getString(R.string.aboutActivity));

        tvAbout1 = (TextView) findViewById(R.id.tvAbout1);
        tvAbout2 = (TextView) findViewById(R.id.tvAbout2);

        tvAbout1.setText(HtmlCompat.fromHtml(getString(R.string.about1)));
        tvAbout2.setText(HtmlCompat.fromHtml(getString(R.string.about2)));

    }
}
