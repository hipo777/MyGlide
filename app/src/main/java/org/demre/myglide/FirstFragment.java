package org.demre.myglide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.demre.myglide.databinding.FragmentFirstBinding;
import java.util.ArrayList;
import java.util.List;
public class FirstFragment extends Fragment implements MyAdapter.OnItemClickListener {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        //Datos de ejemplo
        List<ItemImagens> imageItems = new ArrayList<>();
        imageItems.add(new ItemImagens("https://www.nationalgeographic.com.es/medio/2022/06/30/el-planeta-mercurio_48c3a79c_800x450.jpg", "Con un tamaño tan solo un poco mayor al de nuestra luna, es el planeta más pequeño del sistema solar y el más cercano al Sol.","Mercurio"));
        imageItems.add(new ItemImagens("https://www.nationalgeographic.com.es/medio/2022/06/30/el-planeta-venus_d6349041_800x800.jpg", "Solo tras el Sol y la Luna, Venus es el objeto más brillante que se puede ver en el firmamento desde la Tierra.", "Venus"));
        imageItems.add(new ItemImagens("https://www.nationalgeographic.com.es/medio/2022/06/30/el-planeta-tierra_608b9ad4_800x800.jpg", "Nuestro hogar, la Tierra, es el quinto planeta más grande y el tercero en cercanía al Sol del sistema solar.", "Tierra"));
        imageItems.add(new ItemImagens("https://www.nationalgeographic.com.es/medio/2022/06/30/el-planeta-marte_e9b53cea_800x758.jpg", "Se trata de un planeta sencillo de identificar en el firmamento nocturno debido al brillo rojizo que hace honor a su nombre.", "Marte"));
        imageItems.add(new ItemImagens("https://www.nationalgeographic.com.es/medio/2022/06/30/el-planeta-jupiter_62aed912_800x800.jpg", "Como no podía ser de otra manera, Júpiter, con más del doble de la masa que el resto de planetas juntos, es el planeta más grande del sistema solar .", "Júpiter"));


        //Configurar el RecyclerView con el adaptador
        MyAdapter adapter = new MyAdapter(requireContext(), imageItems);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);

        //navegar al segundo fragmento
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemImagens item) {
                //Obtener el navController
                NavController navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView);

                //Crear el bundle con los datos a pasar al segundo fragmento
                Bundle bundle = new Bundle();
                bundle.putString("image_url", item.getImageUrl());
                bundle.putString("description",item.getDescription());

                //Realizar la navegacion al segundo fragmento
                navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle);

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(ItemImagens item) {

    }
}