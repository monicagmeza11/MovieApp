package com.mcode.movieapplicationmvp.ui;

import android.app.Dialog;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.mcode.movieapplicationmvp.R;
import com.mcode.movieapplicationmvp.interfaces.IDialog;

public class MasterFragment extends Fragment implements IDialog {
    CustomProgressDialog dialog = new CustomProgressDialog();
    @Override
    public void showDialog(String message) {
        dismissDialog();
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        dialog.show(getActivity(), message);
    }

    @Override
    public void dismissDialog() {
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        if(dialog!=null){
            dialog.dismiss();
        }
    }
}
