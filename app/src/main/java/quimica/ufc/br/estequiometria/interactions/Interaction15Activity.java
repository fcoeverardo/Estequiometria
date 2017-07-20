package quimica.ufc.br.estequiometria.interactions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.adapters.TabAdapter;
import quimica.ufc.br.estequiometria.fragments.Interaction81Fragment;
import quimica.ufc.br.estequiometria.fragments.Interaction82Fragment;

public class Interaction15Activity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction15);

        setUpToolbar(getString(R.string.int8Title));

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Interaction81Fragment());
        fragments.add(new Interaction82Fragment());

        setUpSlidingTab(new TabAdapter(getSupportFragmentManager(), this, getResources().getStringArray(R.array.tab15Names), fragments));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
