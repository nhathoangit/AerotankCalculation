package com.example.training.acc.aerotankcalculation.fragment;
/*
 * Created by NhatHoang on 03/12/2017.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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

public class KiemTraThongSoFragment extends BaseFragment {

    @BindView(R.id.fragKTThongSo_etBODVao)
    EditText etBODVao;
    @BindView(R.id.fragKTThongSo_etQTB)
    EditText etQTB;
    @BindView(R.id.fragKTThongSo_etTheTichBe)
    EditText etTheTichBe;
    @BindView(R.id.fragKTThongSo_etTimeLuuNuoc)
    EditText etTimeLuuNuoc;
    @BindView(R.id.fragKTThongSo_etX)
    EditText etX;
    @BindView(R.id.fragKTThongSo_tvTaiTrongTheTich)
    TextView tvTaiTrongTheTich;
    @BindView(R.id.fragKTThongSo_tvTySoFM)
    TextView tvTySoFM;

    private double mTaiTrongTheTich, mTySoFM;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kiem_tra_thong_so, container, false);
        setActionBarBack(view, getString(R.string.kiem_tra_thong_so).toUpperCase());
        ButterKnife.bind(this, view);
        KeyboardUtils.setupUI(view,getActivity());
        return view;
    }

    @OnClick(R.id.fragKTThongSo_tvKetQua)
    protected void onClick() {
        double bodVao = Double.parseDouble(etBODVao.getText().toString());
        double qTB = Double.parseDouble(etQTB.getText().toString());
        double v = Double.parseDouble(etTheTichBe.getText().toString());
        double t = Double.parseDouble(etTimeLuuNuoc.getText().toString());
        double x = Double.parseDouble(etX.getText().toString());
        mTySoFM = AppUtils.tySoFM(bodVao, t, x);
        mTaiTrongTheTich = AppUtils.taiTrongTheTich(bodVao, qTB, v);
        if (mTySoFM >= 0.2 && mTySoFM <= 0.6) {
            tvTySoFM.setText(getText(R.string.kq_ty_so_fm) + " " + String.valueOf(mTySoFM) + " mg/mg nằm trong khoảng 0.2 - 0.6");
            tvTySoFM.setTextColor(Color.BLACK);
        } else {
            tvTySoFM.setText(getText(R.string.kq_ty_so_fm) + " " + String.valueOf(mTySoFM) + " mg/mg " + getString(R.string.khong_hop_ly));
            tvTySoFM.setTextColor(Color.RED);
        }
        if (mTaiTrongTheTich >= 0.8 && mTaiTrongTheTich <= 1.69) {
            tvTaiTrongTheTich.setText(getText(R.string.kq_tai_trong_the_tich) + " " + String.valueOf(mTaiTrongTheTich) + " kgBOD/m³.ngày nằm trong khoảng 0.8 - 1.69");
            tvTaiTrongTheTich.setTextColor(Color.BLACK);
        } else {
            tvTaiTrongTheTich.setText(getText(R.string.kq_tai_trong_the_tich) + " " + String.valueOf(mTaiTrongTheTich) + " kgBOD/m³.ngày " + getString(R.string.khong_hop_ly));
            tvTaiTrongTheTich.setTextColor(Color.RED);
        }


    }
}
