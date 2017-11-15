package com.twogev.dailyshedule;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.twogev.dailyshedule.R;

/**
 * Created by Іван Бекер on 15.11.2017.
 */

public class ShowMessages extends Application
{
    public static int textCl;

    public void Configurate(int textColor)
    {
        textCl = textColor;
    }

    public static void ShowSnackbar(View v, String s)
    {
        Snackbar snackbar = Snackbar
                .make(v, s, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(Color.GRAY);
        TextView t = (TextView)snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);//setActionTextColor(getResources().getColor(R.color.colorPrimary));
        t.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t.setTextSize(16);
        t.setTextColor(textCl);
        snackbar.show();
    }


}
