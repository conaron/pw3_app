package ifrs.pw3.controle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import org.ksoap2.serialization.PropertyInfo;

import ifrs.pw3.R;
import ifrs.pw3.adapter.CursoAdaptador;
import ifrs.pw3.dao.WebService;
import ifrs.pw3.model.Curso;
import ifrs.pw3.model.SincronizaResposta;

public class CursoControle implements SincronizaResposta {
    private final String URL = "lista";
    private final String METODO = "lista_curso_departamento";
    private PropertyInfo escolha = null;
    private ProgressDialog dialogo;
    private Activity atividade;
    private Curso[] cursos;
    private Curso curso;
    private int departamento_id = 0;
    private int curso_id = 0;

    public CursoControle(Activity atividade) {
        this.atividade = atividade;
    }

    public void carrega(int departamento) {
        departamento_id = departamento;
        String mensagem = "Carregando Cursos";
        dialogo = new ProgressDialog(atividade);
        dialogo.setTitle(mensagem + "...");
        dialogo.setMessage("Aguarde ...");
        dialogo.setCancelable(false);
        dialogo.show();
        chamaDao(departamento);
    }

    @Override
    public void processoEncerrado(Object obj) {
        if (obj instanceof String) {
            if ((dialogo != null) && (dialogo.isShowing())) {
                dialogo.dismiss();
            }
            cursos = new Gson().fromJson(obj.toString(), Curso[].class);
            Spinner spinner = (Spinner) atividade.findViewById(R.id.inscricao_curso);
            final CursoAdaptador adaptador = new CursoAdaptador(atividade, cursos);
            spinner.setAdapter(adaptador);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    curso = adaptador.getItem(position);
                    curso_id = curso.getCursoId();
                    ((TextView) atividade.findViewById(R.id.inscricao_email)).setEnabled(true);
                    ((Button) atividade.findViewById(R.id.inscricao_btn_descricao)).setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    LayoutInflater li = LayoutInflater.from(atividade);
                                    View view = li.inflate(R.layout.dialog_curso_descricao, null);
                                    TextView txt_descricao = (TextView) view.findViewById(R.id.curso_descricao_txt);
                                    AlertDialog.Builder builder = new AlertDialog.Builder(atividade);

                                    if (curso.getDescricao() != null) {
                                        txt_descricao.setText(curso.getDescricao());
                                    } else {
                                        txt_descricao.setText("Não possui descrição");
                                    }

                                    builder.setView(view);
                                    AlertDialog alerta = builder.create();
                                    alerta.show();
                                }
                            }
                    );

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapter) {
                }
            });
        }
    }

    public void chamaDao(int departamento) {
        escolha = new PropertyInfo();
        escolha.setName("departamento");
        escolha.setValue(departamento);
        escolha.setType(Integer.class);
        new WebService(URL, METODO, escolha).executa(atividade, this);
    }

}
