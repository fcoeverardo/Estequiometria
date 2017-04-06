package quimica.ufc.br.estequiometria;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.InteractionAcitivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.adapters.TabAdapter;
import quimica.ufc.br.estequiometria.test.Test1Fragment;
import quimica.ufc.br.estequiometria.test.Test2Fragment;

public class AllInterationsActivity extends InteractionAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allinteration);

        setUpToolbar("Todas as Interações");


    }


    @Override
    public void onBackPressed() {
        //hideCustomKeyboardIfVisible();
    }


}
