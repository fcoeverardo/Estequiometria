package quimica.ufc.br.estequiometria.subjetcs;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.interactions.Interaction1Activity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;

public class Subject12Activity extends BasicActivity {

    TextView tv12_1;
    Button btInt1;
    Resources resources;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject12);

        tv12_1 = (TextView) findViewById(R.id.tv12_1);

        tv12_1.setText(HtmlCompat.fromHtml(getString(R.string.m1t2_1)));

        resources = getResources();

        title = resources.getStringArray(R.array.module1Topics)[1];
        setUpToolbar(title);

        //btInt1 = (Button) findViewById(R.id.btInteraction1);
        //btInt1.setOnClickListener(new View.OnClickListener() {
          //  @Override
        //    public void onClick(View v) {
         //       startActivity(new Intent(Subject12Activity.this, Interaction1Activity.class));
         //   }
       // });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
