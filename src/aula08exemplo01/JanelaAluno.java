/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula08exemplo01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 11944413600
 */
public class JanelaAluno extends JFrame{

    private final JLabel lblMatricula = new JLabel("Matrícula");
    private final JTextField txtMatricula= new JTextField(30);
    
    private final JLabel lblNome = new JLabel("Nome");
    private final JTextField txtNome= new JTextField(30);
    
    private final JButton btnOk = new JButton("OK");
    private final JButton cancela = new JButton("Cancelar");
    private JanelaTurmas janelasTurmas;
    public JanelaAluno() throws HeadlessException {
        super("Criar novo aluno");
        //janelasTurmas=parentWindow;
        
        setResizable(false);
        setSize(200,90);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel principal = new JPanel(new GridLayout(3,2));
        principal.add(lblMatricula);
        principal.add(txtMatricula);
        principal.add(lblNome);
        principal.add(txtNome);
        
        
        add(principal, BorderLayout.CENTER);
        add(btnOk,BorderLayout.SOUTH);
        
        btnOk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMatricula.getText().isEmpty() && !txtNome.getText().isEmpty()){
                    Aluno a = new Aluno(txtMatricula.getText(),txtNome.getText());
                    janelasTurmas.addAlunos(a);
                }
                
            }
            
        });
    }

    public void setJanelasTurmas(JanelaTurmas janelasTurmas) {
        this.janelasTurmas = janelasTurmas;
    }

    void solicitaAluno() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        txtMatricula.setText("");
        txtMatricula.requestFocus();
        txtNome.setText("");
    }
    
    
    
}
