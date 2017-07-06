package ifrs.pw3.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import ifrs.pw3.model.Noticia_2;

public class NoticiaRepository {

    private BdUtil banco;
    private final String tabela = Noticia_2.TABELA;
    private final String ID = "_ID";
    private final String ddl = Noticia_2.DDL;
    private final String select = Noticia_2.SELECT;
    private final String select_all = Noticia_2.SELECT_ALL;

    public NoticiaRepository(Context context) {
        banco = new BdUtil(context, tabela, ddl);
    }

    public String insert(Noticia_2 objeto) {
        long resultado = banco.getConexao().insert(tabela, null, objeto.getValores());
        if (resultado == -1)
            return "Erro ao inserir registro";
        return "Registro Inserido com sucesso";
    }

    public Integer delete(Noticia_2 objeto) {
        String[] cod = new String[]{String.valueOf(objeto.get_id())};
        return banco.getConexao().delete(tabela, ID + " = ?", cod);
    }

    public Integer update(Noticia_2 objeto) {
        String[] cod = new String[]{String.valueOf(objeto.get_id())};
        return banco.getConexao().update(tabela, objeto.getValores(), ID + " = ?", cod);
    }

    public Noticia_2 getNoticia_2(int id) {
        String[] cod = new String[]{String.valueOf(id)};
        Cursor cursor = banco.getConexao().rawQuery(select + id, null);
        cursor.moveToFirst();
        Noticia_2 objeto = new Noticia_2(cursor);
        return objeto;
    }

    public List<Noticia_2> getAll() {
        List<Noticia_2> lista = new ArrayList<>();
        Cursor cursor = banco.getConexao().rawQuery(select_all, null);
        cursor.moveToFirst();
        Noticia_2 objeto = null;
        while (!cursor.isAfterLast()) {
            objeto = new Noticia_2(cursor);
            lista.add(objeto);
            cursor.moveToNext();
        }
        return lista;
    }

    public void auto_popular() {
        List<Noticia_2> lista = getAll();

        for (Noticia_2 Noticia_2 : lista) {
            delete(Noticia_2);
        }
        insert(new Noticia_2(1, "Titulo 1", "Imagem 1", "Manchete 1", "Noticia_2 1"));
        insert(new Noticia_2(2, "Titulo 2", "Imagem 2", "Manchete 2", "Noticia_2 2"));
        insert(new Noticia_2(3, "Titulo 3", "Imagem 3", "Manchete 3", "Noticia_2 3"));
        insert(new Noticia_2(4, "Titulo 4", "Imagem 4", "Manchete 4", "Noticia_2 4"));
        insert(new Noticia_2(5, "Titulo 5", "Imagem 5", "Manchete 5", "Noticia_2 5"));
        insert(new Noticia_2(6, "Titulo 6", "Imagem 6", "Manchete 6", "Noticia_2 6"));
        insert(new Noticia_2(7, "Titulo 7", "Imagem 7", "Manchete 7", "Noticia_2 7"));
        insert(new Noticia_2(8, "Titulo 8", "Imagem 8", "Manchete 8", "Noticia_2 8"));
    }
}
