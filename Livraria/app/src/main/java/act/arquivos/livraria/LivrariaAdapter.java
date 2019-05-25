package act.arquivos.livraria;

import android.database.Cursor;

public class LivrariaAdapter {
    private Cursor cursor;

    public LivrariaAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }
}
