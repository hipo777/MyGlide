package org.demre.myglide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.demre.myglide.databinding.FragmentFirstBinding;
import java.util.ArrayList;
import java.util.List;
public class FirstFragment extends Fragment {
    FragmentFirstBinding binding;
    private List<String> datos= new ArrayList<>();;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        initRecycler();
        initListerner();
        return binding.getRoot();
    }

    private void initListerner() {
        binding.btnAgregar.setOnClickListener(v -> {
            datos.add("Pregunta " + (datos.size()+1));
            binding.recyclerView.getAdapter().notifyItemInserted(datos.size());
            binding.recyclerView.smoothScrollToPosition(datos.size());
        });

    }

    private void initRecycler() {
        MyAdapter adaptador = new MyAdapter(listaAutogenerada());
        binding.recyclerView.setAdapter(adaptador);

    }

    private List<String> listaAutogenerada() {
        for (int i = 1; i <=5; i++) {
            datos.add("Pregunta " + i);
        }
        return datos;
    }
}