package act.arquivos.livraria;

import android.provider.BaseColumns;

public final class LivrariaContract {

    public static final class Livro implements BaseColumns {
        public static final String TABLE_NAME = "livro";
        public static final String COLLUMN_TITULO = "titulo";
        public static final String COLLUMN_AUTOR = "autor";
        public static final String COLLUMN_ANO = "ano";
        public static final String CREATE_TABLE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s INTEGER)",TABLE_NAME, _ID, COLLUMN_TITULO, COLLUMN_AUTOR,COLLUMN_ANO);
        public static final String DROP_TABLE = String.format("DROP TABLE %s",TABLE_NAME);
    }
}
