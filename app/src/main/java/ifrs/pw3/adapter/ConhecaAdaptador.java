package ifrs.pw3.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ifrs.pw3.R;
import ifrs.pw3.fragment.ConhecaFragmentTab;

public class ConhecaAdaptador extends FragmentPagerAdapter {
    private static final int NUM_TABS = 3;
    private String[] abas;
    private String[] titulos;
    private String[] textos;

    public ConhecaAdaptador(Context contexto, FragmentManager fm) {
        super(fm);
        abas = contexto.getResources().getStringArray(R.array.txt_fragmento_aba);
        titulos = contexto.getResources().getStringArray(R.array.txt_fragmento_titulo);
        textos = contexto.getResources().getStringArray(R.array.txt_fragmento_texto);
    }

    @Override
    public Fragment getItem(int posicao) {
        return ConhecaFragmentTab.newInstance(titulos[posicao], textos[posicao]);
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int posicao) {
        return abas[posicao].toUpperCase();
    }

}
