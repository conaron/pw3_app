package ifrs.pw3.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ifrs.pw3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasDialogFragment extends DialogFragment {


    public NoticiasDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_noticias_dialog, container, false);
    }

}
