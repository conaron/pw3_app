package ifrs.pw3.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import ifrs.pw3.R;
import ifrs.pw3.adapter.AreaAlunoAdaptador;
import ifrs.pw3.model.Usuario;
import ifrs.pw3.model.UsuarioDados;

public class AreaAlunoActivity extends AppCompatActivity {
    String chegada;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_aluno);
        atividade = this;

        setTitle("Área do Aluno");
        TextView cpf = (TextView) findViewById(R.id.area_aluno_cpf);
        TextView nome = (TextView) findViewById(R.id.area_aluno_nome);
        TextView email = (TextView) findViewById(R.id.area_aluno_email);
        TextView fone = (TextView) findViewById(R.id.area_aluno_fone);
        TextView endereco = (TextView) findViewById(R.id.area_aluno_endereco);

        Intent intent = getIntent();
        chegada = (String) intent.getStringExtra("dados");
        String string_usuario = chegada.replaceAll("\\[.*", "");
        String string_lista = chegada.replaceAll(".*\\[", "[");

        List<UsuarioDados> lista = Arrays.asList(new Gson().fromJson(string_lista, UsuarioDados[].class));

        Usuario usuario = new Gson().fromJson(string_usuario, Usuario.class);
        ((TextView) findViewById(R.id.area_aluno_cpf)).setText("CPF: " + usuario.getCpf());
        ((TextView) findViewById(R.id.area_aluno_nome)).setText("Nome: " + usuario.getNome());
        ((TextView) findViewById(R.id.area_aluno_email)).setText("E-mail: " + usuario.getEmail());
        ((TextView) findViewById(R.id.area_aluno_fone)).setText("Fone: " + usuario.getFone());
        ((TextView) findViewById(R.id.area_aluno_endereco)).setText("Endereço: " + usuario.getEndereco());

        ListView cursos = (ListView) findViewById(R.id.area_aluno_cursos);
        cursos.setAdapter(new AreaAlunoAdaptador(lista, atividade));

    }
}
