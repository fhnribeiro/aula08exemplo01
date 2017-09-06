/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08exemplo01;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author 11944413600
 */
public class AlunosListModel1 implements ListModel<Aluno> {
    
    List<Aluno> alunos;
    private final List<ListDataListener> dataListeners;

    public AlunosListModel1(List<Aluno> alunos) {
       this.alunos=alunos;
       dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return alunos.size();
    }

    @Override
    public Aluno getElementAt(int index) {
        return alunos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }
    
}
