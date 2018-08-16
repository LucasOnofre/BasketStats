package com.example.lucas.nbastats.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;

public class BaseFragment extends android.support.v4.app.Fragment {

    private ProgressDialog progressDialog;


    protected ProgressDialog generateProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        return progressDialog;
    }
}
