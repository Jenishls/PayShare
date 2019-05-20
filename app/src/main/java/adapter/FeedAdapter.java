package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.e.payshare.ItemData;
import com.e.payshare.R;
import java.util.List;

import model.Feed;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder>{
    private ItemData[] itemsData;

    public FeedAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_expense, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.lbName.setText(itemsData[i].getTitle());
        viewHolder.imgView.setImageResource(itemsData[i].getImageUrl());
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView lbName;
        public ImageView imgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lbName = itemView.findViewById(R.id.lbItem);
            imgView = itemView.findViewById(R.id.imgProfile);

        }
    }

}
