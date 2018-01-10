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

public class BunHoatTinhFragment extends BaseFragment {

    @BindView(R.id.fragBHT_etTB)
    EditText etTB;
    @BindView(R.id.fragBHT_etBODRa)
    EditText etBODRa;
    @BindView(R.id.fragBHT_etBODVao)
    EditText etBODVao;
    @BindView(R.id.fragBHT_etTheTichBe)
    EditText etTheTichBe;
    @BindView(R.id.fragBHT_etSSRa)
    EditText etSSRa;
    @BindView(R.id.fragBHT_etKD)
    EditText etKD;
    @BindView(R.id.fragBHT_etXT)
    EditText etXT;
    @BindView(R.id.fragBHT_etQtb)
    EditText etQtb;
    @BindView(R.id.fragBHT_etX)
    EditText etX;
    @BindView(R.id.fragBHT_etY)
    EditText etY;
    @BindView(R.id.fragBHT_tvKetQua)
    TextView tvKetQua;
    @BindView(R.id.fragBHT_tvLuongBun)
    TextView tvLuongBun;
    @BindView(R.id.fragBHT_tvKLBunXaRa)
    TextView tvKLBunXaRa;
    @BindView(R.id.fragBHT_tvLuuLuongTuanHoan)
    TextView tvLuuLuongTuanHoan;
    @BindView(R.id.fragBHT_tvLuuLuongXaBun)
    TextView tvLuuLuongXaBun;

    private double mLuongBun, mLuongbunXaRa, mLuuLuongTuanHoan, mLuuLuongXaBun;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bun_hoat_tinh, container, false);
        setActionBarBack(view, getString(R.string.bun_hoat_tinh).toUpperCase());
        ButterKnife.bind(this, view);
        KeyboardUtils.setupUI(view,getActivity());
        return view;
    }

    @OnClick(R.id.fragBHT_tvKetQua)
    protected void onClick() {
        double qTB = Double.parseDouble(etQtb.getText().toString());
        double y = Double.parseDouble(etY.getText().toString());
        double tb = Double.parseDouble(etTB.getText().toString());
        double bodVao = Double.parseDouble(etBODVao.getText().toString());
        double bodRa = Double.parseDouble(etBODRa.getText().toString());
        double x = Double.parseDouble(etX.getText().toString());
        double kd = Double.parseDouble(etKD.getText().toString());
        double v = Double.parseDouble(etTheTichBe.getText().toString());
        double ssRa = Double.parseDouble(etSSRa.getText().toString());
        double xt = Double.parseDouble(etXT.getText().toString());
        mLuongBun = AppUtils.luongBunSinhRa(y,kd,tb, qTB,bodVao,bodRa);
        mLuuLuongTuanHoan = AppUtils.luuLuongTuanHoan(qTB,x,xt);
        mLuuLuongXaBun = AppUtils.luuLuongXaBun(v,x,qTB,ssRa,tb,xt);
        mLuongbunXaRa = AppUtils.khoiLuongBunXaRa(mLuuLuongXaBun,xt);

        tvLuongBun.setText(getText(R.string.kq_luong_bun) + " " + String.valueOf(mLuongBun) + " kg/ngày");
        tvKLBunXaRa.setText(getText(R.string.kq_khoi_luong_xa_ra) + " " + String.valueOf(mLuongbunXaRa) + " kg/ngày");
        tvLuuLuongTuanHoan.setText(getText(R.string.kq_luu_luong_tuan_hoan) + " " + String.valueOf(mLuuLuongTuanHoan) + " m³/ngày");
        tvLuuLuongXaBun.setText(getText(R.string.kq_luu_luong_xa_bun) + " " + String.valueOf(mLuuLuongXaBun) + " m³/ngày");
    }
}
