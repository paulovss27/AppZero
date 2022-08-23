package com.example.appzero.Model;

import android.widget.EditText;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private final String nome;
    private final String tel;
    private final String email;

    public Aluno(String nome, String tel, String email) {
        this.nome = nome;
        this.tel = tel;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
