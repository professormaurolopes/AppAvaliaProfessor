package dao;

import android.content.ContentValues;

import java.util.ArrayList;

import modelo.AvaliaProfessor;

public class DAOAvaliaProfessor {

    public ArrayList<AvaliaProfessor> listar(){
        return null;
    }

    public boolean salvar(AvaliaProfessor ap){

        ContentValues valores = new ContentValues();
        valores.put("disciplina",ap.getDisciplina());
        valores.put("professor", ap.getProfessor());
        valores.put("aula",ap.getAula());
        valores.put("nota",ap.getNota());
        valores.put("observacao",ap.getObservacao());
        //db.insert("avaliaprofessor",null,valores);

        return false;
    }


}
