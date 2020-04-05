package com.tt.dev.instagramdownload.dialog;

import android.content.Context;

import com.tt.dev.instagramdownload.R;

public class Dialog {

    public static SweetAlertDialog PROGRESS_TYPE(Context context,String txt) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.b2));
        pDialog.setTitleText(txt);
        pDialog.setCancelable(false);
        return pDialog;
    }

    public static SweetAlertDialog SUCCESS_TYPE(Context context,String txt) {
        SweetAlertDialog pDialog= new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.setTitleText(txt);
        pDialog.setCancelable(false);
        pDialog.setContentText("You clicked the button!");
        return pDialog;
    }
}
