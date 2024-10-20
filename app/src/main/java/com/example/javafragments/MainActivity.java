package com.example.javafragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements OnFragmentDataListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CityFragment cityFragment = new CityFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerID, cityFragment).commit();
    }

    @Override
    public void onData(String data) {
        Bundle bundle = new Bundle();
        bundle.putString("city", data);

        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);

        transaction.replace(R.id.containerID, detailsFragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}

