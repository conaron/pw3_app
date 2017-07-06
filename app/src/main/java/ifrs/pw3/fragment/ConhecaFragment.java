package ifrs.pw3.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

import ifrs.pw3.R;
import ifrs.pw3.adapter.ConhecaAdaptador;

public class ConhecaFragment extends Fragment {
    View fragmento;
    TextView campo;

    public ConhecaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmento = inflater.inflate(R.layout.fragment_conheca, container, false);

        TabLayout tabs = (TabLayout) fragmento.findViewById(R.id.fragmento_conheca_tabs);
        ViewPager pager = (ViewPager) fragmento.findViewById(R.id.fragmento_conheca_pager);
        FragmentManager fm = ((FragmentActivity) getActivity()).getSupportFragmentManager();
        ConhecaAdaptador adaptador = new ConhecaAdaptador(getActivity(), fm);
        pager.setAdapter(adaptador);
        tabs.setupWithViewPager(pager);
        return fragmento;
    }


}
