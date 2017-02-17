package quimica.ufc.br.estequiometria.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.adapters.TabAdapter;

public class TestActivity extends InteractionAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setUpToolbar("Tela de Testes");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Test2Fragment());
        fragments.add(new Test1Fragment());

        setUpSlidingTab(new TabAdapter(getSupportFragmentManager(), this, new String[]{"Interações", "Teclado"}, fragments));

    }


    @Override
    public void onBackPressed() {
        //hideCustomKeyboardIfVisible();
    }


}
