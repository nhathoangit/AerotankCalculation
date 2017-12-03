package com.example.training.acc.aerotankcalculation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.training.acc.aerotankcalculation.R;
import com.example.training.acc.aerotankcalculation.base.BaseActivity;
import com.example.training.acc.aerotankcalculation.fragment.HomeFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new HomeFragment(), true);
    }
}
