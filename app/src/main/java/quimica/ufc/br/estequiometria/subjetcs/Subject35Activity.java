package quimica.ufc.br.estequiometria.subjetcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.BasicActivity;
import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;
import quimica.ufc.br.estequiometria.interactions.Interaction13Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction9Activity;

public class Subject35Activity extends BasicActivity {

    TextView tv35_1;
    Button btIntm3t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject35);

        setUpToolbar(getResources().getStringArray(R.array.module3Topics)[4]);

        btIntm3t5 = (Button) findViewById(R.id.btIntm3t5);

        tv35_1 = (TextView) findViewById(R.id.tv35_1);

        tv35_1.setText(HtmlCompat.fromHtml(getString(R.string.m3t5_1)));

        btIntm3t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Subject35Activity.this, Interaction9Activity.class));
            }
        });

    }
}
