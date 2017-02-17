package quimica.ufc.br.estequiometria.adapters;

/**
 * Created by root on 22/03/16.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import quimica.ufc.br.estequiometria.*;
import quimica.ufc.br.estequiometria.models.Module;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {

    private List<Module> moduleList;

    public ModuleAdapter(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public int getItemCount() {
        return moduleList.size();
    }

    @Override
    public void onBindViewHolder(ModuleViewHolder moduleViewHolder, int i) {
        Module module = moduleList.get(i);
        moduleViewHolder.vName.setText(module.getName());
        moduleViewHolder.vDescription.setText(module.getDescription());
        moduleViewHolder.ivCard.setImageDrawable(module.getImage());
        moduleViewHolder.setCurrentItem(i);
    }

    @Override
    public ModuleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.module_card, viewGroup, false);

        return new ModuleViewHolder(itemView);
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName, vDescription;
        protected ImageView ivCard;

        private int currentItem;

        public void setCurrentItem(int currentItem){
            this.currentItem = currentItem;
        }

        public int getCurrentItem(){
            return this.currentItem;
        }

        public ModuleViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.tvModuleName);
            vDescription = (TextView)  v.findViewById(R.id.tvModuleDescription);
            ivCard = (ImageView) v.findViewById(R.id.imgvModule);

            v.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked

                    Log.d(MainActivity.TAG,"Clicked item: "+getCurrentItem());

                    Intent it = new Intent(v.getContext(), TopicsActivity.class);
                    it.putExtra("item", getCurrentItem());
                    v.getContext().startActivity(it);

                }
            });

        }
    }

}
