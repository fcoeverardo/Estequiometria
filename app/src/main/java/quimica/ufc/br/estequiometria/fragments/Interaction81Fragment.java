package quimica.ufc.br.estequiometria.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;


public class  Interaction81Fragment extends Fragment {

    private Button btCalc;
    private TextView tvResults,tvResult;
    private EditText etVol,etMol,etMolD;

    private double vol,mol,mold;


    public Interaction81Fragment() {
        // Required empty public constructor
    }


    public static Interaction81Fragment newInstance() {
        return new Interaction81Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interaction81, container, false);

        tvResults = (TextView) view.findViewById(R.id.tvResults);
        tvResult = (TextView) view.findViewById(R.id.tvResult);

        etVol = (EditText) view.findViewById(R.id.etVol);
        etMol = (EditText) view.findViewById(R.id.etMolar);
        etMolD = (EditText) view.findViewById(R.id.etMolarD);

        btCalc = (Button) view.findViewById(R.id.btCalc);

        tvResults.setText(HtmlCompat.fromHtml(getString(R.string.tvResults)));

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                vol = Double.parseDouble(etVol.getText().toString());
                mol = Double.parseDouble(etMol.getText().toString());
                mold = Double.parseDouble(etMolD.getText().toString());

                tvResult.setText(String.format(getString(R.string.tv5Result), InteractionAcitivity.convertBelowZero((mol*vol)/mold),InteractionAcitivity.convertBelowZero(vol)));

            }
        });


        // Inflate the layout for this fragment
        return view;
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
