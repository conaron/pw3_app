package ifrs.pw3.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ifrs.pw3.R;
import ifrs.pw3.controle.EnqueteControle;


public class EnqueteFragment extends Fragment {


    public EnqueteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmento = inflater.inflate(R.layout.fragment_enquete, container, false);
        new EnqueteControle(getActivity()).carrega();
        return fragmento;
    }

}
