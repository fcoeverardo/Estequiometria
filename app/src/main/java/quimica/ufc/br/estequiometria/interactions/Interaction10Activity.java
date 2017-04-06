package quimica.ufc.br.estequiometria.interactions;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;

public class Interaction10Activity extends InteractionAcitivity {

    private SeekBar sb1;
    private TextView tvResults,tvInt102,tvExp10;

    double minPercent = 0.0;

    //DecimalFormat numberFormat = new DecimalFormat("#.00");
    DecimalFormat noFloat = new DecimalFormat("#");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction10);

        setUpToolbar(getString(R.string.titleInt10));

        tvExp10 = (TextView) findViewById(R.id.tvExp10);
        tvInt101 = (TextView) findViewById(R.id.tvInt101);
        tvInt102 = (TextView) findViewById(R.id.tvInt102);
        tvResults = (TextView) findViewById(R.id.tvResults);
        tvNicl2 = (TextView) findViewById(R.id.tvNicl2);
        tvNa3po4 = (TextView) findViewById(R.id.tvNa3po4);
        tvNipo42 = (TextView) findViewById(R.id.tvNipo42);
        tvNacl  = (TextView) findViewById(R.id.tvNacl);

        sb1 = (SeekBar) findViewById(R.id.sb1);



        calculateFormula(3,1);

        tvExp10.setText(HtmlCompat.fromHtml(getString(R.string.tvExp10)));
        tvInt101.setText(HtmlCompat.fromHtml(getString(R.string.tvIntRect)));
        tvInt102.setText(HtmlCompat.fromHtml(getString(R.string.tvInt102)));
        tvResults.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));

        sb1.setMax(8);
        sb1.setProgress(2);
        sb1.setOnSeekBarChangeListener(listener);

    }


    private SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            calculateFormula(++progress,1);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
