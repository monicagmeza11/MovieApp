package com.mcode.movieapplicationmvp.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mcode.movieapplicationmvp.MovieDetailsMVP;
import com.mcode.movieapplicationmvp.R;

public class CustomProgressDialog {
    CustomDialog dialog;
    public Dialog show(Context context, String title){
        dialog = new CustomDialog(context);
        dialog.setCancelable(false);
        View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog,null);
        TextView labelLoading = view.findViewById(R.id.label);
        labelLoading.setText(title);
        dialog.setContentView(view);
        dialog.show();
        return dialog;
    }

    public void dismiss(){

        if(dialog!=null){dialog.dismiss();}
    }

    public class CustomDialog extends Dialog{
        public CustomDialog(Context context){
            super(context, R.style.CustomDialog);

        }
    }
}


