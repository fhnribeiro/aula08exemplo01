/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08exemplo01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author 11944413600
 */
class JanelaTurmas extends JFrame{
    
    private final List<Turma> turmas;
    private final JList<Turma> lstTurmas= new JList<>(new DefaultListModel<>());
    private final JList<Aluno> lstAlunos= new JList<>(new DefaultListModel<>());
    private final JButton criaTurma = new JButton("Cria turma");
    private final JButton excluiTurma = new JButton("Exclui turma");
    private final JButton criaAluno = new JButton("Cria aluno");
    private final JButton excluiAluno = new JButton("Exclui aluno");
    private final JanelaAluno janelaAluno = new JanelaAluno();
    
    public JanelaTurmas(List<Turma> sampleData) {
        
        super("Turmas");
        
        setMinimumSize(new Dimension(500,300));
        
        this.turmas = sampleData;
        
        lstTurmas.setModel(new TurmasListModel(turmas));
        
        lstTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Box botoes = Box.createHorizontalBox();
        
        JPanel botoes = new JPanel(new GridLayout(1,4));
        
        botoes.add(criaTurma);
        botoes.add(excluiTurma);
        botoes.add(criaAluno);
        botoes.add(excluiAluno);
        
        add(botoes,BorderLayout.SOUTH);
        
        add(new JScrollPane(lstTurmas),BorderLayout.WEST);
        
        add(new JScrollPane(lstAlunos),BorderLayout.CENTER);
        janelaAluno.setJanelasTurmas(this);
        
        lstTurmas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Turma selecionada = lstTurmas.getSelectedValue();
                if(selecionada != null){
                    lstAlunos.setModel( new AlunosListModel1(selecionada.getAlunos() ) );
                }else{
                    lstAlunos.setModel( new DefaultListModel<>());
                }
            }
        });
        
        criaTurma.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog("Codigo da nova turma");
                if(cod != null && !cod.isEmpty()){
                    Turma t=new Turma(cod);
                    turmas.add(t);
                    lstTurmas.updateUI();
                }
                
            }
            
        });
        
        excluiTurma.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!lstTurmas.isSelectionEmpty()){
                    turmas.remove(lstTurmas.getSelectedValue());
                    lstTurmas.clearSelection();
                    lstTurmas.updateUI();
                }
            }
            
        });
        
         criaAluno.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(!lstTurmas.isSelectionEmpty()){
                    janelaAluno.solicitaAluno();    
                }
                
            }
            
        });
    
    }

    void addAlunos(Aluno a) {
        lstTurmas.getSelectedValue().getAlunos().add(a);
        lstTurmas.updateUI();
        lstAlunos.updateUI();
        janelaAluno.setVisible(false);
    }
    
}
