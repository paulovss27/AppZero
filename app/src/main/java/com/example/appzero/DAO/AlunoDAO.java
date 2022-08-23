package com.example.appzero.DAO;

import com.example.appzero.Model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final static List<Aluno> lista = new ArrayList<Aluno>();
    public void salva(Aluno aluno) {
    lista.add(aluno);
    }

    public static List<Aluno> todos(){
        return new ArrayList<Aluno>(lista);
    }
}
