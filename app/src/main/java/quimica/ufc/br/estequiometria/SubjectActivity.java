package quimica.ufc.br.estequiometria;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.interactions.Interaction1Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction2Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction3Activity;

public class SubjectActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ScrollView scrollView;
    private LinearLayout linearLayout;

    private String title;
    private CharSequence formatedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent extras = getIntent();
        if(extras != null){
            Bundle params = extras.getExtras();
            if(params!=null){
                setContentView(params.getInt("layout"));
                formatStrings(params.getInt("layout"));
                title = params.getString("title");
            }
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void formatStrings (int layout){
        Button button;
        TextView textView;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        return false;
    }
}
