package quimica.ufc.br.estequiometria.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

public class Interaction2Fragment extends Fragment {

    TextView tvi21,tvi22,tvi23;
    SeekBar sb1;

    private String element, molarMass;

    public static DecimalFormat numberFormat = new DecimalFormat("#0.00");

    public Interaction2Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Interaction2Fragment newInstance(int element) {
        Interaction2Fragment instance = new Interaction2Fragment();

        Bundle args = new Bundle();
        args.putInt("element",element);
        instance.setArguments(args);

        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_interaction2, container, false);



        switch (getArguments().getInt("element",0)){
            case 0:
                this.element = getString(R.string.elementC);
                this.molarMass = getString(R.string.molarMassC);
                break;
            case 1:
                this.element = getString(R.string.elementFe);
                this.molarMass = getString(R.string.molarMassFe);
                break;
            case 2:
                this.element = getString(R.string.elementPd);
                this.molarMass = getString(R.string.molarMassPd);
                break;
            case 3:
                this.element = getString(R.string.elementAu);
                this.molarMass = getString(R.string.molarMassAu);
                break;
        }

        tvi21 = (TextView) view.findViewById(R.id.tvi21);
        tvi22 = (TextView) view.findViewById(R.id.tvi22);
        tvi23 = (TextView) view.findViewById(R.id.tvi23);

        tvi21.setText(String.format(getString(R.string.tvi21),"0"));
        tvi22.setText(String.format(getString(R.string.tvi22),"0"));

        tvi23.setText(HtmlCompat.fromHtml(String.format(getString(R.string.tvi23),
                element,element,"0",molarMass, "0")));

        sb1 = (SeekBar) view.findViewById(R.id.sb1);

        sb1.setMax(getResources().getInteger(R.integer.maxMass));
        sb1.setOnSeekBarChangeListener(listener);

        return view;
    }

    private SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            String result = getString(R.string.tvi23);
            String mass = String.valueOf(progress);

            double molMass = Double.parseDouble(molarMass);
            double mols = (double) progress / molMass;

            tvi21.setText(String.format(getString(R.string.tvi21), String.valueOf(progress)));
            tvi22.setText(String.format(getString(R.string.tvi22), numberFormat.format(mols)));

            tvi23.setText(HtmlCompat.fromHtml(String.format(result, element, element, mass, molarMass,
                    numberFormat.format(mols))));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

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
        //mListener = null;
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
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
