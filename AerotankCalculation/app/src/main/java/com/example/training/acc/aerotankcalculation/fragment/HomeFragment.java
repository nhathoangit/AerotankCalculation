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

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment {

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setActionBar(view, getString(R.string.title_home).toUpperCase());
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fragHome_flHieuQuaXuLy, R.id.fragHome_flKichThuocBe, R.id.fragHome_flBunHoatTinh, R.id.fragHome_flKiemTraThongSo, R.id.fragHome_flThietBiPhanPhoiKhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragHome_flHieuQuaXuLy:
                addFragment(new HieuQuaXuLyFragment(),true);
                break;
            case R.id.fragHome_flKichThuocBe:
                addFragment(new KichThuocBeFragment(),true);
                break;
            case R.id.fragHome_flBunHoatTinh:
                addFragment(new BunHoatTinhFragment(),true);
                break;
            case R.id.fragHome_flKiemTraThongSo:
                addFragment(new KiemTraThongSoFragment(),true);
                break;
            case R.id.fragHome_flThietBiPhanPhoiKhi:
                addFragment(new ThietBiPhanPhoiKhiFragment(),true);
                break;
        }
    }
}
