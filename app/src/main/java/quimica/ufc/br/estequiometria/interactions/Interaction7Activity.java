package quimica.ufc.br.estequiometria.interactions;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Interaction7Activity extends InteractionAcitivity {

    TextView tvInt71,tvInt72,tvCHKO,tvNaOH,tvResult,tvMolarNaOH,tvCHKOMass;
    EditText etMassCHKO,etVolNaOH;
    Button btCalc;

    double mCHKO,vNaOH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction7);


        tvInt71 = (TextView) findViewById(R.id.tvInt71);
        tvInt72 = (TextView) findViewById(R.id.tvInt72);
        tvCHKO = (TextView) findViewById(R.id.tvCHKO);
        tvCHKOMass = (TextView) findViewById(R.id.tvCHKOMass);
        tvNaOH = (TextView) findViewById(R.id.tvNaOH);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvMolarNaOH = (TextView) findViewById(R.id.tvMolarNaOH);

        etMassCHKO = (EditText) findViewById(R.id.etMassCHKO);
        etVolNaOH = (EditText) findViewById(R.id.etVolNaOH);

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.int7Title));

        tvInt71.setText(HtmlCompat.fromHtml(getString(R.string.tvInt71)));
        tvInt72.setText(HtmlCompat.fromHtml(getString(R.string.tvInt72)));
        tvResult.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));
        tvCHKOMass.setText(HtmlCompat.fromHtml(getString(R.string.tvMassCHKO)));

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);

                vNaOH = Double.parseDouble(etVolNaOH.getText().toString());
                mCHKO = Double.parseDouble(etMassCHKO.getText().toString());

                double nMols = mCHKO / 204.2;
                double mNaOH = nMols / (vNaOH / 1000);

                tvMolarNaOH.setText(HtmlCompat.fromHtml(getString(R.string.tvMolaridadeNaOH) + " " + convertBelowZero(mNaOH)));

            }
        });

    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
