package ifrs.pw3.controle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;

import com.google.gson.Gson;

import org.ksoap2.serialization.PropertyInfo;

import ifrs.pw3.dao.WebService;
import ifrs.pw3.model.SincronizaResposta;
import ifrs.pw3.model.Usuario;
import ifrs.pw3.view.AreaAlunoActivity;

public class LoginControle implements SincronizaResposta {
    private final String URL = "recebe";
    private final String METODO = "recebe_login";
    private PropertyInfo escolha = null;
    private ProgressDialog dialogo;
    private Activity atividade;
    private Usuario[] usuarios;

    public LoginControle(Activity atividade) {
        this.atividade = atividade;
    }

    public void carrega(String hash) {
        String mensagem = "Autenticando usuário";
        dialogo = new ProgressDialog(atividade);
        dialogo.setTitle(mensagem + "...");
        dialogo.setMessage("Aguarde ...");
        dialogo.setCancelable(false);
        dialogo.show();
        chamaDao(hash);
    }


    @Override
    public void processoEncerrado(Object obj) {
        if (obj instanceof String) {
            if ((dialogo != null) && (dialogo.isShowing())) {
                dialogo.dismiss();
            }
            String dados = obj.toString();

            Usuario usuario = new Gson().fromJson(dados.replaceAll("\\[.*", ""), Usuario.class);

            if (usuario.getNome() == null) {
                AlertDialog.Builder teste = new AlertDialog.Builder(atividade);
                teste.setTitle("Alerta de conexão");
                teste.setMessage("Servidor baixado");
                teste.show();
            } else if (usuario.getUsuarioId() != 0) {
                Intent intencao = new Intent(atividade, AreaAlunoActivity.class);
                intencao.putExtra("dados", dados);
                atividade.startActivity(intencao);
            } else {
                AlertDialog.Builder teste = new AlertDialog.Builder(atividade);
                teste.setTitle("Dados inválidos");
                teste.setMessage("Por favor, repita a operação");
                teste.show();
            }


        }
    }

    public void chamaDao(String autenticacao) {
        escolha = new PropertyInfo();
        escolha.setName("autenticacao");
        escolha.setValue(autenticacao);
        escolha.setType(Integer.class);
        new WebService(URL, METODO, escolha).executa(atividade, this);
    }

}
