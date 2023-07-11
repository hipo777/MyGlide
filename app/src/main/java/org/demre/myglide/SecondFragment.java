package org.demre.myglide;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import org.demre.myglide.databinding.FragmentFirstBinding;
import org.demre.myglide.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //Obtener los datos pasados a un Fragment a través de un Bundle
        Bundle bundle = getArguments();
        if (bundle!=null){
            String imageUrl = bundle.getString("image_url");
            String description = bundle.getString("description");

            //Utilizando glide
            Glide.with(requireContext())
                    .load(imageUrl)
                    .into(binding.ivSecondFragment);

            //Cargar la descripción
            binding.tvSecondFragment.setText(description);

        }
        //Regresando al primer fragmento
        binding.faButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_secondFragment_to_firstFragment);
        });

        return view;
    }
}