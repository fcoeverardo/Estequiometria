package quimica.ufc.br.estequiometria.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by root on 25/04/16.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private Context context;
    private String[] titles;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public TabAdapter(FragmentManager fm, Context context, String[] titles, ArrayList<Fragment> fragments) {
        super(fm);

        this.context = context;
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titles[position]);
    }
}
