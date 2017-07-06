package ifrs.pw3.controle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.google.gson.Gson;

import org.ksoap2.serialization.PropertyInfo;

import ifrs.pw3.dao.WebService;
import ifrs.pw3.model.Inscricao;
import ifrs.pw3.model.SincronizaResposta;

public class InscricaoControle implements SincronizaResposta {
    private final String URL = "recebe";
    private final String METODO = "recebe_inscricao";
    private PropertyInfo escolha = null;
    private ProgressDialog dialogo;
    private Activity atividade;
    private Inscricao inscricao;

    public InscricaoControle(Activity atividade) {
        this.atividade = atividade;
    }

    public void carrega(Inscricao inscricao) {
        String mensagem = "Registrando solicitação";
        dialogo = new ProgressDialog(atividade);
        dialogo.setTitle(mensagem + "...");
        dialogo.setMessage("Aguarde ...");
        dialogo.setCancelable(false);
        dialogo.show();
        chamaDao(inscricao);
    }

    @Override
    public void processoEncerrado(Object obj) {
        if (obj instanceof String) {
            if ((dialogo != null) && (dialogo.isShowing())) {
                dialogo.dismiss();
            }
        Toast toast = Toast.makeText(atividade, obj.toString(), Toast.LENGTH_LONG);
        toast.show();
        }
    }

    public void chamaDao(Inscricao inscricao) {
        escolha = new PropertyInfo();
        escolha.setName("inscricao");
        escolha.setValue(new Gson().toJson(inscricao));
        escolha.setType(String.class);
        new WebService(URL, METODO, escolha).executa(atividade, this);
    }

}
