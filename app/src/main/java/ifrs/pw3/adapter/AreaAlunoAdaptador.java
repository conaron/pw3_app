package ifrs.pw3.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

import ifrs.pw3.R;
import ifrs.pw3.model.UsuarioDados;

/**
 * Created by Ton on 05/07/2017.
 */


public class AreaAlunoAdaptador extends BaseAdapter {
    private Context context;
    private UsuarioDados[] lista;
    private Activity atividade;

    public AreaAlunoAdaptador(List<UsuarioDados> lista, Activity atividade) {
        this.lista = (UsuarioDados[]) lista.toArray();
        this.atividade = atividade;
    }


    @Override
    public UsuarioDados getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View bloco = atividade.getLayoutInflater().inflate(R.layout.adaptador_area_aluno, null);

        UsuarioDados linha = lista[position];
        TextView nome = (TextView) bloco.findViewById(R.id.area_aluno_curso_nome);
        TextView descricao = (TextView) bloco.findViewById(R.id.area_aluno_curso_descricao);
        TextView dia = (TextView) bloco.findViewById(R.id.area_aluno_curso_dia);
        TextView duracao = (TextView) bloco.findViewById(R.id.area_aluno_curso_duracao);
        nome.setText("Curso: " + linha.getNome());
        descricao.setText("Descrição: " + linha.getDescricao());
        dia.setText("Dia: " + linha.getDia());
        duracao.setText("Duração " + linha.getDuracao() + " horas.");

        return bloco;
    }
}
