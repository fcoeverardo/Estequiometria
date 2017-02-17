package quimica.ufc.br.estequiometria.interactions;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Interaction12Activity extends InteractionAcitivity {

    TextView tvReaction, tvi41, tvi41mass, tvi41mols,
            tvExcLim1, tvRemain1, tvi42, tvi42mass,
            tvi42mols, tvExcLim2, tvRemain2, tvYield, tvProducts,
            tvProduct1, tvProduct1Mass, tvProduct1Mols,
            tvProduct2, tvProduct2Mass, tvProduct2Mols, tvExp;
    SeekBar sb1, sb2, sb3;

    double mass1,mass2,mols1,mols2,yield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction4);



        tvExp = (TextView) findViewById(R.id.tvExp);
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

        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb2 = (SeekBar) findViewById(R.id.sb2);
        sb3 = (SeekBar) findViewById(R.id.sb3);

        setUpToolbar(getString(R.string.titleInt12));

        tvReaction.setText(HtmlCompat.fromHtml(getString(R.string.tvReaction)));
        tvi41.setText(HtmlCompat.fromHtml(getString(R.string.tvi41)));
        tvi42.setText(HtmlCompat.fromHtml(getString(R.string.tvi42)));
        tvProducts.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));
        tvProduct1.setText(HtmlCompat.fromHtml(getString(R.string.tvProd1)));
        tvProduct2.setText(HtmlCompat.fromHtml(getString(R.string.tvProd2)));

        tvExp.setVisibility(View.VISIBLE);
        tvExp.setText(HtmlCompat.fromHtml(getString(R.string.tvExp12)));


        yield = 1;

        tvYield.setVisibility(View.GONE);

        sb1.setOnSeekBarChangeListener(listerner);
        sb2.setOnSeekBarChangeListener(listerner);
        sb3.setVisibility(View.GONE);



    }

    private SeekBar.OnSeekBarChangeListener listerner = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            if (seekBar.equals(sb1)) {
                mass1 = progress;
                mols1 = mass1 / MM1;

                tvi41mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (mass1 != 0 ? numberFormat.format(mass1) : mass1)));
                tvi41mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(mols1)));
                whichLimitant();

            } else if (seekBar.equals(sb2)) {
                mass2 = progress;
                mols2 = mass2 / MM2;

                tvi42mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + (mass2 != 0 ? numberFormat.format(mass2) : mass2)));
                tvi42mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(mols2)));
                whichLimitant();

            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
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

            tvExcLim1.setText(HtmlCompat.fromHtml(getString(R.string.tvExcLim) + " " + getString(R.string.Exceeding)));
            tvExcLim2.setText(HtmlCompat.fromHtml(getString(R.string.tvExcLim) + " " + getString(R.string.Limitant)));

            tvRemain1.setVisibility(View.VISIBLE);
            tvRemain2.setVisibility(View.VISIBLE);

            tvRemain1.setText(HtmlCompat.fromHtml(getString(R.string.Remain) + " " + convertBelowZero(((mols1-((3/2)*mols2))*MM1)*yield)) );
            tvRemain2.setText(HtmlCompat.fromHtml(getString(R.string.Remain) + " 0"));

            tvProduct1Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd1*yield)));
            tvProduct2Mols.setText(HtmlCompat.fromHtml(getString(R.string.tvMols) + " " + convertBelowZero(molsProd2*yield)));

            tvProduct1Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + convertBelowZero((molsProd1*MM3)*yield)));
            tvProduct2Mass.setText(HtmlCompat.fromHtml(getString(R.string.tvMass2) + " " + convertBelowZero((molsProd2*MM4)*yield)));

        }else if(mols1 < (3/2)*mols2){
            molsProd1 = mols1/3;
            molsProd2 = mols1*2;

            tvExcLim1.setVisibility(View.VISIBLE);
            tvExcLim2.setVisibility(View.VISIBLE);

            tvExcLim1.setText(HtmlCompat.fromHtml(getString(R.string.tvExcLim) + " " + getString(R.string.Limitant)));
            tvExcLim2.setText(HtmlCompat.fromHtml(getString(R.string.tvExcLim) + " " + getString(R.string.Exceeding)));

            tvRemain1.setVisibility(View.VISIBLE);
            tvRemain2.setVisibility(View.VISIBLE);

            tvRemain1.setText(HtmlCompat.fromHtml(getString(R.string.Remain) + " 0"));
            tvRemain2.setText(HtmlCompat.fromHtml(getString(R.string.Remain) + " " + convertBelowZero(((((3/2)*mols2)-mols1)*MM2)*yield)));

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
