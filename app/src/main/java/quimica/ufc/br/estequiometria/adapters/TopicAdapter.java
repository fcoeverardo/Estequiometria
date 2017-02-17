package quimica.ufc.br.estequiometria.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.R;
import quimica.ufc.br.estequiometria.models.Topic;

/**
 * Created by root on 29/03/16.
 */
public class TopicAdapter extends BaseAdapter {

    private ArrayList<Topic> items;
    private TopicViewHolder topicViewHolder;
    private LayoutInflater vi;

    private class TopicViewHolder {
        TextView name;
        TextView address;
    }

    public TopicAdapter(Context context, ArrayList<Topic> items) {
        //Objeto responsável por pegar o Layout do item.
        vi = LayoutInflater.from(context);

        this.items = items;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = vi.inflate(R.layout.listview_item_subitem, null,true);
            topicViewHolder = new TopicViewHolder();
            topicViewHolder.name = (TextView)v.findViewById(R.id.tvTitle);
            topicViewHolder.address = (TextView)v.findViewById(R.id.tvDesc);
            v.setTag(topicViewHolder);
        } else topicViewHolder = (TopicViewHolder)v.getTag();

        Topic topic = items.get(pos);

        if (topic != null) {
            topicViewHolder.name.setText(topic.getTitle());
            topicViewHolder.address.setText(topic.getDescription());
        }

        return v;
    }

    public int getCount() {
        return items.size();
    }
    public Topic getItem(int position) {
        return items.get(position);
    }
    public long getItemId(int position) {
        return position;
    }


}
