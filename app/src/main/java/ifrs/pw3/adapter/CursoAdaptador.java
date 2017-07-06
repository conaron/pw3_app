package ifrs.pw3.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import ifrs.pw3.R;
import ifrs.pw3.model.Curso;

public class CursoAdaptador extends BaseAdapter {
    private Activity atividade;
    private Curso[] cursos;

    public CursoAdaptador(Activity atividade, Curso[] cursos) {
        this.atividade = atividade;
        this.cursos = cursos;
    }

    @Override
    public int getCount() {
        return cursos.length;
    }

    @Nullable
    @Override
    public Curso getItem(int position) {
        return cursos[position];
    }

    @Override
    public long getItemId(int position) {
        return cursos[position].getCursoId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View bloco = atividade.getLayoutInflater().inflate(R.layout.spinner, null);
        TextView linha = (TextView) bloco.findViewById(R.id.txt_spinner);
        linha.setText("Curso: " + cursos[position].getNome());
        return bloco;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View bloco = atividade.getLayoutInflater().inflate(R.layout.spinner, null);
        TextView linha = (TextView) bloco.findViewById(R.id.txt_spinner);
        linha.setText("Curso: " + cursos[position].getNome());
        return bloco;
    }

}
