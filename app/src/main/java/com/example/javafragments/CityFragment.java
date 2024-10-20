package com.example.javafragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CityFragment extends Fragment {
    private OnFragmentDataListener onFragmentDataListener;
    private ArrayAdapter<String> adapter;
    private List<String> cityes = new ArrayList<>(List.of("Москва", "Санкт-Петербург", "Казань", "Самара", "Челябинск"));
    private TextView titleTV;
    private ListView cityesLV;

    @SuppressLint("UseRequireInsteadOfGet")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onFragmentDataListener = (OnFragmentDataListener) requireActivity();
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        cityesLV = view.findViewById(R.id.cityesLV);
        titleTV = view.findViewById(R.id.titleFirstFragmentTV);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, cityes);
        cityesLV.setAdapter(adapter);

        cityesLV.setOnItemClickListener((parent, mView, position, id) -> {
            String itemSelected = (String) parent.getItemAtPosition(position);
            onFragmentDataListener.onData(itemSelected);
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getArguments() != null) {
            String city = getArguments().getString("newCity");
            if (city != null) {
                titleTV.setText(city);
                String key = getArguments().getString("key");
                int index = search(cityes, key);
                swap(cityes, index, city);
                adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, cityes);
                cityesLV.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void swap(List<String> cityes, int index, String city) {
        cityes.add(index + 1, city);
        cityes.remove(index);
    }

    private int search(List<String> cityes, String key) {
        int result = -1;
        for (int i = 0; i < cityes.size(); i++) {
            if (key.equals(cityes.get(i))) result = i;
        }
        return result;
    }
}