package quimica.ufc.br.estequiometria;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.interactions.Interaction11Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction13Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction7Activity;
import quimica.ufc.br.estequiometria.models.Topic;
import quimica.ufc.br.estequiometria.adapters.TopicAdapter;
import quimica.ufc.br.estequiometria.subjetcs.Subject11Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject12Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject13Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject14Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject15Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject16Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject21Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject22Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject23Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject24Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject25Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject31Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject32Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject33Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject34Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject35Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject41Activity;
import quimica.ufc.br.estequiometria.subjetcs.Subject43Activity;
import quimica.ufc.br.estequiometria.test.TestActivity;

public class TopicsActivity extends BasicActivity {

    private int topic;
    private String title;
    private String descriptiion;
    private String[] arrTopics;
    private String[] arrTopicsDesc;
    private ArrayList<Topic> topics;

    private int[][] layouts;

    private Resources resources;

    private TextView tvTopicDes;
    private ListView lvTopics;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        layouts = new int[][]{
                {R.layout.activity_subject11,
                R.layout.activity_subject12,
                R.layout.activity_subject13,
                R.layout.activity_subject14,
                R.layout.activity_subject15,
                R.layout.activity_subject16},
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        resources = getResources();

        tvTopicDes = (TextView) findViewById(R.id.tvTopicDes);
        lvTopics = (ListView) findViewById(R.id.lvTopics);

        topics = new ArrayList<>();

        Intent extras = getIntent();
        if(extras != null){
            Bundle params = extras.getExtras();
            if(params!=null){
                topic = params.getInt("item");
                getStrings(topic);
            }
        }



    }

    private void getStrings(int topic){

        switch(topic){
            case 0:
                title = resources.getStringArray(R.array.modulesNames)[0];
                descriptiion = getString(R.string.m1d);
                arrTopics = resources.getStringArray(R.array.module1Topics);
                arrTopicsDesc = resources.getStringArray(R.array.module1TopicsDesc);
                break;

            case 1:
                title = resources.getStringArray(R.array.modulesNames)[1];
                descriptiion = getString(R.string.m2d);
                arrTopics = resources.getStringArray(R.array.module2Topics);
                arrTopicsDesc = resources.getStringArray(R.array.module2TopicsDesc);
                break;

            case 2:
                title = resources.getStringArray(R.array.modulesNames)[2];
                descriptiion = getString(R.string.m3d);
                arrTopics = resources.getStringArray(R.array.module3Topics);
                arrTopicsDesc = resources.getStringArray(R.array.module3TopicsDesc);
                break;

            case 3:
                title = resources.getStringArray(R.array.modulesNames)[3];
                descriptiion = getString(R.string.m4d);
                arrTopics = resources.getStringArray(R.array.module4Topics);
                arrTopicsDesc = resources.getStringArray(R.array.module4TopicsDesc);
                break;


            default:
                finish();

        }

        setUpToolbar(title);
        tvTopicDes.setText(descriptiion);

        for(int i=0;i<arrTopics.length;i++) {
            topics.add(new Topic(arrTopics[i],""));
        }

        Log.d(MainActivity.TAG, "topicDesc: " + arrTopicsDesc.length);
        TopicAdapter topicAdapter = new TopicAdapter(this,topics);


        lvTopics.setAdapter(topicAdapter);

        lvTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                //long item = lvTopics.getSelectedItemId();

                if(getTopic() == 0){
                    switch ((int)id){
                        case 0:
                            startActivity(new Intent(TopicsActivity.this, Subject11Activity.class));
                            break;
                        case 1:
                            startActivity(new Intent(TopicsActivity.this, Subject12Activity.class));
                            break;
                        case 2:
                            startActivity(new Intent(TopicsActivity.this, Subject13Activity.class));
                            break;
                        case 3:
                            startActivity(new Intent(TopicsActivity.this, Subject14Activity.class));
                            break;
                        case 4:
                            startActivity(new Intent(TopicsActivity.this, Subject15Activity.class));
                            break;

                    }

                }else if(getTopic() == 1){
                    switch ((int)id){
                        case 0:
                            startActivity(new Intent(TopicsActivity.this, Subject21Activity.class));
                            break;
                        case 1:
                            startActivity(new Intent(TopicsActivity.this, Subject22Activity.class));
                            break;
                        case 2:
                            startActivity(new Intent(TopicsActivity.this, Subject23Activity.class));
                            break;
                        case 3:
                            startActivity(new Intent(TopicsActivity.this, Subject24Activity.class));
                            break;
                        case 4:
                            startActivity(new Intent(TopicsActivity.this, Subject25Activity.class));
                            break;
                    }

                }else if(getTopic() == 2){
                    switch ((int)id){
                        case 0:
                            //startActivity(new Intent(TopicsActivity.this, Interaction4Activity.class));
                            startActivity(new Intent(TopicsActivity.this, Subject31Activity.class));
                            break;
                        case 1:
                            //startActivity(new Intent(TopicsActivity.this, Interaction5Activity.class));
                            startActivity(new Intent(TopicsActivity.this, Subject32Activity.class));
                            break;
                        case 2:
                            //startActivity(new Intent(TopicsActivity.this, Interaction6Activity.class));
                            startActivity(new Intent(TopicsActivity.this, Subject33Activity.class));
                            break;
                        case 3:
                            //startActivity(new Intent(TopicsActivity.this, Interaction8Activity.class));
                            startActivity(new Intent(TopicsActivity.this, Subject34Activity.class));
                            //startActivity(new Intent(TopicsActivity.this, Interaction7Activity.class));
                            break;
                        case 4:
                            startActivity(new Intent(TopicsActivity.this, Subject35Activity.class));
                            break;
                    }

                }else if(getTopic() == 3){
                    switch((int)id){
                        case 0:

                            startActivity(new Intent(TopicsActivity.this, Subject41Activity.class));
                            break;
                        case 1:
                            //startActivity(new Intent(TopicsActivity.this, Interaction13Activity.class));
                            break;
                        case 2:
                            startActivity(new Intent(TopicsActivity.this, Subject43Activity.class));
                            break;
                        case 3:
                            startActivity(new Intent(TopicsActivity.this, Interaction7Activity.class));
                            break;
                        case 4:
                            startActivity(new Intent(TopicsActivity.this, Interaction7Activity.class));
                            break;
                    }

                }

                else {

                    Log.d(MainActivity.TAG, arrTopics[(int) id]);

                    Intent intent = new Intent(TopicsActivity.this, SubjectActivity.class);
                    intent.putExtra("layout", getLayout((int) id));
                    intent.putExtra("title", arrTopics[(int) id]);
                    startActivity(intent);
                }
            }
        });





    }

    public int getTopic() {
        return topic;
    }

    public int getLayout(int item){
        return layouts[topic][item];
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topics, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
