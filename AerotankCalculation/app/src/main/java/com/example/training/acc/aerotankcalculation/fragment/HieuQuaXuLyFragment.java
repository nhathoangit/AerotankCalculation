package com.example.training.acc.aerotankcalculation.fragment;
/*
 * Created by NhatHoang on 03/12/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.training.acc.aerotankcalculation.R;
import com.example.training.acc.aerotankcalculation.base.BaseFragment;
import com.example.training.acc.aerotankcalculation.utils.AppUtils;
import com.example.training.acc.aerotankcalculation.utils.KeyboardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HieuQuaXuLyFragment extends BaseFragment {

    @BindView(R.id.fragHieuQua_etBOD)
    EditText etBOD;
    @BindView(R.id.fragHieuQua_etCOD)
    EditText etCOD;
    @BindView(R.id.fragHieuQua_etBODRa)
    EditText etBODRa;
    @BindView(R.id.fragHieuQua_etSSRa)
    EditText etSSRa;
    @BindView(R.id.fragHieuQua_tvHieuQuaXuLy)
    TextView tvHieuQuaXuLy;
    @BindView(R.id.fragHieuQua_tvLuongBODHoaTan)
    TextView tvLuongBODHoaTan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hieu_qua_xu_ly, container, false);
        setActionBarBack(view, getString(R.string.hieu_qua_xu_ly).toUpperCase());
        KeyboardUtils.setupUI(view, getActivity());
        ButterKnife.bind(this, view);
        KeyboardUtils.setupUI(view,getActivity());
        return view;
    }

    @OnClick(R.id.fragHieuQua_tvKetQua)
    public void onClick() {
        double bod = Double.parseDouble(etBOD.getText().toString());
        double cod = Double.parseDouble(etCOD.getText().toString());
        double bodRa = Double.parseDouble(etBODRa.getText().toString());
        double ssRa = Double.parseDouble(etSSRa.getText().toString());
        double mLuongBODHoaTan = Math.round(AppUtils.luongBODHoaTan(bod, cod, bodRa, ssRa));
        double mHieuQuaXuLy = Math.round(AppUtils.hieuQuaXuLy(bod, mLuongBODHoaTan));
        tvLuongBODHoaTan.setText(getText(R.string.kq_bod) + " " + String.valueOf(mLuongBODHoaTan) + " mg/l");
        tvHieuQuaXuLy.setText(getText(R.string.kq_hieu_qua_bod) + " " + String.valueOf(mHieuQuaXuLy) + " %");
    }
}
