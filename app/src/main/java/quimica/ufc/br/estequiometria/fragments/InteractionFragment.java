package quimica.ufc.br.estequiometria.fragments;


import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.parser.CodeConverter;
import quimica.ufc.br.estequiometria.parser.Evaluator;
import quimica.ufc.br.estequiometria.parser.SyntaxErrorException;

import static quimica.ufc.br.estequiometria.InteractionAcitivity.dictionaryCodes;

/**
 * A simple {@link Fragment} subclass.
 */
public class InteractionFragment extends Fragment {

    public static double MOLAR_MASS = 0.0;

    private static Evaluator evaluator = new Evaluator();

    private Keyboard keyboard;

    private KeyboardView keyboardView;
    protected EditText etFormula;


    public static DecimalFormat numberFormat = new DecimalFormat("#.00");

    public InteractionFragment() {
        // Required empty public constructor
    }


    /*
    *   Custom Keyboard Cofiguration
    */


    public void setUpCustomKeyboard(View v, TextWatcher listener){
        MOLAR_MASS = 0.0;

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        etFormula = (EditText) v.findViewById(R.id.etFormula);

        keyboardView = (KeyboardView) v.findViewById(R.id.keyboardview);

        keyboard = new Keyboard(getActivity().getBaseContext(), R.xml.keyboard);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(keyboardListener);

        etFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);
                showCustomKeyboard(v);
            }
        });

        etFormula.requestFocus();

        etFormula.addTextChangedListener(listener);
    }

    public void setUpCustomKeyboard(View v){ setUpCustomKeyboard(v, defaultTextListener); }

    TextWatcher defaultTextListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            defaultFormulaAction();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void defaultFormulaAction(){
        try {
            Log.d(MainActivity.TAG, "Formula Molecular: " + etFormula.getText().toString());
            Log.d(MainActivity.TAG, "Massa molar: " + evaluator.eval(etFormula.getText().toString()));

            MOLAR_MASS = evaluator.eval(etFormula.getText().toString());
        }catch (SyntaxErrorException e){
            // Mostrar Mensagem ao usuario

            MOLAR_MASS = 0.0;
        }
    }

    public void hideKeyboard(View view){
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void hideCustomKeyboard() {
        keyboardView.setVisibility(View.GONE);
        keyboardView.setEnabled(false);
    }

    public void showCustomKeyboard( View v ) {
        keyboardView.setVisibility(View.VISIBLE);
        keyboardView.setEnabled(true);
        if( v!=null ) ((InputMethodManager)getActivity().getSystemService(BasicActivity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public boolean isCustomKeyboardVisible() {
        return keyboardView.getVisibility() == View.VISIBLE;
    }

    public void hideCustomKeyboardIfVisible(Activity a){
        if( isCustomKeyboardVisible() )
            hideCustomKeyboard();
        else a.finish();
    }

    private KeyboardView.OnKeyboardActionListener keyboardListener = new KeyboardView.OnKeyboardActionListener() {
        public final static int CodeDelete   = -5; // Keyboard.KEYCODE_DELETE
        public final static int CodeCancel   = -3; // Keyboard.KEYCODE_CANCEL
        public final static int CodePrev     = 55000;
        public final static int CodeAllLeft  = 55001;
        public final static int CodeLeft     = 55002;
        public final static int CodeRight    = 55003;
        public final static int CodeAllRight = 55004;
        public final static int CodeNext     = 55005;
        public final static int CodeClear    = 55006;
        @Override
        public void onPress(int i) {

        }

        @Override
        public void onRelease(int i) {

        }


        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            View focusCurrent = getActivity().getWindow().getCurrentFocus();
            if( focusCurrent==null || focusCurrent.getClass()!=AppCompatEditText.class ) return;
            Editable editable = etFormula.getText();
            int start = etFormula.getSelectionStart();
            // Handle key
            if( primaryCode==CodeCancel ) {
                hideCustomKeyboard();
            } else if( primaryCode==CodeDelete ) {
                if( editable!=null && start>0 ) editable.delete(start - 1, start);
            } else if( primaryCode==CodeClear ) {
                if( editable!=null ) editable.clear();
            } else if( primaryCode==CodeLeft ) {
                if( start>0 ) etFormula.setSelection(start - 1);
            } else if( primaryCode==CodeRight ) {
                if (start < etFormula.length()) etFormula.setSelection(start + 1);
            } else if( primaryCode==CodeAllLeft ) {
                etFormula.setSelection(0);
            } else if( primaryCode==CodeAllRight ) {
                etFormula.setSelection(etFormula.length());
            } else if( primaryCode==CodePrev ) {
                View focusNew= etFormula.focusSearch(View.FOCUS_LEFT);
                if( focusNew!=null ) focusNew.requestFocus();
            } else if( primaryCode==CodeNext ) {
                View focusNew= etFormula.focusSearch(View.FOCUS_RIGHT);
                if( focusNew!=null ) focusNew.requestFocus();
            } else {// Insert character
                editable.insert(start, CodeConverter.convert(primaryCode,dictionaryCodes));
            }
        }

        @Override
        public void onText(CharSequence charSequence) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };


    /*
    *   End of Custom Keyboard Cofiguration
    */


}
