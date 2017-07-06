package ifrs.pw3.dao;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import ifrs.pw3.model.Enquete;
import ifrs.pw3.model.SincronizaResposta;

public class WsEnquete {
    private int opcao;

    public WsEnquete(int opcao) {
        this.opcao = opcao;
    }

    public void executa(Context contexto, SincronizaResposta _delegate) {
        new Ws(contexto, _delegate).execute();
    }

    public class Ws extends AsyncTask<String, Void, Enquete[]> {
        private String URL = "https://pw3-00.herokuapp.com/";
        private final String NAMESPACE = "http://webs/";
        private String METHOD;
        private final String SOAP_ACTION_PREFIX = NAMESPACE + "#" + METHOD;

        private Object resposta;
        private SincronizaResposta _delegate = null;
        private Context contexto;

        public Ws(Context contexto, SincronizaResposta _delegate) {
            this.URL += (opcao == 0) ? "lista" : "recebe";
            this.METHOD = (opcao == 0) ? "enquete" : "recebe_enquete";
            this.contexto = contexto;
            this._delegate = _delegate;
        }

        @Override
        protected Enquete[] doInBackground(String... params) {
            SoapObject request = new SoapObject(NAMESPACE, METHOD);

            if (opcao != 0) {
                PropertyInfo escolha = new PropertyInfo();
                escolha.setName("opcao");
                escolha.setValue(opcao);
                escolha.setType(Integer.class);
                request.addProperty(escolha);
            }

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(URL, 10000);
            transporte.debug = true;

            try {
                transporte.call(SOAP_ACTION_PREFIX, envelope);
                resposta = envelope.getResponse();
                transporte.getServiceConnection().disconnect();
            } catch (Exception e) {
            }

            Enquete[] lista = null;
            if (resposta != null)
                lista = new Gson().fromJson(resposta.toString(), Enquete[].class);

            return lista;
        }

        @Override
        protected void onPostExecute(Enquete[] lista) {
            if (_delegate != null)
                _delegate.processoEncerrado(lista);
        }

    }
}



