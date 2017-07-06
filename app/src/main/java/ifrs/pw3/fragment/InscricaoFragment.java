package ifrs.pw3.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ifrs.pw3.R;
import ifrs.pw3.controle.CursoDepartamentoControle;
import ifrs.pw3.controle.InscricaoControle;
import ifrs.pw3.model.Curso;
import ifrs.pw3.model.Inscricao;

/**
 * A simple {@link Fragment} subclass.
 */
public class InscricaoFragment extends Fragment {

    private Spinner curso;
    private EditText email;
    private EditText nome;
    private EditText fone;

    public InscricaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmento = inflater.inflate(R.layout.fragment_inscricao, container, false);
        Spinner departamento = (Spinner) fragmento.findViewById(R.id.inscricao_curso_departamento);
        curso = (Spinner) fragmento.findViewById(R.id.inscricao_curso);
        email = (EditText) fragmento.findViewById(R.id.inscricao_email);
        nome = (EditText) fragmento.findViewById(R.id.inscricao_nome);
        fone = (EditText) fragmento.findViewById(R.id.inscricao_fone);
        Button envia = (Button) fragmento.findViewById(R.id.inscricao_btn_envia);

        new CursoDepartamentoControle(getActivity()).carrega();

        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Curso c = (Curso) curso.getSelectedItem();
                Inscricao inscricao = new Inscricao();
                inscricao.setNome(nome.getText().toString());
                inscricao.setEmail(email.getText().toString());
                inscricao.setFone(fone.getText().toString());
                inscricao.setCursoId(c.getCursoId());

                new InscricaoControle(getActivity()).carrega(inscricao);
            }
        });
        return fragmento;
    }

}
