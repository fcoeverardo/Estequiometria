package quimica.ufc.br.estequiometria.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.extras.HtmlCompat;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link } interface
 * to handle interaction events.
 * Use the {@link Interaction1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Interaction1Fragment extends Fragment {

    TextView tvi1;

    public Interaction1Fragment() {
        // Required empty public constructor
    }

    public static Interaction1Fragment newInstance(int content) {
        Interaction1Fragment instance = new Interaction1Fragment();

        Bundle args = new Bundle();
        args.putInt("content",content);
        instance.setArguments(args);

        return instance;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_interaction1, container, false);


        tvi1 = (TextView) view.findViewById(R.id.tvi1);

        tvi1.setText(HtmlCompat.fromHtml(getString(getArguments().getInt("content", 0))));

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/

}
