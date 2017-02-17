package quimica.ufc.br.estequiometria.subjetcs;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;
import quimica.ufc.br.estequiometria.R;

public class Subject16Activity extends InteractionAcitivity {


    String currentResult = "";

    TextView tvResult,tvNMols;
    EditText etMass;
    Button btCalc;
    Resources resources;
    String title;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject16);

        resources = getResources();

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvNMols = (TextView) findViewById(R.id.tvNMols);
        etMass = (EditText) findViewById(R.id.etMass);
        btCalc = (Button) findViewById(R.id.btCalc);
        title = resources.getStringArray(R.array.module1Topics)[5];
        setUpToolbar(title);

        setUpCustomKeyboard();

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mass = Double.parseDouble(etMass.getText().toString());
                tvNMols.setText(HtmlCompat.fromHtml(getString(R.string.tvNMols)+" "+ convertBelowZero(mass  / MOLAR_MASS)));

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
