package quimica.ufc.br.estequiometria.subjetcs;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.interactions.Interaction2Activity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.BasicActivity;

public class Subject13Activity extends BasicActivity {

    TextView tv13_3,tv13_2;
    Button btInt2;
    Resources resources;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject13);

        tv13_3 = (TextView) findViewById(R.id.tv13_3);
        tv13_3.setText(HtmlCompat.fromHtml(getString(R.string.m1t3_3)));

        tv13_2 = (TextView) findViewById(R.id.tv13_2);
        tv13_2.setText(HtmlCompat.fromHtml(getString(R.string.m1t3_2)));

        resources = getResources();

        title = resources.getStringArray(R.array.module1Topics)[2];

        setUpToolbar(title);

        //btInt2 = (Button) findViewById(R.id.btInteraction2);
        //btInt2.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View v) {
        //        startActivity(new Intent(Subject13Activity.this, Interaction2Activity.class));
         //   }
       // });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
