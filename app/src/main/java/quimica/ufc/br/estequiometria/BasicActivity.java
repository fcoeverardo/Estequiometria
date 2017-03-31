package quimica.ufc.br.estequiometria;

import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import quimica.ufc.br.estequiometria.adapters.TabAdapter;
import quimica.ufc.br.estequiometria.extras.SlidingTabLayout;

public class BasicActivity extends AppCompatActivity {

    protected static final String VIDEO_EXTRA = "video";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setUpToolbar(String title){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null){
            toolbar.setTitle((title==null? "" :title));

            setSupportActionBar(toolbar);

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    public void setUpSlidingTab(TabAdapter adapter){
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.stlInteraction1);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpTabs);

        if(slidingTabLayout != null && viewPager != null) {
            viewPager.setAdapter(adapter);

            slidingTabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
            slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.colorAccent));
            slidingTabLayout.setDistributeEvenly(true);

            slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });

            slidingTabLayout.setViewPager(viewPager);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return false;
    }

    public void setUpFullScreen(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

}
