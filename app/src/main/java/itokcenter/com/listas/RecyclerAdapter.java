package itokcenter.com.listas;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PC- on 02/08/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<ItemRC> itemsRC;
    private Context context;

    public RecyclerAdapter(List<ItemRC> itemsRC, Context context) {
        this.itemsRC = itemsRC;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_rc, null); //Inflar el layout
        viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.imageView.setImageResource(itemsRC.get(position).getImg());
        holder.textView.setText(itemsRC.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setIcon(itemsRC.get(position).getImg())
                        .setTitle("Nombre")
                        .setMessage("El nombre es " + itemsRC.get(position).getName())
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsRC.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image1);
            textView = (TextView) itemView.findViewById(R.id.item_txtItem);
        }
    }

}
