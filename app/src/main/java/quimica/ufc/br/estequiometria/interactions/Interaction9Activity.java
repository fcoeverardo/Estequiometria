package quimica.ufc.br.estequiometria.interactions;

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

public class Interaction9Activity extends InteractionAcitivity {

    private TextView tvInt91, tvInt92,
                     tvInt93, tvInt94,
                     tvInt95, tvInt96,
                     tvKO2Mass, tvResults, tvResult;
    private EditText etKO2Mass;
    private Button btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction9);


        tvInt91 = (TextView) findViewById(R.id.tvInt91);
        tvInt92 = (TextView) findViewById(R.id.tvInt92);
        tvInt93 = (TextView) findViewById(R.id.tvInt93);
        tvInt94 = (TextView) findViewById(R.id.tvInt94);
        tvInt95 = (TextView) findViewById(R.id.tvInt95);
        tvInt96 = (TextView) findViewById(R.id.tvInt96);
        tvKO2Mass = (TextView) findViewById(R.id.tvKO2Mass);
        tvResults = (TextView) findViewById(R.id.tvResults);
        tvResult = (TextView) findViewById(R.id.tvResult);

        etKO2Mass = (EditText) findViewById(R.id.etKO2Mass);

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.int9Title));

        tvInt91.setText(HtmlCompat.fromHtml(getString(R.string.tvInt91)));
        tvInt92.setText(HtmlCompat.fromHtml(getString(R.string.tvInt92)));
        tvInt93.setText(HtmlCompat.fromHtml(getString(R.string.tvInt93)));
        tvInt94.setText(HtmlCompat.fromHtml(getString(R.string.tvInt94)));
        tvInt95.setText(HtmlCompat.fromHtml(getString(R.string.tvInt95)));
        tvInt96.setText(HtmlCompat.fromHtml(getString(R.string.tvInt96)));
        tvKO2Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvKO2Mass)));
        tvResults.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);

                double ma = Double.parseDouble(etKO2Mass.getText().toString());

                double molA = ma /56.1;
                double mc = 0.25*molA*44;
                double mb = 0.75*molA*32;

                tvResult.setText(HtmlCompat.fromHtml(String.format(getString(R.string.tvInt9Result), formatFloat(mc), formatFloat(mb))));


            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
