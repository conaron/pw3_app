package ifrs.pw3.controle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import org.ksoap2.serialization.PropertyInfo;

import java.util.Arrays;

import ifrs.pw3.R;
import ifrs.pw3.adapter.NoticiasAdaptador;
import ifrs.pw3.dao.WebService;
import ifrs.pw3.model.Noticia;
import ifrs.pw3.model.SincronizaResposta;

public class NoticiaControle implements SincronizaResposta {
    private final String URL = "lista";
    private final String METODO = "lista_noticia";
    private PropertyInfo escolha = null;
    private ProgressDialog dialogo;
    private Activity atividade;
    private Noticia[] noticias;

    public NoticiaControle(Activity atividade) {
        this.atividade = atividade;
    }

    public void carrega() {
        String mensagem = "Carregando noticias";
        dialogo = new ProgressDialog(atividade);
        dialogo.setTitle(mensagem + "...");
        dialogo.setMessage("Aguarde ...");
        dialogo.setCancelable(false);
        dialogo.show();
        chamaDao();
    }

    @Override
    public void processoEncerrado(Object obj) {
        if (obj instanceof String) {
            if ((dialogo != null) && (dialogo.isShowing())) {
                dialogo.dismiss();
            }
            noticias = new Gson().fromJson(obj.toString(), Noticia[].class);

            RecyclerView noticias_rec = (RecyclerView) atividade.findViewById(R.id.frag_noticias_lista);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(atividade);
            noticias_rec.setLayoutManager(manager);
            RecyclerView.Adapter adaptador = new NoticiasAdaptador(atividade, Arrays.asList(noticias));
            noticias_rec.setAdapter(adaptador);
        }
    }

    public void chamaDao() {
        new WebService(URL, METODO, escolha).executa(atividade, this);
    }

}
