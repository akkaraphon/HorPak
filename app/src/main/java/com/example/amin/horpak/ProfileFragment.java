package com.example.amin.horpak;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amin.horpak.Adapter.ProfileAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

//        getActivity().setContentView(R.layout.fragment_profile);
//        ProfileAdapter.with(getActivity()).init().loadAbout();

        // Inflate the layout for this fragment
        return view;
    }

}
