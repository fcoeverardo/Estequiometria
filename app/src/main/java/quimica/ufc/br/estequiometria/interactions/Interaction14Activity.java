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

import java.text.DecimalFormat;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;

public class Interaction14Activity extends InteractionAcitivity {

    EditText etMass;
    TextView tvResult, tvMolarMass, tvNMols, tvPercFormula, tvMinFormula;
    Button btCalc;

    double minPercent = 0.0;

    //DecimalFormat numberFormat = new DecimalFormat("#.00");
    DecimalFormat noFloat = new DecimalFormat("#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction14);

        etMass = (EditText) findViewById(R.id.etMass);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvMolarMass = (TextView) findViewById(R.id.tvMolarMass);
        tvNMols = (TextView) findViewById(R.id.tvNMols);
        tvPercFormula = (TextView) findViewById(R.id.tvPercFormula);
        tvMinFormula = (TextView) findViewById(R.id.tvMinFormula);

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.titleSub2));


        setUpCustomKeyboard(textListener);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mass = Double.parseDouble(etMass.getText().toString());
                tvNMols.setText(HtmlCompat.fromHtml(getString(R.string.tvNMols)+" "+convertBelowZero(mass/MOLAR_MASS)));

                tvMinFormula.setText(HtmlCompat.fromHtml(getString(R.string.tvMinFormula) + " " +minFormula(mass)));

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
            tvPercFormula.setText(getString(R.string.tvPercFormula) + " " + percentualFormula());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private String percentualFormula(){
        String result = "";
        Element element;

        for(int i=0;i<elements.size();i++){
            element = elements.get(i);
            double percentage = (((element.getNumber() * element.getMass())/MOLAR_MASS)*100);

            result += element.getName() + " " + noFloat.format(percentage) + "% ";
        }

        return result;
    }

    private String minFormula(double mass){
        String result = "";
        Element element;

        double percs[] = new double[elements.size()];


        for(int i=0;i<elements.size();i++){
            element = elements.get(i);

            //Log.d(MainActivity.TAG, "perc: "+(((element.getNumber() * element.getMass())/Element.MOLARMASS)*100));

            double percentage = ((((element.getNumber() * element.getMass())/Element.MOLARMASS)*mass)/element.getMass());

            percs[i] = percentage;

            if(i==0) {
                minPercent = percentage;
            }else if(percentage<minPercent){
                minPercent = percentage;
            }
        }

        Log.d(MainActivity.TAG,"minpercent: "+minPercent);
        //Log.d(MainActivity.TAG,"percentage Array: "+"["+percs[0]+", "+percs[1]+", "+percs[2]+"]");

        for(int i=0;i<percs.length;i++){

            element = elements.get(i);
            result += element.getName() + "<sub><small>" +  noFloat.format(percs[i]/minPercent) + "</sub></small>";
        }

        return result;
    }

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
