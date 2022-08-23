package com.example.appzero.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appzero.DAO.AlunoDAO;
import com.example.appzero.Model.Aluno;
import com.example.appzero.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("List");
        List<String> array =  new ArrayList<String>(Arrays.asList("Primeiro", "Segundo"));
        setContentView(R.layout.mainlayout);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,AlunoDAO.todos()));

        findViewById(R.id.floatingActionButton).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AddingScreen.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,AlunoDAO.todos()));


        listView.setOnItemClickListener((adapterView, view, i, l) ->{

            Aluno aluno = AlunoDAO.todos().get(i);
            Intent intent = new Intent(MainActivity.this, AddingScreen.class);
            intent.putExtra("aluno", aluno);
            startActivity(intent);
            Log.i("posicao do alunop", String.valueOf(l));
        });
    }
}
