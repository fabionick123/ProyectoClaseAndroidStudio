package com.fabionick123.application.mainfr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fabionick123.application.R;

import java.util.ArrayList;
import java.util.Arrays;

public class tarjetas2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tarjetas1 = inflater.inflate(R.layout.fragment_monedas, container, false);

        ArrayList<ConstraintLayout> tarjetas = new ArrayList<>(Arrays.asList(
                tarjetas1.findViewById(R.id.tarjeta1),
                tarjetas1.findViewById(R.id.tarjeta2),
                tarjetas1.findViewById(R.id.tarjeta3),
                tarjetas1.findViewById(R.id.tarjeta4),
                tarjetas1.findViewById(R.id.tarjeta5)
        ));
        for (ConstraintLayout tarjeta2: tarjetas){
            tarjeta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarError();
                }
            });
        }
        return tarjetas1;
    }
    public void mostrarError() {
        new AlertDialog.Builder(getContext())
                .setTitle("¿SEGURO?")
                .setMessage("hmmmmmmm....")
                .setPositiveButton("SIMON", (dialog, which) -> Toast.makeText(getContext(), "que pro", Toast.LENGTH_SHORT).show())
                .setNegativeButton("NOLAS", (dialog, which) -> Toast.makeText(getContext(), "cagoneta", Toast.LENGTH_SHORT).show()).show();
    }

}