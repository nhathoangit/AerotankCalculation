package com.example.training.acc.aerotankcalculation.fragment;
/*
 * Created by NhatHoang on 03/12/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.training.acc.aerotankcalculation.R;
import com.example.training.acc.aerotankcalculation.base.BaseFragment;

public class ThietBiPhanPhoiKhiFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thiet_bi_phan_phoi_khi, container, false);
        setActionBarBack(view, getString(R.string.thiet_bi_phan_phoi_khi).toUpperCase());
        return view;
    }
}
