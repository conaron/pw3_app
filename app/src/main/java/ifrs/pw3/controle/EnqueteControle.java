package ifrs.pw3.controle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ifrs.pw3.R;
import ifrs.pw3.dao.WsEnquete;
import ifrs.pw3.model.Enquete;
import ifrs.pw3.model.SincronizaResposta;

public class EnqueteControle implements SincronizaResposta {
    private ProgressDialog dialogo;
    private Activity atividade;
    private Context contexto;
    private int opcao = 0;

    public EnqueteControle(Activity atividade) {
        this.atividade = atividade;
        this.contexto = atividade.getApplicationContext();
    }

    public void carrega() {
        String mensagem = (opcao == 0) ? "Carregando enquete" : "Enviando voto";
        dialogo = new ProgressDialog(atividade);
        dialogo.setTitle(mensagem + "...");
        dialogo.setMessage("Aguarde ...");
        dialogo.setCancelable(false);
        dialogo.show();
        chamaDao();
        opcao = 0;
    }

    @Override
    public void processoEncerrado(Object obj) {
        if (obj instanceof Enquete[]) {
            final Enquete[] enquete = (Enquete[]) obj;
            if ((dialogo != null) && (dialogo.isShowing())) {
                dialogo.dismiss();
            }
            TextView pergunta = (TextView) atividade.findViewById(R.id.enquete_text_pergunta);
            RadioButton opcao_1 = (RadioButton) atividade.findViewById(R.id.enquete_rdb_op1);
            RadioButton opcao_2 = (RadioButton) atividade.findViewById(R.id.enquete_rdb_op2);
            RadioButton opcao_3 = (RadioButton) atividade.findViewById(R.id.enquete_rdb_op3);
            Button votar = (Button) atividade.findViewById(R.id.enquete_btn_votar);

            pergunta.setText(enquete[0].getPergunta());
            opcao_1.setText(enquete[0].getOpcao1() + " (" + enquete[0].getOpcao1Quantidade() + " votos)");
            opcao_2.setText(enquete[0].getOpcao2() + " (" + enquete[0].getOpcao2Quantidade() + " votos)");
            opcao_3.setText(enquete[0].getOpcao3() + " (" + enquete[0].getOpcao3Quantidade() + " votos)");

            votar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RadioGroup radio = (RadioGroup) atividade.findViewById(R.id.enquete_rdg_opcoes);
                    int op = radio.getCheckedRadioButtonId();
                    if (op == R.id.enquete_rdb_op1) {
                        opcao = 1;
                    } else if (op == R.id.enquete_rdb_op2) {
                        opcao = 2;
                    } else {
                        opcao = 3;
                    }
                    carrega();
                }
            });

        }
    }

    public void chamaDao() {
        new WsEnquete(opcao).executa(contexto, this);
    }

}
