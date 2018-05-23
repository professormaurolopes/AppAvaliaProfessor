package br.edu.ifma.dai.maurolcsilva.appavaliaprofessor;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import util.CriaDB;

public class MostraDados extends AppCompatActivity {

    private TextView lblDisciplina;
    private TextView lblProfessor;
    private TextView lblAula;
    private TextView lblNota;
    private TextView lblObservcao;
    private SQLiteDatabase db;
    private String professor;
    private String disciplina;
    private String aula;
    private String observacao;
    private int nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_dados);
        //Recuperação da Intent (it)
        Intent itrecepcao = getIntent();
        //Recuperação do Bundle a partir da Intent recebida
        Bundle parametros = itrecepcao.getExtras();
        professor = parametros.getString("professor");
        disciplina = parametros.getString("disciplina");
        aula = parametros.getString("aula");
        observacao = parametros.getString("observacao");
        nota = parametros.getInt("nota");
        //Recuperação dos Componentes
        lblDisciplina = findViewById(R.id.lblMostraDadosDisciplinaConteudo);
        lblProfessor = findViewById(R.id.lblMostraDadosProfessorConteudo);
        lblAula = findViewById(R.id.lblMostraDadosAulaConteudo);
        lblNota = findViewById(R.id.lblMostraDadosNotaConteudo);
        //Associação de conteudo vindo da Intent junto aos componentes de tela
        lblDisciplina.setText(disciplina);
        lblProfessor.setText(professor);
        lblAula.setText(aula);
        lblNota.setText(String.valueOf(nota));
        //Criação do Banco de Dados
        CriaDB criabd = new CriaDB(this);
        db = criabd.getWritableDatabase();
    }

    public void gravarDados(View v){
        ContentValues valores = new ContentValues();
        valores.put("disciplina",disciplina);
        valores.put("professor", professor);
        valores.put("aula",aula);
        valores.put("nota",nota);
        valores.put("observacao",observacao);
        db.insert("avaliaprofessor",null,valores);
    }
}
