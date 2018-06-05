package modelo;

public class AvaliaProfessor {
    private int idavaliaprof;
    private String disciplina;
    private String professor;
    private String aula;
    private int nota;
    private String observacao;

    public int getIdavaliaprof() {
        return idavaliaprof;
    }

    public void setIdavaliaprof(int idavaliaprof) {
        this.idavaliaprof = idavaliaprof;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
