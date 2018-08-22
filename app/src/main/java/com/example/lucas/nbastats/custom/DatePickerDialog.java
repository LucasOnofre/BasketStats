package com.example.lucas.nbastats.custom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {

    public DatePickerDialog(Context context) {
        super((Context)null, 0);
        throw new RuntimeException("Stub!");
    }

    public DatePickerDialog(Context context, int themeResId) {
        super((Context)null, 0);
        throw new RuntimeException("Stub!");
    }

    public DatePickerDialog(Context context, android.app.DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth) {
        super((Context)null, 0);
        throw new RuntimeException("Stub!");
    }

    public DatePickerDialog(Context context, int themeResId, android.app.DatePickerDialog.OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super((Context)null, 0);
        throw new RuntimeException("Stub!");
    }

    public void onDateChanged(DatePicker view, int year, int month, int dayOfMonth) {
        throw new RuntimeException("Stub!");
    }

    public void setOnDateSetListener(android.app.DatePickerDialog.OnDateSetListener listener) {
        throw new RuntimeException("Stub!");
    }

    public void onClick(DialogInterface dialog, int which) {
        throw new RuntimeException("Stub!");
    }

    public DatePicker getDatePicker() {
        throw new RuntimeException("Stub!");
    }

    public void updateDate(int year, int month, int dayOfMonth) {
        throw new RuntimeException("Stub!");
    }

    public Bundle onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    public interface OnDateSetListener {
        void onDateSet(DatePicker var1, int var2, int var3, int var4);
    }
}
