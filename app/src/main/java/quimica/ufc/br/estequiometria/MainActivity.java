package quimica.ufc.br.estequiometria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

import quimica.ufc.br.estequiometria.models.Module;
import quimica.ufc.br.estequiometria.adapters.ModuleAdapter;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Estequiometria";

    private Resources res;
    private String[] modulesNames,modulesDescription;
    private List<Drawable> images = new ArrayList<>();

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(TAG,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Thread intro = new Thread(new Runnable() {
            @Override
            public void run() {

                boolean isFirstUse = sharedPreferences.getBoolean("isFirstUse",true);

                if(isFirstUse){
                    startActivity(new Intent(MainActivity.this, Intro.class));
                    editor.putBoolean("isFirstUse", false);
                    editor.apply();
                }

            }
        });

        intro.start();

        setContentView(R.layout.activity_main);

        res = getResources();
        modulesNames = res.getStringArray(R.array.modulesNames);
        modulesDescription = res.getStringArray(R.array.modulesNames);

        context = MainActivity.this;
        images.add(ContextCompat.getDrawable(context, R.drawable.mod1));
        images.add(ContextCompat.getDrawable(context, R.drawable.mod2));
        images.add(ContextCompat.getDrawable(context, R.drawable.mod3));
        images.add(ContextCompat.getDrawable(context, R.drawable.mod4));
        images.add(ContextCompat.getDrawable(context, R.drawable.mod2));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        ModuleAdapter moduleAdapter = new ModuleAdapter(createList(modulesNames,modulesDescription,images));
        recList.setAdapter(moduleAdapter);
    }

    private List<Module> createList(String[] names, String[] descriptions, List<Drawable> images) {

        List<Module> result = new ArrayList<Module>();
        for (int i=0; i < names.length; i++) {
            Module module = new Module();
            module.setName(names[i]);
            module.setDescription(descriptions[i]);
            module.setImage(images.get(i));

            result.add(module);

        }

        return result;
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
