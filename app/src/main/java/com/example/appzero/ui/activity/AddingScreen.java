package com.example.appzero.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appzero.DAO.AlunoDAO;
import com.example.appzero.Model.Aluno;
import com.example.appzero.R;

import java.util.Random;

public class AddingScreen extends AppCompatActivity {


    private EditText nome;
    private EditText email;
    private EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlunoDAO dao = new AlunoDAO();
        setContentView(R.layout.activity_adding_screen);
        setTitle("Create New Entry");
        inicializar();

        Intent intent = getIntent();
        Aluno aluno1 = (Aluno) intent.getSerializableExtra("aluno");
        if(aluno1 !=null){
            nome.setText(aluno1.getNome());
            email.setText(aluno1.getEmail());
            tel.setText(aluno1.getTel());
        }



        Button botaoSalvar = findViewById(R.id.button);



        botaoSalvar.setOnClickListener((view) -> {

            String name = nome.getText().toString();
            String string_email = email.getText().toString();
            String string_tel = tel.getText().toString();
            view.setBackgroundColor(Colors.getRandomColor());
            Aluno aluno = new Aluno(name, string_tel, string_email);

            salvar(dao, name, string_email, string_tel, aluno);

//            startActivity(new Intent(AddingScreen.this, MainActivity.class));

            //iniciando uma activity a partir de outra
        });
    }

    private void inicializar() {
        nome = findViewById(R.id.name);
        email = findViewById(R.id.email);
        tel = findViewById(R.id.tel);
    }

    private void salvar(AlunoDAO dao, String name, String string_email, String string_tel, Aluno aluno) {
        dao.salva(aluno);
        finish();
        Toast.makeText(AddingScreen.this,
                name + " " + string_email + " " + string_tel,
                Toast.LENGTH_SHORT).show();
    }
}

class Colors {
    static int getRandomColor() {
        Random rnd = new Random();
        return android.graphics.Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}