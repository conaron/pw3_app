package ifrs.pw3.fragment;


import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ifrs.pw3.R;
import ifrs.pw3.adapter.NoticiasAdaptador;
import ifrs.pw3.controle.NoticiaControle;
import ifrs.pw3.dao.NoticiaRepository;
import ifrs.pw3.model.Noticia;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {
    View fragmento;
    private RecyclerView noticias_rec;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager manager;
    NoticiaRepository repositorio;


    public NoticiasFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmento = inflater.inflate(R.layout.fragment_noticias, container, false);
        new NoticiaControle(getActivity()).carrega();
//        noticias_rec = (RecyclerView) fragmento.findViewById(R.id.frag_noticias_lista);
//        repositorio = new NoticiaRepository(getActivity());
//
////        noticias_rec.setHasFixedSize(true);
//        manager = new LinearLayoutManager(getActivity());
//        noticias_rec.setLayoutManager(manager);
//
//        // Montagem de pequena lista para teste
////        repositorio.auto_popular();
//
//        List<Noticia> lista = repositorio.getAll();
//        adaptador = new NoticiasAdaptador(getActivity(), lista);
//        noticias_rec.setAdapter(adaptador);
        return fragmento;
    }

}
