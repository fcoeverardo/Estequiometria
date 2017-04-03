package quimica.ufc.br.estequiometria;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v4.widget.ListViewAutoScrollHelper;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.models.Element;
import quimica.ufc.br.estequiometria.parser.CodeConverter;
import quimica.ufc.br.estequiometria.parser.Evaluator;
import quimica.ufc.br.estequiometria.parser.SyntaxErrorException;

public class InteractionAcitivity extends BasicActivity {

    public static final ArrayList<String> ELEMENTS = new ArrayList<String>(){{
        add("H"); add("He");
        add("Li"); add("Be"); add("B"); add("C"); add("N"); add("O"); add("F"); add("Ne");
        add("Na"); add("Mg"); add("Al"); add("Si"); add("P"); add("S"); add("Cl"); add("Ar");
        add("K"); add("Ca"); add("Sc"); add("Ti"); add("V"); add("Cr"); add("Mn"); add("Fe"); add("Co"); add("Ni"); add("Cu"); add("Zn"); add("Ga"); add("Ge"); add("As"); add("Se"); add("Br"); add("Kr");
        add("Rb"); add("Sr"); add("Y"); add("Zr"); add("Nb"); add("Mo"); add("Tc"); add("Ru"); add("Rh"); add("Pd"); add("Ag"); add("Cd"); add("In"); add("Sn"); add("Sb"); add("Te"); add("I"); add("Xe");
        add("Cs"); add("Ba"); add("La"); add("Hf"); add("Ta"); add("W"); add("Re"); add("Os"); add("Ir"); add("Pt"); add("Au"); add("Hg"); add("Tl"); add("Pb"); add("Bi"); add("Po"); add("At"); add("Rn");
        add("Fr"); add("Ra"); add("Ac"); add("Rf"); add("Db"); add("Sg"); add("Bh"); add("Hs"); add("Mt"); add("Uun"); add("Uuu"); add("Uub"); add("Uut"); add("Uuq"); add("Uup"); add("Uuh"); add("Uus"); add("Uuo");
        add("Ce"); add("Pr"); add("Nd"); add("Pm"); add("Sm"); add("Eu"); add("Gd"); add("Tb"); add("Dy"); add("Ho"); add("Er"); add("Tm"); add("Yb"); add("Lu");
        add("Th"); add("Pa"); add("U"); add("Np"); add("Pu"); add("Am"); add("Cm"); add("Bk"); add("Cf"); add("Es"); add("Fm"); add("Md"); add("No"); add("Lr");

    }};

    public static final double[] ELEMENTS_MASS = new double[]{
            1.00794, 4.002602,
            6.941, 9.012182, 10.811, 12.011, 14.00674, 15.9994, 18.9984032, 20.1797,
            22.989768, 24.3050, 26.981539, 28.0855, 30.973762, 32.066, 35.4527, 39.948,
            39.0983, 40.078, 44.955910, 47.88, 50.9415, 51.9961, 54.93805, 55.847, 58.93320, 58.6934, 63.546, 65.39, 69.723, 72.61, 74.92159, 78.96, 79.904, 83.80,
            85.4678, 87.62, 88.90585, 91.224, 92.90838, 95.94, 97.9072, 101.07, 102.90550, 106.42, 107.8682, 112.411, 114.818, 118.710, 121.757, 127.60, 126.90447, 131.29,
            132.90543, 137.327, 138.9055, 178.49, 180.9479, 183.84, 186.207, 190.23, 192.22, 195.08, 196.6654, 200.59, 204.3833 , 207.2, 208.98037, 208.9824, 209.9871, 222.0176,
            223.0197, 226.0254, 227.0278, 261.0, 262.0, 263.0, 262.0, 265.0, 266.0, 269.0, 272.0, 277.0, 0.0, 285.0, 0.0, 289.0, 0.0, 293.0,
            140.115, 140.90765, 144.24, 144.9127, 150.36, 151.965, 157.25, 158.92534, 162.50, 164.93032, 167.26, 168.93421, 173.04, 174.967,
            232.0381, 231.03588, 238.0289, 237.0482, 244.0642, 243.0614, 247.0703, 247.0703, 251.0796, 252.083, 257.0951, 258.10, 259.1009, 262.11
    };

    public static final HashMap<String,Double> ELEMENTS_HASH = new HashMap<String,Double>(){{
        put("H", 1.00794); put("He", 4.002602);
        put("Li", 6.941); put("Be", 9.012182); put("B", 10.811); put("C", 12.011); put("N", 14.00674); put("O", 15.9994); put("F", 18.9984032); put("Ne", 20.1797);
        put("Na", 22.989768); put("Mg", 24.3050); put("Al", 26.981539); put("Si", 28.0855); put("P", 30.973762); put("S", 32.066); put("Cl", 35.4527); put("Ar", 39.948);
        put("K", 39.0983); put("Ca", 40.078); put("Sc", 44.955910); put("Ti", 47.88); put("V", 50.9415); put("Cr", 51.9961); put("Mn", 54.93805); put("Fe", 55.847); put("Co", 58.93320); put("Ni", 58.6934); put("Cu", 63.546); put("Zn", 65.39); put("Ga", 69.723); put("Ge", 72.61); put("As", 74.92159); put("Se", 78.96); put("Br", 79.904); put("Kr", 83.80);
        put("Rb", 85.4678); put("Sr", 87.62); put("Y", 88.90585); put("Zr", 91.224); put("Nb", 92.90838); put("Mo", 95.94); put("Tc", 97.9072); put("Ru", 101.07); put("Rh", 102.90550); put("Pd", 106.42); put("Ag", 107.8682); put("Cd", 112.411); put("In", 114.818); put("Sn", 118.710); put("Sb", 121.757); put("Te", 127.60); put("I", 126.90447); put("Xe", 131.29);
        put("Cs", 132.90543); put("Ba", 137.327); put("La", 138.9055); put("Hf", 178.49); put("Ta", 180.9479); put("W", 183.84); put("Re", 186.207); put("Os", 190.23); put("Ir", 192.22); put("Pt", 195.08); put("Au", 196.6654); put("Hg", 200.59); put("Tl", 204.3833); put("Pb", 207.2); put("Bi", 208.98037); put("Po", 208.9824); put("At", 209.9871); put("Rn", 222.0176);
        put("Fr", 223.0197); put("Ra", 226.0254); put("Ac", 227.0278); put("Rf", 261.0); put("Db", 262.0); put("Sg", 263.0); put("Bh", 262.0); put("Hs", 265.0); put("Mt", 266.0); put("Uun", 269.0); put("Uuu", 272.0); put("Uub", 277.0); put("Uut", 0.0); put("Uuq", 285.0); put("Uup", 0.0); put("Uuh", 289.0); put("Uus", 0.0); put("Uuo", 293.0);
        put("Ce", 140.115); put("Pr", 140.90765); put("Nd", 144.24); put("Pm", 144.9127); put("Sm", 150.36); put("Eu", 151.965); put("Gd", 157.25); put("Tb", 158.92534); put("Dy", 162.50); put("Ho", 164.93032); put("Er", 167.26); put("Tm", 168.93421); put("Yb", 173.04); put("Lu", 174.967);
        put("Th", 232.0381); put("Pa", 231.03588); put("U", 238.0289); put("Np", 237.0482); put("Pu", 244.0642); put("Am", 243.0614); put("Cm", 247.0703); put("Bk", 247.0703); put("Cf", 251.0796); put("Es", 252.083); put("Fm", 257.0951); put("Md", 258.10); put("No", 259.1009); put("Lr", 262.11);

    }};


    protected final double MM1 = 129.598, MM2 = 163.94, MM3 = 248.635, MM4 = 58.442;

    protected final double NICL2 = 129.6, NA3PO4 = 163.94, NIPO42 = 248.64, NACL = 58.44;

    protected ArrayList<Element> elements = new ArrayList<>();
    protected ArrayList<Element> elementsUndo = new ArrayList<>();

    public static DecimalFormat numberFormat = new DecimalFormat("#.00");


    private static Evaluator evaluator = new Evaluator();

    private Keyboard keyboard;
    private KeyboardView keyboardView;
    private LinearLayout keyboardLayout;
    private Dialog dialog;
    protected EditText etFormula;

    public static double MOLAR_MASS;

    //protected Toolbar toolbar;

    protected TextView tvInt101,tvNicl2,tvNa3po4,tvNipo42,tvNacl;

    /*
    *   Custom Keyboard Cofiguration
    */

    public void setUpCustomKeyboard(TextWatcher listener){
        MOLAR_MASS = 0.0;

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        etFormula = (EditText) findViewById(R.id.etFormula);

        //setFlipperTouchEvent();

        keyboardLayout = (LinearLayout) findViewById(R.id.keyboardLayout);

        keyboardView = (KeyboardView) findViewById(R.id.keyboardview);

        keyboard = new Keyboard(getBaseContext(), R.xml.keyboard);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(keyboardListener);

        etFormula.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showCustomKeyboard(v);
                hideKeyboard(v);
                etFormula.requestFocus();

                return true;
            }
        });

        etFormula.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showCustomKeyboard(v);
                    hideKeyboard(v);
                }
                else
                    hideCustomKeyboardIfVisible();
            }
        });

        etFormula.requestFocus();

        etFormula.addTextChangedListener(listener);
    }

    public void setUpCustomKeyboard(){ setUpCustomKeyboard(defaultTextListener); }

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
            elements = evaluator.elementsArray;
        }catch (SyntaxErrorException e){
            // Mostrar Mensagem ao usuario

            MOLAR_MASS = 0.0;
        }
    }

    public void hideCustomKeyboard() {

        keyboardLayout.setVisibility(View.GONE);
        //keyboardView.setEnabled(false);
    }

    public void showCustomKeyboard( View v ) {
        if( v!=null )
            ((InputMethodManager)getSystemService(BasicActivity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);


        keyboardLayout.setVisibility(View.VISIBLE);
        keyboardView.setEnabled(true);

    }

    public boolean isCustomKeyboardVisible() {
        return keyboardLayout.getVisibility() == View.VISIBLE;
    }

    public void hideCustomKeyboardIfVisible(){
        if( isCustomKeyboardVisible() )
            hideCustomKeyboard();
        else this.finish();
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
            View focusCurrent = InteractionAcitivity.this.getWindow().getCurrentFocus();
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

    public static String convertBelowZero(double number){
        if(number==0){return ""+number;}
        String result;
        int acum = 0;

        while(number<1){
            number*=10;
            acum++;
        }
        result = numberFormat.format(number)+ (acum > 0 ? " * 10<sup><small>-"+acum+"</sup></small>" : "");

        return result;
    }

    protected void calculateFormula(int mols, double purity){
        String v2 = (mols%3 == 0 ? ""+ (int)(mols/1.5) : (mols*2)+"/3");
        String v3 = (mols%3 == 0 ? ""+mols/3 : mols+"/3");

        //tvInt101.setText(Html.fromHtml(String.format(getString(R.string.tvIntRect),(mols>1 ? mols : "") , (v2.equals("1") ? "" : v2) , (v3.equals("1") ? "" : v3) ,String.valueOf(mols*2))));

        tvNicl2.setText(HtmlCompat.fromHtml(String.format(getString(R.string.tvNicl2), (purity==0 ? 0 : formatFloat(mols*NICL2*purity)) , ""+mols )));
        tvNa3po4.setText(HtmlCompat.fromHtml(String.format(getString(R.string.tvNa3PO4), (purity==0 ? 0 : formatFloat((mols/1.5)*NA3PO4*purity)) , v2)));
        tvNipo42.setText(HtmlCompat.fromHtml(String.format(getString(R.string.tvNipo42), (purity==0 ? 0 : formatFloat((mols*3)*NIPO42*purity)) , v3)));
        tvNacl.setText(HtmlCompat.fromHtml(String.format(getString(R.string.tvNacl), (purity==0 ? 0 : formatFloat((mols*2)*NACL*purity)) , ""+mols*2)));

    }

    public void hideKeyboard(View view){
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void undoElement(){
        Element element = elements.get(elements.size()-1);
        Element.MOLARMASS -= element.getMass()*element.getNumber();

        elementsUndo.add(element);

        element = null;

        elements.remove(elements.size()-1);

        element = elements.get(elements.size()-1);

        //tvResult.setText(element.getResult());
    }

    protected void redoElement(){
        Element element = elementsUndo.get(elementsUndo.size()-1);
        Element.MOLARMASS += element.getMass()*element.getNumber();

        elements.add(element);
        element = null;
        elementsUndo.remove(elementsUndo.size()-1);

        element = elements.get(elements.size()-1);

        //tvResult.setText(element.getResult());
    }

    public static boolean isEmpty(ArrayList<EditText> editTexts){

        for(int i=0; i<editTexts.size(); i++){
            if(editTexts.get(i).getText().toString().equals("")){
                return false;
            }
        }

        return true;
    }

    public String formatFloat(double number){ return numberFormat.format(number); }

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

        dialog = new Dialog(this);
        dialog.setTitle("All Elements");
        dialog.setContentView(R.layout.keyboardall_layout);

        Display display = getWindowManager().getDefaultDisplay();
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

        Keyboard aEKeyboard = new Keyboard(getBaseContext(), R.xml.keyboardall);
        aEKeyboardView.setKeyboard(aEKeyboard);

        aEKeyboardView.setOnKeyboardActionListener(keyboardListener);

        dialog.show();
    }

    public void hideAllElementifVisible(){

        if(dialog!= null && dialog.isShowing())
            dialog.dismiss();

    }

    /*
    HashMap<String,String> dictionaryCodes = new HashMap<String,String>(){{
        put("1001","H");put("1002","He");
        put("1003","Li");put("1004","Be");put("1005","B");put("1006","C");put("1007","N");put("1008","O");put("1009","F");put("10010","Ne");
        put("1011","Na");put("1012","Mg");put("1013","Al");put("1014","Si");put("1015","P");put("1016","S");put("1017","Cl");put("1018","Ar");
        put("1019","K");put("1020","Ca");put("1021","Sc");put("1022","Ti");put("1023","V");put("1024","Cr");put("1025","Mn");put("1026","Fe");put("1027","Co");put("1028","Ni");put("1029","Cu");put("1030","Zn");put("1031","Ga");put("1032","Ge");put("1033","As");put("1034","Se");put("1035","Br");put("1036","Kr");
        put("1037","Rb");put("1038","Sr");put("1039","Y");put("1040","Zr");put("1041","Nb");put("1042","Mo");put("1043","Tc");put("1044","Ru");put("1045","Rh");put("1046","Pd");put("1047","Ag");put("1048","Cd");put("1049","In");put("1050","Sn");put("1051","Sb");put("1052","Te");put("1053","I");put("1054","Xe");
        put("1055","Cs");put("1056","Ba");put("1057","La");put("1058","Ce");put("1059","Pr");put("1060","Nd");put("1061","Pm");put("1062","Sm");put("1063","Eu");put("1064","Gd");put("1065","Tb");put("1066","Dy");put("1067","Ho");put("1068","Er");put("1069","Tm");put("1070","Yb");put("1071","Lu");put("1072","Hf");put("1073","Ta");put("1074","W");put("1075","Re");put("1076","Os");put("1077","Ir");put("1078","Pt");put("1079","Au");put("1080","Hg");put("1081","Tl");put("1082","Pb");put("1083","Bi");put("1084","Po");put("1085","At");put("1086","Rn");
        put("1087","Fr");put("1088","Ra");put("1089","Ac");put("1090","Th");put("1091","Pa");put("1092","U");put("1093","Np");put("1094","Pu");put("1095","Am");put("1096","Cm");put("1097","Bk");put("1098","Cf");put("1099","Es");put("1100","Fm");put("1101","Md");put("1102","No");put("1103","Lr");put("1104","Rf");put("1105","Db");put("1106","Sg");put("1107","Bh");put("1108","Hs");put("1109","Mt");put("1110","Ds");put("1111","Rg");put("1112","Cn");put("1113","Uut");put("1114","Fl");put("1115","Uup");put("1116","Lv");put("1117","Uus");put("1118","Uuo");
    }};
*/
}
