package quimica.ufc.br.estequiometria.interactions;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Interaction5Activity extends InteractionAcitivity {


    EditText etMass,etVolSol, etPurity,etDensSolu;
    TextView tvResult, tvMolarMass, tvNMols, tvMol,tvMol2,tvmm,tvmv,tvvv;
    Button btCalc;
    RadioButton rbSolid, rbLiquid;
    LinearLayout densSolu;
    RadioGroup estate,solvent;

    double density[] = { 1, 0.789 , 0.8765 , 1.05 };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction5);

        etMass = (EditText) findViewById(R.id.etMass);
        etVolSol = (EditText) findViewById(R.id.etVolSol);
        etPurity = (EditText) findViewById(R.id.etPurity);
        etDensSolu = (EditText) findViewById(R.id.etDensSolu);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvMolarMass = (TextView) findViewById(R.id.tvMolarMass);
        tvNMols = (TextView) findViewById(R.id.tvNMols);
        tvMol = (TextView) findViewById(R.id.tvMol);
        tvMol2 = (TextView) findViewById(R.id.tvMol2);
        tvmm = (TextView) findViewById(R.id.tvmm);
        tvmv = (TextView) findViewById(R.id.tvmv);
        tvvv = (TextView) findViewById(R.id.tvvv);

        btCalc = (Button) findViewById(R.id.btCalc);

        rbLiquid = (RadioButton) findViewById(R.id.rbLiquid);
        rbSolid = (RadioButton) findViewById(R.id.rbSolid);

        densSolu = (LinearLayout) findViewById(R.id.densSoluLayout);

        estate = (RadioGroup) findViewById(R.id.radioGroupEstate);
        solvent = (RadioGroup) findViewById(R.id.radioGroupSolvent);

        setUpToolbar(getString(R.string.titleInt5));

        setUpCustomKeyboard(textListener);




        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);


                //int estateIndex = estate.indexOfChild(estate.findViewById(estate.getCheckedRadioButtonId()));
                int solventIndex = solvent.indexOfChild(solvent.findViewById(solvent.getCheckedRadioButtonId()));

                if(!rbLiquid.isChecked()){

                    double densidade = density[solventIndex];
                    double mass = Double.parseDouble(etMass.getText().toString());

                    double vSolucao = Double.parseDouble(etVolSol.getText().toString());
                    double purity = Double.parseDouble(etPurity.getText().toString());

                    purity = purity / 100;
                    double m1 = mass * purity;
                    double nmoles = m1 / MOLAR_MASS;
                    double m2 = 1000 * nmoles / vSolucao;
                    double kgsol = vSolucao * densidade / 1000;
                    double w2 = nmoles / kgsol;
                    double msolvente = densidade * vSolucao;
                    double pp2 = 100 * m1 / (msolvente + m1);
                    double pv2 = 100 * m1 / (msolvente + m1);
                    String vv2 = "------";

                    tvMol.setText(getString(R.string.tvMol) + " " + numberFormat.format(m2));
                    tvMol2.setText(getString(R.string.tvMol2) + " " + numberFormat.format(w2));
                    tvmm.setText(getString(R.string.tvmm) + " " + numberFormat.format(pp2));
                    tvmv.setText(getString(R.string.tvmv) + " " + numberFormat.format(pv2));
                    tvvv.setText(getString(R.string.tvvv) + " " + vv2);

                }


                else{
 /*
                    double densidade = density[solventIndex];
                    double mass = Double.parseDouble(etMass.getText().toString());

                    double vSolucao = Double.parseDouble(etVolSol.getText().toString());
                    double purity = Double.parseDouble(etPurity.getText().toString());

                    purity = purity / 100;

                    double densidade_soluto = Double.parseDouble(etDensSolu.getText().toString());
                    double mSoluto = mass * densidade_soluto;

                    vSolucao = vSolucao + mass;

                    double m1 = mass * purity;
                    double nmoles = m1 / MOLAR_MASS;
                    double m2 = 1000 * nmoles / vSolucao;
                    double kgsol = vSolucao * densidade / 1000;
                    double w2 = nmoles / kgsol;
                    double msolvente = densidade * vSolucao;
                    double pp2 = 100 * m1 / (msolvente + m1);
                    double pv2 = 100 * m1 / (msolvente + m1);
                    String vv2 = "------";*/
                }
                /*
                hideKeyboard(v);



                double mass = Double.parseDouble(etMass.getText().toString());

                double vSolucao = Double.parseDouble(etVolSol.getText().toString());
                double purity = Double.parseDouble(etPurity.getText().toString());

                if (rbSolid.isChecked() && rbWater.isChecked()) {

                    if(rbWater.isChecked()){

                    }
                    int densidade = 1;
                    purity = purity / 100;
                    double m1 = mass * purity;
                    double nmoles = m1 / MOLAR_MASS;
                    double m2 = 1000 * nmoles / vSolucao;
                    double kgsol = vSolucao * densidade / 1000;
                    double w2 = nmoles / kgsol;
                    double msolvente = densidade * vSolucao;
                    double pp2 = 100 * m1 / (msolvente + m1);
                    double pv2 = 100 * m1 / (msolvente + m1);
                    String vv2 = "------";

                    tvMol.setText(getString(R.string.tvMol) + " " + numberFormat.format(m2));
                    tvMol2.setText(getString(R.string.tvMol2) + " " + numberFormat.format(w2));
                    tvmm.setText(getString(R.string.tvmm) + " " + numberFormat.format(pp2));
                    tvmv.setText(getString(R.string.tvmv) + " " + numberFormat.format(pv2));
                    tvvv.setText(getString(R.string.tvvv) + " " + vv2);

                }*/
            }
        });

        rbLiquid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {




                if(isChecked)
                    densSolu.setVisibility(View.VISIBLE);

                else
                    densSolu.setVisibility(View.GONE);
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
            //tvMolarMass.setText(getString(R.string.tvMolarMass)+" "+ numberFormat.format(MOLAR_MASS));

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
