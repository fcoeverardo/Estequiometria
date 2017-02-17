package quimica.ufc.br.estequiometria.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.fragments.InteractionFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Test1Fragment extends InteractionFragment {

    TextView tvMolMass;

    public Test1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_test1, container, false);

        setUpCustomKeyboard(v, textListener);

        tvMolMass = (TextView) v.findViewById(R.id.tvMolMass);

        return v;
    }

    TextWatcher textListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            defaultFormulaAction();
            tvMolMass.setText(getString(R.string.tvMolarMass)+" "+numberFormat.format(MOLAR_MASS));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
