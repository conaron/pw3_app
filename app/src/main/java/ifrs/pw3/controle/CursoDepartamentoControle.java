package ifrs.pw3.controle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.gson.Gson;

import org.ksoap2.serialization.PropertyInfo;

import ifrs.pw3.R;
import ifrs.pw3.adapter.CursoDepartamentoAdaptador;
import ifrs.pw3.dao.WebService;
import ifrs.pw3.model.CursoDepartamento;
import ifrs.pw3.model.SincronizaResposta;

public class CursoDepartamentoControle implements SincronizaResposta {
    private final String URL = "lista";
    private final String METODO = "lista_departamento";
    private final PropertyInfo escolha = null;
    private ProgressDialog dialogo;
    private Activity atividade;
    private int opcao = 0;
    private CursoDepartamento[] departamentos;

    public CursoDepartamentoControle(Activity atividade) {
        this.atividade = atividade;
    }

    public void carrega() {
        String mensagem = "Carregando departamentos";
        dialogo = new ProgressDialog(atividade);
        dialogo.setTitle(mensagem + "...");
        dialogo.setMessage("Aguarde ...");
        dialogo.setCancelable(false);
        dialogo.show();
        chamaDao();
        opcao = 0;
    }

    @Override
    public void processoEncerrado(Object obj) {
        if (obj instanceof String) {
            if ((dialogo != null) && (dialogo.isShowing())) {
                dialogo.dismiss();
            }
            departamentos = new Gson().fromJson(obj.toString(), CursoDepartamento[].class);
            Spinner spinner = (Spinner) atividade.findViewById(R.id.inscricao_curso_departamento);
            final CursoDepartamentoAdaptador adaptador = new CursoDepartamentoAdaptador(atividade, departamentos);
            spinner.setAdapter(adaptador);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    int departamento = adaptador.getItem(position).getCursoDepartamentoId();
                    new CursoControle(atividade).carrega(departamento);
                    ((Spinner) atividade.findViewById(R.id.inscricao_curso)).setClickable(true);

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapter) {
                }
            });
        }
    }

    public void chamaDao() {
        new WebService(URL, METODO, escolha).executa(atividade, this);
    }

}
