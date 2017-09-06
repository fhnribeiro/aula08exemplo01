/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08exemplo01;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author 11944413600
 */
public class Aula08Exemplo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanelaTurmas janela = new JanelaTurmas(getSampleData());
        janela.setSize(400,300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    private static List<Turma> getSampleData() {
        // TODO code application logic here
        Aluno a1 = new Aluno("201365123","Huguinho");
        Aluno a2 = new Aluno("201365124","Zezinho");
        Aluno a3 = new Aluno("200565124","Luizinho");
        
        Turma t1 = new Turma("DCC171");
        Turma t2 = new Turma("DCC121");
        
        t1.getAlunos().add(a1);
        t1.getAlunos().add(a3);
        t2.getAlunos().add(a1);
        t2.getAlunos().add(a2);
        t2.getAlunos().add(a3);
        List<Turma> turmas = new ArrayList<>();
        turmas.add(t1);
        turmas.add(t2);
        return turmas;
    }
    
}
