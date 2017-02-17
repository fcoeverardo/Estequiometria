package quimica.ufc.br.estequiometria.interactions;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;

public class Interaction3Activity extends InteractionAcitivity {

    ArrayAdapter<String> elementAdapter;


    EditText etMass;
    TextView tvMolarMass, tvNMols, tvDescInt3;
    Button btCalc;

    String currentResult = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction3);

        etMass = (EditText) findViewById(R.id.etMass);

        tvMolarMass = (TextView) findViewById(R.id.tvMolarMass);
        tvNMols = (TextView) findViewById(R.id.tvNMols);
        tvDescInt3 = (TextView) findViewById(R.id.tvDescInt3);

        tvDescInt3.setText(HtmlCompat.fromHtml(getString(R.string.tvDescInt3)));

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.int1Name));

        setUpCustomKeyboard(textListener);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);

                double mass = Double.parseDouble(etMass.getText().toString());

                tvNMols.setText(HtmlCompat.fromHtml(getString(R.string.tvNMols)+" "+(convertBelowZero(mass/MOLAR_MASS))));

            }
        });

    }

    TextWatcher textListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            defaultFormulaAction();
            tvMolarMass.setText(getString(R.string.tvMolarMass)+" "+ numberFormat.format(MOLAR_MASS));

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onBackPressed() {
        hideCustomKeyboardIfVisible();
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