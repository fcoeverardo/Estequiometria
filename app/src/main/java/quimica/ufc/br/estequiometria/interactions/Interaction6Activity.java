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

public class Interaction6Activity extends InteractionAcitivity {

    //Toolbar toolbar;
    TextView tvInt61, tvInt62,tvHCl,tvNaOH,tvResults,tvNMolsHCl,tvMHCl;
    EditText etVolHCl,etVolNaOH,etMolarNaOH;
    Button btCalc;

    double vHCl, vNaOh, mNaOh,nMols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction6);


        tvInt61 = (TextView) findViewById(R.id.tvInt61);
        tvInt62 = (TextView) findViewById(R.id.tvInt62);
        tvHCl = (TextView) findViewById(R.id.tvHCl);
        tvNaOH = (TextView) findViewById(R.id.tvNaOH);
        tvResults = (TextView) findViewById(R.id.tvResults);
        tvNMolsHCl = (TextView) findViewById(R.id.tvNMolsHCl);
        tvMHCl = (TextView) findViewById(R.id.tvMHCl);

        etVolHCl = (EditText) findViewById(R.id.etVolHCl);
        etVolNaOH = (EditText) findViewById(R.id.etVolNaOH);
        etMolarNaOH = (EditText) findViewById(R.id.etMolarNaOH);

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.int6Title));


        tvInt61.setText(HtmlCompat.fromHtml(getString(R.string.tvInt61)));
        tvInt62.setText(HtmlCompat.fromHtml(getString(R.string.tvInt62)));
        tvHCl.setText(HtmlCompat.fromHtml(getString(R.string.tvHcl)));
        tvNaOH.setText(HtmlCompat.fromHtml(getString(R.string.tvNaOH)));
        tvResults.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));


        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);

                vHCl = Double.parseDouble(etVolHCl.getText().toString());
                vNaOh = Double.parseDouble(etVolNaOH.getText().toString());
                mNaOh = Double.parseDouble(etMolarNaOH.getText().toString());

                nMols = mNaOh * (vNaOh/1000);

                tvNMolsHCl.setText(HtmlCompat.fromHtml(getString(R.string.tvNMolsHCl) + " " + convertBelowZero(nMols)));
                tvMHCl.setText(HtmlCompat.fromHtml(getString(R.string.tvMolaridadeHCl) + " " + convertBelowZero(nMols / (vHCl / 1000))));

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
