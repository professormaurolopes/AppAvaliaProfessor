package br.edu.ifma.dai.maurolcsilva.appavaliaprofessor;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import util.CriaDB;

public class frmPrincipal extends AppCompatActivity implements View.OnClickListener {
    private Spinner spnDisciplinas;
    private Spinner spnProfessores;
    private EditText txtAula;
    private RadioGroup rdgNotas;
    private CheckBox chkOb1;
    private CheckBox chkOb2;
    private Button btnSalvar;
    private Button btnListar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_principal);
        //Discplinas a serem apresentados no Spinner
        String disciplinas[]={"PDM","Sistemas Distribuídos","Banco de Dados","LP2","LP3"};
        //Professores a serem apresentados no Spinner
        String professores[] ={"Mauro Lopes","João Carlos","Carla Faria","Raimundo Osvaldo","Helder"};

        //Aqui iniciaremos nossa implementação
        spnDisciplinas = findViewById(R.id.spnDisciplinas);
        spnProfessores =  findViewById(R.id.spnProfessor);
        txtAula =  findViewById(R.id.edtAula);
        rdgNotas =  findViewById(R.id.rdgNotas);
        chkOb1 =  findViewById(R.id.chkObs01);
        chkOb2 =  findViewById(R.id.chkObs02);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnListar = findViewById(R.id.btnListar);
        //Registro dos Botões para que estes possam
        //ser acionados no momento do click
        btnSalvar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
        ArrayAdapter<String> adapterdisciplinas = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,disciplinas);
        spnDisciplinas.setAdapter(adapterdisciplinas);
        ArrayAdapter<String> adapterprofessores = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,professores);
        spnProfessores.setAdapter(adapterprofessores);

    }

    @Override
    public void onClick(View v) {

        int idBotaoClicado = 0;
        idBotaoClicado = v.getId();

        switch (idBotaoClicado){
            case R.id.btnSalvar:
                //Aciona a rotina de salvar dados
                recebeDados();
                break;
            case R.id.btnListar:
                //Aciona a rotina de listar dados
                listarDados();
                break;
        }
    }

    public void recebeDados(){
        int opcaoradio = rdgNotas.getCheckedRadioButtonId();
        int nota=0;
        String observacao="";
        String disciplina = "";
        String professor = "";
        String aula = "";

        //Recuperação dos dados dos Spinners
        disciplina = spnDisciplinas.getSelectedItem().toString();
        professor = spnProfessores.getSelectedItem().toString();
        aula = txtAula.getText().toString();

        //Recuperação do botão de radio selecionado
        switch (opcaoradio){
            case R.id.rdbNota10:
                nota = 10;
                break;

            case R.id.rdbNota9:
                nota = 9;
                break;

            case R.id.rdbNota8:
                nota = 8;
                break;

            case R.id.rdbNota7:
                nota = 7;
                break;

            //case R.id.rdFormularioNota6:
            //    nota = 6;
            //    break;
        }

        //Recuperação dos botões de CheckBox selecionados
        if(chkOb1.isChecked()){
            observacao = observacao + "Chegou Atrasado ";
        }

        if (chkOb2.isChecked()){
            observacao = observacao + "Tirou dúvida dos alunos";
        }

        //Após a recuperação dos dados, vamos acionar uma nova Activity
        //para apresentar os dados informados e confirmar o salvamento
        //dos mesmos
        Intent it = new Intent(this,MostraDados.class);
        Bundle params = new Bundle();
        params.putString("disciplina",disciplina);
        params.putString("professor",professor);
        params.putString("aula",aula);
        params.putString("observacao",observacao);
        params.putInt("nota",nota);
        it.putExtras(params);
        startActivity(it);
    }

    public void listarDados(){

        String msg;
        CriaDB criadb = new CriaDB(this);
        db = criadb.getWritableDatabase();
        String[] colunas = {"disciplina","professor","nota"};
        Cursor c = db.query("avaliaprofessor",colunas,null,null,null,null,null);
        while (c.moveToNext()){
            msg = c.getString(1);
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
        }

    }
}
