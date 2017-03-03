package quimica.ufc.br.estequiometria.fragments;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.MainActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.parser.CodeConverter;
import quimica.ufc.br.estequiometria.parser.Evaluator;
import quimica.ufc.br.estequiometria.parser.SyntaxErrorException;

/**
 * A simple {@link Fragment} subclass.
 */
public class InteractionFragment extends Fragment {

    public static double MOLAR_MASS = 0.0;

    private static Evaluator evaluator = new Evaluator();

    private Keyboard keyboard;

    private KeyboardView keyboardView;
    protected EditText etFormula;

    Dialog dialog;


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
        public final static int CodeAllElements = -10; // Key All Element
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
            }else if( primaryCode==CodeAllElements ) {
                openAllElementsDialog();
            } else if( primaryCode==CodeDelete ) {
                deleteElement(editable,start);
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
                insertElement(editable,start,primaryCode);
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
    public void deleteElement(Editable editable,int start){

        String aux = editable.toString();

        if( editable!=null && start>0 ){
            if(aux.charAt(aux.length()-1) >= 'a' && aux.charAt(aux.length()-1) <= 'z')
                editable.delete(start - 2, start);
            else
                editable.delete(start - 1, start);
        }


    }

    public void insertElement(Editable editable,int start, int primaryCode){

        if(primaryCode >= 0 &&  primaryCode < 10){

            if(start > 0 && editable.toString().charAt(start - 1)=='.'){
                editable.insert(start, CodeConverter.convert(primaryCode));
            }
            else{

                if(start == 0)
                    editable.insert(start, CodeConverter.convert(primaryCode));
                else{
                    Spanned code;
                    code = Html.fromHtml("<sub>" + CodeConverter.convert(primaryCode) +"</sub>");

                    SpannableString spannedCode = new SpannableString(code);
                    spannedCode.setSpan(new RelativeSizeSpan(0.6f),0,spannedCode.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    editable.insert(start, spannedCode);
                }

            }

        }
        else
            editable.insert(start, CodeConverter.convert(primaryCode));


        hideAllElementifVisible();
    }

    public void openAllElementsDialog(){

        //keyboardView.setVisibility(View.GONE);
        //keyboardAll.setVisibility(View.VISIBLE);

        dialog = new Dialog(getActivity());
        dialog.setTitle("All Elements");
        dialog.setContentView(R.layout.keyboardall_layout);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        // set the custom dialog components - text, image and button
        FrameLayout keyboardWrapper = (FrameLayout) dialog.findViewById(R.id.keyboardwrapper);

        ViewGroup.LayoutParams params = keyboardWrapper.getLayoutParams();
        params.width = (int) (width * 3);
        keyboardWrapper.setLayoutParams(params);

        KeyboardView aEKeyboardView = (KeyboardView) dialog.findViewById(R.id.keyboardview);

        Keyboard aEKeyboard = new Keyboard(getActivity(), R.xml.keyboardall);
        aEKeyboardView.setKeyboard(aEKeyboard);

        aEKeyboardView.setOnKeyboardActionListener(keyboardListener);

        dialog.show();
    }

    public void hideAllElementifVisible(){

        if(dialog!= null && dialog.isShowing())
            dialog.dismiss();

    }
}
