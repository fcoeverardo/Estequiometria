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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;

public class Interaction14Activity extends InteractionAcitivity {

    EditText etMass;
    TextView tvResult, tvMolarMass, tvNMols, tvPercFormula, tvMinFormula,tvMass;
    Button btCalc;

    double minPercent = 0.0;

    //DecimalFormat numberFormat = new DecimalFormat("#.00");
    DecimalFormat noFloat = new DecimalFormat("#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction14);

        etMass = (EditText) findViewById(R.id.etMass);

        tvMass = (TextView) findViewById(R.id.tvMass);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvMolarMass = (TextView) findViewById(R.id.tvMolarMass);
        tvNMols = (TextView) findViewById(R.id.tvNMols);
        tvPercFormula = (TextView) findViewById(R.id.tvPercFormula);
        tvMinFormula = (TextView) findViewById(R.id.tvMinFormula);

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.titleSub2));

        Bundle b = getIntent().getExtras();
        int value = 0;
        if(b != null)
            value = b.getInt("subject");

        if(value == 21){

            etMass.setVisibility(View.GONE);
            tvMass.setVisibility(View.GONE);
            tvMolarMass.setVisibility(View.GONE);
            tvNMols.setVisibility(View.GONE);
            tvMinFormula.setVisibility(View.GONE);
            btCalc.setVisibility(View.GONE);
            setUpToolbar(getResources().getString(R.string.titleSub2_1));

        }

        if(value == 22){

            etMass.setVisibility(View.GONE);
            tvMass.setVisibility(View.GONE);
            tvMolarMass.setVisibility(View.GONE);
            tvNMols.setVisibility(View.GONE);
            btCalc.setVisibility(View.GONE);
            setUpToolbar(getResources().getString(R.string.titleSub2_2));
        }

        setUpCustomKeyboard(textListener);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double mass = Double.parseDouble(etMass.getText().toString());
                tvNMols.setText(HtmlCompat.fromHtml(getString(R.string.tvNMols)+" "+convertBelowZero(mass/MOLAR_MASS)));
                tvMinFormula.setText(HtmlCompat.fromHtml(getString(R.string.tvMinFormula) + " " + minFormula()));

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
            if(!etFormula.getText().toString().equals("")){
                tvPercFormula.setText(HtmlCompat.fromHtml(getString(R.string.tvPercFormula) + " " + percentualFormula()));
                tvMinFormula.setText(HtmlCompat.fromHtml(getString(R.string.tvMinFormula) + " " + minFormula()));
            }

            else{
                tvPercFormula.setText(getString(R.string.tvPercFormula));
                tvMinFormula.setText(getString(R.string.tvMinFormula));
            }



        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private String percentualFormula(){

        String percentualFomula = "";
        Element element;
        ArrayList<String> elementName = new ArrayList<String>();
        ArrayList<Double> elementMass = new ArrayList<Double>();
        groupElements(elementName,elementMass);

        for(int i=0;i<elementName.size();i++){

            double mass = elementMass.get(i);

            double percentage = (((mass)/MOLAR_MASS)*100);
            String aux = (elementName.get(i) + "<small><sub>" +numberFormat.format(percentage) + "%</sub></small> ");
            percentualFomula += aux;

        }

        return percentualFomula;
    }

    private String minFormula(){

        String minFormula = "";
        String minFormula2 = "";
        boolean allDivisible = true;
        ArrayList<Integer> coeficients = new ArrayList<>();
        int min = 0;

        if(elements.size() > 0)
            min = elements.get(0).getNumber();

        for(int i=0;i<elements.size();i++)
            min = Math.min(elements.get(i).getNumber(),min);

        for(int i=0;i<elements.size();i++){

            if(elements.get(i).getNumber()%min != 0){
                allDivisible = false;
            }

            String aux;
            String aux2;

            if(elements.get(i).getNumber()/min == 1)
                aux = (elements.get(i).getName());
            else
                aux = (elements.get(i).getName() + "<small><sub>" + elements.get(i).getNumber()/min + "</sub></small> ");


            if(elements.get(i).getNumber() == 1)
                aux2 = (elements.get(i).getName());
            else
                aux2 = (elements.get(i).getName() + "<small><sub>" + elements.get(i).getNumber() + "</sub></small> ");

            minFormula += aux;
            minFormula2 += aux2;

        }

        if(allDivisible)
            return minFormula;
        else
            return  minFormula2;
        /*
        String minFormula = "";
        Element element;
        int min = 0;

        double percs[] = new double[elements.size()];

        if(elements.size() > 0)
            min = elements.get(0).getNumber();

        for(int i=0;i<elements.size();i++)
            min = Math.min(elements.get(i).getNumber(),min);

        for(int i=0;i<elements.size();i++){

            String aux;
            if(elements.get(i).getNumber()/min == 1)
                 aux = (elements.get(i).getName());
            else
                aux = (elements.get(i).getName() + "<small><sub>" + elements.get(i).getNumber()/min + "</sub></small> ");

            minFormula += aux;

        }
        return minFormula;*/
    }

    private void groupElements(ArrayList<String> elementName, ArrayList<Double> elementMass){

        for(int i = 0; i<elements.size();i++)
            if(elementName.indexOf(elements.get(i).getName()) == -1){
                elementName.add(elements.get(i).getName());
                elementMass.add(elements.get(i).getNumber() * elements.get(i).getMass());
            }

            else{
                int index = elementName.indexOf(elements.get(i).getName());
                elementMass.set(index,elementMass.get(index) + (elements.get(i).getNumber() * elements.get(i).getMass()));
            }

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
