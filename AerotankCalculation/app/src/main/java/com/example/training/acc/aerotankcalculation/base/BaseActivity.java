package com.example.training.acc.aerotankcalculation.base;
/*
 * Created by NhatHoang on 03/12/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.training.acc.aerotankcalculation.R;

public abstract class BaseActivity extends AppCompatActivity {

    View.OnClickListener onBackClick = view -> onBackPressed();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setBackground(null);
    }

    public void setActionBar(View view, String title) {
        TextView tvTitle = view.findViewById(R.id.actionbar_tvTitle);
        View vBack = view.findViewById(R.id.actionbar_imgBack);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
        if (vBack != null) {
            vBack.setVisibility(View.GONE);
        }

    }

    public void setActionBarBack(View view, String title) {
        TextView tvTitle = view.findViewById(R.id.actionbar_tvTitle);
        View vBack = view.findViewById(R.id.actionbar_imgBack);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
        if (vBack != null) {
            vBack.setOnClickListener(onBackClick);
        }

    }

    private void addReplaceFragment(BaseFragment fragment, boolean isReplace, boolean isAddToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (isReplace)
                fragmentTransaction.replace(R.id.frmContainer, fragment);
            else {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frmContainer);
                if (currentFragment != null) {
                    fragmentTransaction.hide(currentFragment);
                }
                fragmentTransaction.add(R.id.frmContainer, fragment, fragment.getClass().getSimpleName());
            }
            if (isAddToBackStack) {
                fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            }
            fragmentTransaction.commit();
        }
    }

    public void replaceFragment(BaseFragment fragment, boolean isAddToBackStack) {

        addReplaceFragment(fragment, true, isAddToBackStack);
    }

    public void addFragment(BaseFragment fragment, boolean isAddToBackStack) {
        addReplaceFragment(fragment, false, isAddToBackStack);
    }

    public void clearAllBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStack();
        }
    }
}
