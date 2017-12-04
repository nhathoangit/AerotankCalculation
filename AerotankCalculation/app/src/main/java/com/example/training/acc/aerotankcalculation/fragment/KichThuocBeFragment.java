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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KichThuocBeFragment extends BaseFragment {
    @BindView(R.id.fragKTBe_etTB)
    EditText etTB;
    @BindView(R.id.fragKTBe_etBODRa)
    EditText etBODRa;
    @BindView(R.id.fragKTBe_etBODVao)
    EditText etBODVao;
    @BindView(R.id.fragKTBe_etH)
    EditText etH;
    @BindView(R.id.fragKTBe_etHBV)
    EditText etHBV;
    @BindView(R.id.fragKTBe_etKD)
    EditText etKD;
    @BindView(R.id.fragKTBe_etL)
    EditText etL;
    @BindView(R.id.fragKTBe_etQtb)
    EditText etQtb;
    @BindView(R.id.fragKTBe_etX)
    EditText etX;
    @BindView(R.id.fragKTBe_etY)
    EditText etY;
    @BindView(R.id.fragKTBe_tvKetQua)
    TextView tvKetQua;
    @BindView(R.id.fragKTBe_tvChieuRongBe)
    TextView tvChieuRongBe;
    @BindView(R.id.fragKTBe_tvTheTichBe)
    TextView tvTheTichBe;
    @BindView(R.id.fragKTBe_tvThoiGianLuuNuoc)
    TextView tvThoiGianLuuNuoc;

    private double mChieuRongBe, mTheTichBe, mTimeLuuNuoc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kich_thuoc_be, container, false);
        setActionBarBack(view, getString(R.string.kich_thuoc_be).toUpperCase());
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fragKTBe_tvKetQua)
    protected void onClick() {
        double qTB = Double.parseDouble(etQtb.getText().toString());
        double y = Double.parseDouble(etY.getText().toString());
        double tb = Double.parseDouble(etTB.getText().toString());
        double bodVao = Double.parseDouble(etBODVao.getText().toString());
        double bodRa = Double.parseDouble(etBODRa.getText().toString());
        double x = Double.parseDouble(etX.getText().toString());
        double kd = Double.parseDouble(etKD.getText().toString());
        double h = Double.parseDouble(etH.getText().toString());
        double hbv = Double.parseDouble(etHBV.getText().toString());
        double l = Double.parseDouble(etL.getText().toString());
        mTheTichBe = AppUtils.theTichBe(qTB, y, tb, bodVao, bodRa, x, kd);
        mChieuRongBe = AppUtils.chieuRongBe(h, l, mTheTichBe);
        mTimeLuuNuoc = AppUtils.thoiGianLuuNuoc(mTheTichBe,qTB);
        tvTheTichBe.setText(getText(R.string.kq_the_tich_be) + " " + String.valueOf(mTheTichBe) + " m³");
        tvChieuRongBe.setText(getText(R.string.kq_chieu_rong_be) + " " + String.valueOf(mChieuRongBe) + " m");
        tvThoiGianLuuNuoc.setText(getText(R.string.kq_thoi_gian_luu_nuoc) + " " + String.valueOf(mTimeLuuNuoc) + " h");
    }
}
