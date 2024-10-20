package com.example.javafragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DetailsFragment extends Fragment implements OnFragmentDataListener {
    private OnFragmentDataListener onFragmentDataListener;
    private EditText textView;
    private Button saveBTN;
    private String city;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onFragmentDataListener = (OnFragmentDataListener) requireActivity();
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        city = getArguments().getString("city");
        textView = view.findViewById(R.id.detailsTV);
        saveBTN = view.findViewById(R.id.saveBTN);
        textView.setText(city);
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = textView.getText().toString();
                onData(value);
            }
        });
        return view;
    }

    @Override
    public void onData(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("newCity", data);
        bundle.putString("key", city);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        CityFragment cityFragment = new CityFragment();
        cityFragment.setArguments(bundle);

        transaction.replace(R.id.containerID, cityFragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}

