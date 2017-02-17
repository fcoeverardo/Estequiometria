package quimica.ufc.br.estequiometria.interactions;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Interaction13Activity extends InteractionAcitivity {

    TextView tvReaction, tvi41, tvi41mass, tvi41mols,
            tvExcLim1, tvRemain1, tvi42, tvi42mass,
            tvi42mols, tvExcLim2, tvRemain2, tvYield,
            tvProducts,tvProduct1, tvProduct1Mass,
            tvProduct1Mols, tvProduct2, tvProduct2Mass,
            tvProduct2Mols, tvPurity1,tvPurity2,slashn;
    SeekBar sb1, sb2, sb3, sb4, sb5;

    private double mass1,mass2,mols1,mols2,yield, purity1,purity2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction4);

        tvReaction = (TextView) findViewById(R.id.tvReaction);
        tvi41 = (TextView) findViewById(R.id.tvi41);
        tvi41mass = (TextView) findViewById(R.id.tvi41mass);
        tvi41mols = (TextView) findViewById(R.id.tvi41mols);
        tvExcLim1 = (TextView) findViewById(R.id.tvExcLim1);
        tvRemain1 = (TextView) findViewById(R.id.tvRemain1);
        tvi42 = (TextView) findViewById(R.id.tvi42);
        tvi42mass = (TextView) findViewById(R.id.tvi42mass);
        tvi42mols = (TextView) findViewById(R.id.tvi42mols);
        tvExcLim2 = (TextView) findViewById(R.id.tvExcLim2);
        tvRemain2 = (TextView) findViewById(R.id.tvRemain2);
        tvYield = (TextView) findViewById(R.id.tvYield);
        tvProducts = (TextView) findViewById(R.id.tvProducts);
        tvProduct1 = (TextView) findViewById(R.id.tvProduct1);
        tvProduct1Mass = (TextView) findViewById(R.id.tvProduct1Mass);
        tvProduct1Mols = (TextView) findViewById(R.id.tvProduct1Mols);
        tvProduct2 = (TextView) findViewById(R.id.tvProduct2);
        tvProduct2Mass = (TextView) findViewById(R.id.tvProduct2Mass);
        tvProduct2Mols = (TextView) findViewById(R.id.tvProduct2Mols);
        tvPurity1 = (TextView) findViewById(R.id.tvPurity1);
        tvPurity2 = (TextView) findViewById(R.id.tvPurity2);
        slashn = (TextView) findViewById(R.id.slashn);

        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb2 = (SeekBar) findViewById(R.id.sb2);
        sb3 = (SeekBar) findViewById(R.id.sb3);
        sb4 = (SeekBar) findViewById(R.id.sb4);
        sb5 = (SeekBar) findViewById(R.id.sb5);

        setUpToolbar(getString(R.string.titleInt13));

        tvReaction.setText(HtmlCompat.fromHtml(getString(R.string.tvReaction)));
        tvi41.setText(HtmlCompat.fromHtml(getString(R.string.tvi41)));
        tvi42.setText(HtmlCompat.fromHtml(getString(R.string.tvi42)));
        tvProducts.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));
        tvProduct1.setText(HtmlCompat.fromHtml(getString(R.string.tvProd1)));
        tvProduct2.setText(HtmlCompat.fromHtml(getString(R.string.tvProd2)));
        tvPurity1.setText(getString(R.string.tvPurity));
        tvPurity2.setText(getString(R.string.tvPurity));

        slashn.setVisibility(View.VISIBLE);

        sb3.setProgress(75);
        yield = 0.75;

        tvYield.setText(getString(R.string.Yield) + " 75%");

        sb4.setVisibility(View.VISIBLE);
        sb5.setVisibility(View.VISIBLE);

        sb4.setProgress(50);
        sb5.setProgress(50);
        purity1 = 0.5;
        purity2 = 0.5;

        sb1.setOnSeekBarChangeListener(listerner);
        sb2.setOnSeekBarChangeListener(listerner);
        sb3.setOnSeekBarChangeListener(listerner);
        sb4.setOnSeekBarChangeListener(listerner);
        sb5.setOnSeekBarChangeListener(listerner);

    }

    private SeekBar.OnSeekBarChangeListener listerner = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if(seekBar.equals(sb1)) {
                Log.d(MainActivity.TAG,""+mass1);
                mass1 = progress*purity1;
                mols1 = mass1 / MM1;

                tvi41mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (mass1 !=0 ? numberFormat.format(mass1) : mass1)));
                tvi41mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(mols1)));
                whichLimitant();

            }else if(seekBar.equals(sb2)){
                mass2 = progress*purity2;
                mols2 = mass2/MM2;

                tvi42mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (mass2 !=0 ? numberFormat.format(mass2) : mass2)));
                tvi42mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(mols2)));
                whichLimitant();

            }else if(seekBar.equals(sb3)){
                yield = (double) progress/100;
                tvYield.setText(getString(R.string.Yield) + " " + progress +"%");
                whichLimitant();

            }else if(seekBar.equals(sb4)){
                tvPurity1.setText(getString(R.string.tvPurity) + " " + progress + "%");
                //Log.d(MainActivity.TAG, "mass: "+progress/100.0 + ","+mass1);

                purity1 = progress/100.0;
                mass1*=purity1;

                mols1 = mass1 / MM1;

                tvi41mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (mass1 !=0 ? numberFormat.format(mass1) : mass1)));
                tvi41mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(mols1)));
                whichLimitant();

            }

            else if(seekBar.equals(sb5)){
                tvPurity2.setText(getString(R.string.tvPurity) + " " + progress + "%");

                purity2 = progress/100.0;
                mass2*=purity2;

                mols2 = mass2 / MM2;

                tvi42mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (mass2 !=0 ? numberFormat.format(mass2) : mass2)));
                tvi42mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(mols2)));
                whichLimitant();

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar){}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}

    };

    private void whichLimitant(){

        double molsProd1,molsProd2;

        if(mols1 == (3/2)*mols2){
            tvExcLim1.setText("");
            tvExcLim2.setText("");

            tvExcLim1.setVisibility(View.GONE);
            tvExcLim2.setVisibility(View.GONE);

            tvRemain1.setText("");
            tvRemain2.setText("");

            tvRemain1.setVisibility(View.GONE);
            tvRemain2.setVisibility(View.GONE);

            molsProd1 = mols1/3;
            molsProd2 = mols1*2;

            tvProduct1Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd1*yield)));
            tvProduct2Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd2*yield)));

            tvProduct1Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (convertBelowZero((molsProd1*MM3)*yield))));
            tvProduct2Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (convertBelowZero((molsProd2*MM4)*yield))));

        }else if(mols1 > (3/2)*mols2){

            molsProd1 = mols1/2;
            molsProd2 = mols1*3;

            tvExcLim1.setVisibility(View.VISIBLE);
            tvExcLim2.setVisibility(View.VISIBLE);

            tvExcLim1.setText(getString(R.string.tvExcLim) + " " + getString(R.string.Exceeding));
            tvExcLim2.setText(getString(R.string.tvExcLim) + " " + getString(R.string.Limitant));

            tvRemain1.setVisibility(View.VISIBLE);
            tvRemain2.setVisibility(View.VISIBLE);

            tvRemain1.setText(HtmlCompat.fromHtml(getString(R.string.Remain) + " " + convertBelowZero(((mols1-((3/2)*mols2))*MM1)*yield)) );
            tvRemain2.setText(getString(R.string.Remain) + " 0");

            tvProduct1Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd1*yield)));
            tvProduct2Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd2*yield)));

            tvProduct1Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + convertBelowZero((molsProd1*MM3)*yield)));
            tvProduct2Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + convertBelowZero((molsProd2*MM4)*yield)));

        }else if(mols1 < (3/2)*mols2){
            molsProd1 = mols1/3;
            molsProd2 = mols1*2;

            tvExcLim1.setVisibility(View.VISIBLE);
            tvExcLim2.setVisibility(View.VISIBLE);

            tvExcLim1.setText(getString(R.string.tvExcLim) + " " + getString(R.string.Limitant));
            tvExcLim2.setText(getString(R.string.tvExcLim) + " " + getString(R.string.Exceeding));

            tvRemain1.setVisibility(View.VISIBLE);
            tvRemain2.setVisibility(View.VISIBLE);

            tvRemain1.setText(getString(R.string.Remain) + " 0");
            tvRemain2.setText(getString(R.string.Remain) + " " + (((((3/2)*mols2)-mols1)*MM2)*yield));

            tvProduct1Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd1*yield)));
            tvProduct2Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd2*yield)));

            tvProduct1Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + convertBelowZero((molsProd1*MM3)*yield)));
            tvProduct2Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + convertBelowZero((molsProd2*MM4)*yield)));

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
