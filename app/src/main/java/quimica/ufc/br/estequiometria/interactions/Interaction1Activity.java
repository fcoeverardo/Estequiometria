package quimica.ufc.br.estequiometria.interactions;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.adapters.TabAdapter;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.fragments.Interaction1Fragment;

public class Interaction1Activity extends BasicActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction1);

        setUpToolbar(getString(R.string.int1Name));

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(Interaction1Fragment.newInstance(R.string.tvi11));
        fragments.add(Interaction1Fragment.newInstance(R.string.tvi12));
        fragments.add(Interaction1Fragment.newInstance(R.string.tvi13));
        fragments.add(Interaction1Fragment.newInstance(R.string.tvi14));

        setUpSlidingTab(new TabAdapter(getSupportFragmentManager(), this, getResources().getStringArray(R.array.elements), fragments));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
