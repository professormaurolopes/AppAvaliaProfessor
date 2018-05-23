package util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maurolcsilva on 14/11/2017.
 */

public class CriaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "bdavaliaprof.db";
    private static final int DB_VERSION = 2;
    private String comandosql;

    public CriaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        comandosql = "CREATE TABLE avaliaprofessor (" +
                "idavaliaprof   INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "disciplina     VARCHAR (50)," +
                "professor      VARCHAR (50)," +
                "nome           VARCHAR (50)," +
                "aula           VARCHAR (50)," +
                "nota           INTEGER," +
                "observacao     VARCHAR (50))";
        db.execSQL(comandosql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoantiga, int versaonova) {
        db.execSQL("DROP TABLE IF EXISTS avaliaprofessor");
        onCreate(db);
    }
}
