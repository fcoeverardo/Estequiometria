package quimica.ufc.br.estequiometria.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Interaction82Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Interaction82Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Interaction82Fragment extends InteractionFragment {


    RadioButton rbSoliid,rbLiquid,rbMolar,rbMassmVolv;
    EditText etConc,etPGrade,etVolSolAq, etDensSolu;
    TextView tvResults,tvResult,tvConcMPerc, tvDensSolu;
    Button btCalc;



    //private OnFragmentInteractionListener mListener;

    public Interaction82Fragment() {
        // Required empty public constructor
    }

    public static Interaction82Fragment newInstance() {
        return new Interaction82Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interaction82, container, false);

        rbSoliid = (RadioButton) view.findViewById(R.id.rbSolid);
        rbLiquid = (RadioButton) view.findViewById(R.id.rbLiquid);
        rbMolar = (RadioButton) view.findViewById(R.id.rbMolar);
        rbMassmVolv = (RadioButton) view.findViewById(R.id.rbMassmVolv);

        etConc = (EditText) view.findViewById(R.id.etConc);
        etPGrade = (EditText) view.findViewById(R.id.etPGrade);
        etVolSolAq = (EditText) view.findViewById(R.id.etVolSolAq);
        etDensSolu = (EditText) view.findViewById(R.id.etDensSolu);


        tvResults = (TextView) view.findViewById(R.id.tvResults);
        tvResult = (TextView) view.findViewById(R.id.tvResult);
        tvConcMPerc = (TextView) view.findViewById(R.id.tvConcMPerc);
        tvDensSolu = (TextView) view.findViewById(R.id.tvDensSolu);

        btCalc = (Button) view.findViewById(R.id.btCalc);

        tvResults.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));

        rbLiquid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    rbMassmVolv.setText(getString(R.string.rbVolv));
                    tvDensSolu.setVisibility(View.VISIBLE);
                    etDensSolu.setVisibility(View.VISIBLE);
                }else{
                    rbMassmVolv.setText(getString(R.string.rbMassm));
                    tvDensSolu.setVisibility(View.GONE);
                    etDensSolu.setVisibility(View.GONE);
                }
            }
        });

        rbMolar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvConcMPerc.setText(getString(R.string.tvConcM));
                }else{
                    tvConcMPerc.setText(getString(R.string.tvConcPerc));
                }
            }
        });


        setUpCustomKeyboard(view);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepSolu();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void prepSolu(){

        if(rbMolar.isChecked() && rbSoliid.isChecked()){

            double concentration = Double.parseDouble(etConc.getText().toString());
            double purity = Double.parseDouble(etPGrade.getText().toString());
            double volSol = Double.parseDouble(etVolSolAq.getText().toString());

            double mass = (((concentration * MOLAR_MASS * volSol)/1000)*100)/purity;

            tvResult.setText(String.format(getString(R.string.tvResultInt9), mass, getString(R.string.gram), volSol, getString(R.string.milliliter)));

        }else if(rbMolar.isChecked() && rbLiquid.isChecked()){

            double concentration = Double.parseDouble(etConc.getText().toString());
            double purity = Double.parseDouble(etPGrade.getText().toString());
            double volSol = Double.parseDouble(etVolSolAq.getText().toString());
            double density = Double.parseDouble(etDensSolu.getText().toString());

            double mass = (((concentration * MOLAR_MASS * volSol)/1000)*100)/purity;
            double volSoluR = mass/density;

            tvResult.setText(String.format(getString(R.string.tvResultInt9), volSoluR, getString(R.string.milliliter), volSol, getString(R.string.milliliter)));

        /*
            Os dois testes a seguir estão com nomes de variaveis que não condizem muito com o que fazem
            tive que fazer uma adaptação, o código abaixo pode estar incorreto
        */
        }else if(rbMassmVolv.isChecked() && rbSoliid.isChecked()){

            double concentration = Double.parseDouble(etConc.getText().toString());
            double purity = Double.parseDouble(etPGrade.getText().toString());
            double volSol = Double.parseDouble(etVolSolAq.getText().toString());

            double volSolu = (concentration / volSol)/100;
            double volSolv = ((volSol-volSolu)*100)/purity;

            tvResult.setText(String.format(getString(R.string.tvResultInt9), volSolv, getString(R.string.gram), volSol, getString(R.string.milliliter)));

        }else if(rbMassmVolv.isChecked() && rbLiquid.isChecked()){

            double concentration = Double.parseDouble(etConc.getText().toString());
            double purity = Double.parseDouble(etPGrade.getText().toString());
            double volSol = Double.parseDouble(etVolSolAq.getText().toString());
            double density = Double.parseDouble(etDensSolu.getText().toString());

            double mass = (((concentration * volSol * density)/100)*100)/purity;

            tvResult.setText(String.format(getString(R.string.tvResultInt9), mass, getString(R.string.milliliter), volSol, getString(R.string.milliliter)));


        }

    }


    public void onBackPressed() {
        hideCustomKeyboardIfVisible(getActivity());
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
