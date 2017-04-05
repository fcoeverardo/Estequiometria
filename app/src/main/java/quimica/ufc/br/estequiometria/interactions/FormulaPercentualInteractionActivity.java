package quimica.ufc.br.estequiometria.interactions;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;
import quimica.ufc.br.estequiometria.parser.Evaluator;

public class FormulaPercentualInteractionActivity extends InteractionAcitivity {

    EditText etMass;
    TextView tvMolarMass, tvNMols, tvPercFormula, tvMinFormula,tvMass;
    Button btCalc;
    private Evaluator eval;

    double minPercent = 0.0;

    //DecimalFormat numberFormat = new DecimalFormat("#.00");
    DecimalFormat noFloat = new DecimalFormat("#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction14);

        etMass = (EditText) findViewById(R.id.etMass);
        etMass.setVisibility(View.GONE);

        tvMass = (TextView) findViewById(R.id.tvMass);
        tvMass.setVisibility(View.GONE);

        tvMolarMass = (TextView) findViewById(R.id.tvMolarMass);
        tvMolarMass.setVisibility(View.GONE);
        tvNMols = (TextView) findViewById(R.id.tvNMols);
        tvNMols.setVisibility(View.GONE);

        tvPercFormula = (TextView) findViewById(R.id.tvPercFormula);

        tvMinFormula = (TextView) findViewById(R.id.tvMinFormula);
        tvMinFormula.setVisibility(View.GONE);

        btCalc = (Button) findViewById(R.id.btCalc);

        setUpToolbar(getString(R.string.titleSub2_1));


        setUpCustomKeyboard(textListener);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //tvMinFormula.setText(Html.fromHtml(getString(R.string.tvPercFormula) + " " + percentualFormula()));

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
            if(!etFormula.getText().toString().equals(""))
                tvPercFormula.setText(HtmlCompat.fromHtml(getString(R.string.tvPercFormula) + " " + percentualFormula()));
            else
                tvPercFormula.setText("");

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
