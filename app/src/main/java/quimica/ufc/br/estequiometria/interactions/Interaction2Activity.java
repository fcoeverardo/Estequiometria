package quimica.ufc.br.estequiometria.interactions;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.adapters.TabAdapter;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.fragments.Interaction2Fragment;

public class Interaction2Activity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction2);

        setUpToolbar(getString(R.string.int1Name));

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Interaction2Fragment.newInstance(0));
        fragments.add(Interaction2Fragment.newInstance(1));
        fragments.add(Interaction2Fragment.newInstance(2));
        fragments.add(Interaction2Fragment.newInstance(3));

        setUpSlidingTab(new TabAdapter(getSupportFragmentManager(), this, getResources().getStringArray(R.array.elements2), fragments));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
