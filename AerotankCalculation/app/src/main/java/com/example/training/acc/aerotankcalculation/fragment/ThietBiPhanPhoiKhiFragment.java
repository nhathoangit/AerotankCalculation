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

public class ThietBiPhanPhoiKhiFragment extends BaseFragment {
    @BindView(R.id.fragPPK_etA)
    EditText etA;
    @BindView(R.id.fragPPK_etBODVao)
    EditText etBODVao;
    @BindView(R.id.fragPPK_etH)
    EditText etH;
    @BindView(R.id.fragPPK_etQDia)
    EditText etQDia;
    @BindView(R.id.fragPPK_etQtb)
    EditText etQtb;
    @BindView(R.id.fragPPK_etBODRa)
    EditText etBODRa;
    @BindView(R.id.fragPPK_etN)
    EditText etN;
    @BindView(R.id.fragPPK_tvApLuc)
    TextView tvApLuc;
    @BindView(R.id.fragPPK_tvCongSuat)
    TextView tvCongSuat;
    @BindView(R.id.fragPPK_tvKhongKhiCap)
    TextView tvKhongKhiCap;
    @BindView(R.id.fragPPK_tvOngDanChinh)
    TextView tvOngDanChinh;
    @BindView(R.id.fragPPK_tvOngDanNhanh)
    TextView tvOngDanNhanh;
    @BindView(R.id.fragPPK_tvSoDia)
    TextView tvSoDia;

    private double mLuongKhongKhiCungcap, mApLucCanThiet, mCongSuatMayThoiKhi, mSoDiaPhanPhoiKhi, mDuongKinhChinh, mDuongKinhNhanh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thiet_bi_phan_phoi_khi, container, false);
        setActionBarBack(view, getString(R.string.thiet_bi_phan_phoi_khi).toUpperCase());
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.fragPPK_tvKetQua)
    public void onClick() {
        double a = Double.parseDouble(etA.getText().toString());
        double bodVao = Double.parseDouble(etBODVao.getText().toString());
        double bodRa = Double.parseDouble(etBODRa.getText().toString());
        double h = Double.parseDouble(etH.getText().toString());
        double qDia = Double.parseDouble(etQDia.getText().toString());
        double qTB = Double.parseDouble(etQtb.getText().toString());
        double n = Double.parseDouble(etN.getText().toString());

        double mLuongKhongKhiCungcap = AppUtils.luongKhongKhiCungcap(qTB, bodVao, bodRa, a, h);
        double mApLucCanThiet = AppUtils.apLucCanThiet(h);
        double mCongSuatMayThoiKhi = AppUtils.congSuatMayThoiKhi(mApLucCanThiet, mLuongKhongKhiCungcap);
        double mSoDiaPhanPhoiKhi = AppUtils.soDiaPhanPhoiKhi(mLuongKhongKhiCungcap, qDia);
        double mDuongKinhChinh = AppUtils.duongKinhChinh(mLuongKhongKhiCungcap);
        double mDuongKinhNhanh = AppUtils.duongKinhNhanh(mLuongKhongKhiCungcap, n);

        tvApLuc.setText(getText(R.string.kq_ap_luc_can_thiet) + " " + String.valueOf(mApLucCanThiet) + " m");
        tvKhongKhiCap.setText(getText(R.string.kq_luong_kk) + " " + String.valueOf(mLuongKhongKhiCungcap) + " m³/s");
        tvCongSuat.setText(getText(R.string.kq_cong_suat_may_thoi_khi) + " " + String.valueOf(mCongSuatMayThoiKhi) + " KW");
        tvOngDanChinh.setText(getText(R.string.kq_duong_kinh) + " " + String.valueOf(mDuongKinhChinh) + " m");
        tvOngDanNhanh.setText(getText(R.string.kq_duong_kinh_nhanh) + " " + String.valueOf(mDuongKinhNhanh) + " m");
        tvSoDia.setText(getText(R.string.kq_so_dia_phan_phoi) + " " + String.valueOf(mSoDiaPhanPhoiKhi) + " đĩa");
    }
}
