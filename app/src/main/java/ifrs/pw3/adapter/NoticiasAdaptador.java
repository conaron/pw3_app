
package ifrs.pw3.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ifrs.pw3.R;
import ifrs.pw3.model.Noticia;

public class NoticiasAdaptador extends RecyclerView.Adapter<NoticiasAdaptador.ViewHolder> {
    private Context contexto;
    private List<Noticia> lista;
    private LayoutInflater inflater;
    private AlertDialog alerta;
    private TextView titulo;
    private TextView manchete;
    private TextView noticia;
    private ImageView foto;

    public NoticiasAdaptador(Context contexto, List<Noticia> lista) {
        this.contexto = contexto;
        this.lista = lista;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup view, int viewType) {
        inflater = LayoutInflater.from(view.getContext());
        View linha = inflater.inflate(R.layout.adaptador_noticia, view, false);
        titulo = (TextView) linha.findViewById(R.id.noticia_card_titulo);
        manchete = (TextView) linha.findViewById(R.id.noticia_card_manchete);
        noticia = (TextView) linha.findViewById(R.id.noticia_card_noticia);
        ViewHolder saida = new ViewHolder(linha);
        return saida;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int posicao) {
        final Noticia noticia = this.lista.get(posicao);
        viewHolder.titulo.setText(noticia.getTitulo());
        Glide.with(contexto).load(noticia.getImagemUrl()).into(viewHolder.imagem);


        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater li = LayoutInflater.from(inflater.getContext());
                        View view = li.inflate(R.layout.noticia_card, null);
                        view.findViewById(R.id.noticias_card_botao).setOnClickListener(new View.OnClickListener() {
                            public void onClick(View arg0) {
                                alerta.dismiss();
                            }
                        });

                        ImageView foto = (ImageView) view.findViewById(R.id.noticia_card_imagem);
                        Glide.with(view).load(noticia.getImagemUrl()).into(foto);

                        ((TextView) view.findViewById(R.id.noticia_card_titulo)).setText(noticia.getTitulo());
                        ((TextView) view.findViewById(R.id.noticia_card_manchete)).setText(noticia.getManchete());
                        ((TextView) view.findViewById(R.id.noticia_card_noticia)).setText(noticia.getNoticia());
                        AlertDialog.Builder builder = new AlertDialog.Builder(inflater.getContext());
                        float dpi = contexto.getResources().getDisplayMetrics().density;
                        builder.setView(view, (int)(19*dpi), (int)(5*dpi), (int)(14*dpi), (int)(5*dpi) );
                        alerta = builder.create();
                        alerta.show();

                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView imagem;

        public ViewHolder(View item) {
            super(item);
            titulo = (TextView) item.findViewById(R.id.adp_not_txt_titulo);
            imagem = (ImageView) item.findViewById(R.id.adpt_not_txt_imagem);
        }


    }


}
