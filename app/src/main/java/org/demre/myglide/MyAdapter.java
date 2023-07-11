package org.demre.myglide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import org.demre.myglide.databinding.ItemListBinding;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<ItemImagens> imageItems;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, List<ItemImagens> imageItems) {
        this.context = context;
        this.imageItems = imageItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemImagens item = imageItems.get(position);

        Glide.with(context)
                .load(item.getImageUrl())
                .into(holder.imageView);



        holder.txtDesc.setText(item.getPlanetas());

        holder.itemView.setOnClickListener(v -> {
            onItemClickListener.onItemClick(imageItems.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ItemImagens item);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtDesc;

        ItemListBinding binding;

        public MyViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());

            imageView = binding.ivPreguntas;
            txtDesc = binding.txtViewItem;

        }
    }

}
