/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08exemplo01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 11944413600
 */
public class Turma {
    private String codigo;
    private List<Aluno> alunos;

    public Turma(){
        this(null);
    }
    
    public Turma(String codigo){
        this.alunos = new ArrayList<>();
        this.codigo=codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    @Override
    public String toString(){
        return this.codigo+" ("+this.alunos.size()+" alunos)";
    }
    
}
