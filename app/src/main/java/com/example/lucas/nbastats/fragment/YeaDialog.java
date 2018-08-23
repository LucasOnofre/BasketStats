package com.example.lucas.nbastats.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class YeaDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Temporadas");
        builder.setItems(new String[]{"2000","2010","2020","2030","2050"}, null);

        return builder.create();
    }
}