package quimica.ufc.br.estequiometria.interactions;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Interaction11Activity extends InteractionAcitivity {

    private TextView tvExp11,tvPurityNicl,tvResults;
    private SeekBar sb1,sb2;

    private int nmols;
    private double purity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction11);


        tvExp11 = (TextView) findViewById(R.id.tvExp11);
        tvInt101 = (TextView) findViewById(R.id.tvIntRea);
        tvPurityNicl = (TextView) findViewById(R.id.tvPurityNicl);
        tvResults = (TextView) findViewById(R.id.tvResults);
        tvNicl2 = (TextView) findViewById(R.id.tvNicl2);
        tvNa3po4 = (TextView) findViewById(R.id.tvNa3po4);
        tvNipo42 = (TextView) findViewById(R.id.tvNipo42);
        tvNacl  = (TextView) findViewById(R.id.tvNacl);

        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb2 = (SeekBar) findViewById(R.id.sb2);

        setUpToolbar(getString(R.string.titleInt11));

        tvExp11.setText(HtmlCompat.fromHtml(getString(R.string.tvExp11)));
        tvInt101.setText(HtmlCompat.fromHtml(getString(R.string.tvIntRect)));
        tvPurityNicl.setText(getString(R.string.tvPurityNiCl)+" 25%");
        tvResults.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));

        sb1.setOnSeekBarChangeListener(listener);
        sb1.setMax(8);
        sb1.setProgress(2);
        nmols = 3;

        sb2.setOnSeekBarChangeListener(listener);
        sb2.setProgress(25);
        purity = 0.25;

        calculateFormula(nmols,purity);

    }

    private SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(seekBar.equals(sb1)){
                calculateFormula(++progress,purity);
                nmols = progress;
            }else if(seekBar.equals(sb2)){
                tvPurityNicl.setText(getString(R.string.tvPurityNiCl)+" "+progress+"%");
                purity = (double)progress/100;
                calculateFormula(nmols,purity);
            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}

    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
