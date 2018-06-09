package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import modelo.AvaliaProfessor;
import util.DBGateway;

public class DAOAvaliaProfessor {

    private final String TABELA = "avaliaprofessor";
    private DBGateway gw;
    private ArrayList<AvaliaProfessor> lista;

    public DAOAvaliaProfessor(Context ctx){
        gw = DBGateway.getInstance(ctx);
    }

    public ArrayList<AvaliaProfessor> listar(){

        String colunas[] = {"professor","disciplina","aula","nota","observacao"};
        lista = new ArrayList<AvaliaProfessor>();

        Cursor cursor = gw.getDatabase().query(TABELA,colunas,null,null,null,null,null);
        while(cursor.moveToNext()){
            AvaliaProfessor ap = new AvaliaProfessor();
            ap.setProfessor(cursor.getString(0));
            ap.setDisciplina(cursor.getString(1));
            ap.setAula(cursor.getString(2));
            ap.setNota(cursor.getInt(3));
            ap.setObservacao(cursor.getString(4));
            lista.add(ap);
        }
        return lista;
    }

    public boolean salvar(AvaliaProfessor ap){
        boolean ret = false;
        ContentValues valores = new ContentValues();
        valores.put("disciplina",ap.getDisciplina());
        valores.put("professor", ap.getProfessor());
        valores.put("aula",ap.getAula());
        valores.put("nota",ap.getNota());
        valores.put("observacao",ap.getObservacao());
        long retorno = gw.getDatabase().insert(TABELA,null,valores);
        if (retorno>0)
            ret = true;
        return ret;
    }


}
