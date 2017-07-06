package ifrs.pw3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ifrs.pw3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioEmBrancoFragment extends Fragment {


    public InicioEmBrancoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_em_branco, container, false);
    }

}
