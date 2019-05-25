package act.arquivos.livraria;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LivrariaDBHelper helper = new LivrariaDBHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LivrariaContract.Livro.COLLUMN_TITULO,"Livro 1");
        values.put(LivrariaContract.Livro.COLLUMN_AUTOR,"JRR Martin");
        values.put(LivrariaContract.Livro.COLLUMN_ANO,2019);
        long novoID = db.insert(LivrariaContract.Livro.TABLE_NAME,null,values);
        Toast.makeText(this,"Novo registro criado com id: " + novoID,Toast.LENGTH_SHORT).show();

        String [] campos = {
                LivrariaContract.Livro._ID,
                LivrariaContract.Livro.COLLUMN_TITULO,
                LivrariaContract.Livro.COLLUMN_AUTOR,
                LivrariaContract.Livro.COLLUMN_ANO
        };
        Cursor c = db.query(LivrariaContract.Livro.TABLE_NAME, campos, null, null, null,null, null);

        int indexId = c.getColumnIndex(LivrariaContract.Livro._ID);
        int indexTitulo = c.getColumnIndex(LivrariaContract.Livro.COLLUMN_TITULO);
        int indexAutor = c.getColumnIndex(LivrariaContract.Livro.COLLUMN_AUTOR);
        int indexAno = c.getColumnIndex(LivrariaContract.Livro.COLLUMN_ANO);

        List<Livro> livros = new ArrayList<>();
        c.move(-1);
        while(c.moveToNext()){
            long id = c.getLong(indexId);
            String titulo = c.getString(indexTitulo);
            String autor = c.getString(indexAutor);
            Integer ano = c.getInt(indexAno);
            System.out.println(id + " " + titulo + " " + autor + " " + ano);
            livros.add(new Livro (id,titulo,autor,ano));
        }
        TextView txtLivros = (TextView) findViewById(R.id.txtLivros);
        txtLivros.setText(livros.toString());
    }
}
