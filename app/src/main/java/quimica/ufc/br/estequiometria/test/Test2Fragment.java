package quimica.ufc.br.estequiometria.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.adapters.TopicAdapter;
import quimica.ufc.br.estequiometria.interactions.Interaction10Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction11Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction12Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction13Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction14Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction1Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction2Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction3Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction4Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction52Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction6Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction7Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction8Activity;
import quimica.ufc.br.estequiometria.interactions.Interaction9Activity;
import quimica.ufc.br.estequiometria.models.Topic;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Test2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Test2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Test2Fragment extends Fragment {

    private ListView lvInteraction;

    public Test2Fragment() {
        // Required empty public constructor
    }

    public static Test2Fragment newInstance(String param1, String param2) {
        Test2Fragment fragment = new Test2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_test2, container, false);

        lvInteraction = (ListView) view.findViewById(R.id.lvInteractions);

        ArrayList<Topic> topics = new ArrayList<>();

        for(int i=0;i<14;i++) {
            topics.add(new Topic("Interação "+(i+1),""));
        }

        TopicAdapter topicAdapter = new TopicAdapter(getActivity(),topics);


        lvInteraction.setAdapter(topicAdapter);

        lvInteraction.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {


                switch ((int) id) {
                    case 0:
                        startActivity(new Intent(getActivity(), Interaction1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), Interaction2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), Interaction3Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), Interaction4Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), Interaction52Activity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), Interaction6Activity.class));
                        break;
                    case 6:
                        startActivity(new Intent(getActivity(), Interaction7Activity.class));
                        break;
                    case 7:
                        startActivity(new Intent(getActivity(), Interaction8Activity.class));
                        break;
                    case 8:
                        startActivity(new Intent(getActivity(), Interaction9Activity.class));
                        break;
                    case 9:
                        startActivity(new Intent(getActivity(), Interaction10Activity.class));
                        break;
                    case 10:
                        startActivity(new Intent(getActivity(), Interaction11Activity.class));
                        break;
                    case 11:
                        startActivity(new Intent(getActivity(), Interaction12Activity.class));
                        break;
                    case 12:
                        startActivity(new Intent(getActivity(), Interaction13Activity.class));
                        break;
                    case 13:
                        startActivity(new Intent(getActivity(), Interaction14Activity.class));
                        break;


                }
            }});


        return view;
    }

}
