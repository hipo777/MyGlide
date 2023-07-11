package org.demre.myglide;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.demre.myglide.databinding.ItemListBinding;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> words;//Crea una lista de String
    public MyAdapter(List<String> datos) {
        this.words = datos;}

    @NonNull
    @Override//¿Que hago cuando quiero crear un nuevo ViewHolder?
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Enlazando con el item_list
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override//¿Qué hago cuando quiero enlazar la info con el ViewHolder?
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        //Enlazar los datos con los elementos de la vista
        String palabra = words.get(position);//nos entrega la posición
        holder.textHolder.setText(palabra);// nos entrega el ViewHolder
    }

    @Override
    public int getItemCount() {//Retornar el tamaño de la listaPalabras
        return words.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textHolder;
        public ViewHolder(ItemListBinding binding) {//Generar el constructor con click derecho
            super(binding.getRoot());
            textHolder = binding.txtViewItem;
        }
    }
}