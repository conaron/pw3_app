package ifrs.pw3.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ifrs.pw3.R;

public class ConhecaFragmentTab extends Fragment {

    public static Fragment newInstance(String titulo, String texto) {
        Bundle parametros = new Bundle();
        parametros.putString("titulo", titulo);
        parametros.putString("texto", texto);
        ConhecaFragmentTab fragmento = new ConhecaFragmentTab();
        fragmento.setArguments(parametros);
        return fragmento;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmento = inflater.inflate(R.layout.fragment_conheca_fragment_tab, container, false);
        Bundle parametros = getArguments();
        String st_titulo = parametros.getString("titulo");
        String st_texto = parametros.getString("texto");
        TextView titulo = (TextView) fragmento.findViewById(R.id.fragmento_conheca_sobre_titulo);
        TextView texto = (TextView) fragmento.findViewById(R.id.fragmento_conheca_sobre_texto);
        titulo.setText(st_titulo);
        texto.setText(st_texto);
        return fragmento;
    }


}
