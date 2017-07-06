package ifrs.pw3.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ifrs.pw3.R;
import ifrs.pw3.model.CursoDepartamento;

public class CursoDepartamentoAdaptador extends BaseAdapter {
    private Activity atividade;
    private CursoDepartamento[] departamentos;

    public CursoDepartamentoAdaptador(Activity atividade, CursoDepartamento[] departamentos) {
        this.atividade = atividade;
        this.departamentos = departamentos;
    }

    @Override
    public int getCount() {
        return departamentos.length;
    }

    @Nullable
    @Override
    public CursoDepartamento getItem(int position) {
        return departamentos[position];
    }

    @Override
    public long getItemId(int position) {
        return departamentos[position].getCursoDepartamentoId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View bloco = atividade.getLayoutInflater().inflate(R.layout.spinner, null);
        TextView linha = (TextView) bloco.findViewById(R.id.txt_spinner);
        linha.setText("Área: " + departamentos[position].getNome());
        return bloco;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View bloco = atividade.getLayoutInflater().inflate(R.layout.spinner, null);
        TextView linha = (TextView) bloco.findViewById(R.id.txt_spinner);
        linha.setText("Área: " + departamentos[position].getNome());
        return bloco;
    }

}
