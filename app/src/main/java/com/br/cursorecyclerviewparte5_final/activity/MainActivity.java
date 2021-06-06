package com.br.cursorecyclerviewparte5_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.br.cursorecyclerviewparte5_final.R;
import com.br.cursorecyclerviewparte5_final.RecyclerItemClickListener;
import com.br.cursorecyclerviewparte5_final.adapter.Adapter;
import com.br.cursorecyclerviewparte5_final.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //Configurar Adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            //Modo 1 de aparecer a mensagem (escolha qual for a melhor opção)
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(getApplicationContext(),
                                    "Item pressionado - " + filme.getTitulo(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                            //Modo 2 de aparecer a mensagem (escolha qual for a melhor opção)
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(getApplicationContext(),
                                    filme.getTitulo(),
                                    Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    })
        );

    }

    public void criarFilmes(){


           /*
        Filme filme = new Filme("titulo", "genero", "2021");
        this.listaFilmes.add(filme);
         */

        Filme filme = new Filme("Sua vitória", "Fatos Reais", "2021");
        this.listaFilmes.add(filme);

        filme = new Filme("Senhor dos céus", "Ficção","2015");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem Aranha", "Fantasia", "2021");
        this.listaFilmes.add(filme);

        filme = new Filme("Super-Man","Fantasia","2020");
        this.listaFilmes.add(filme);

        filme = new Filme("Rebelde", "Comédia", "2009");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América", "Aventura/Ficção","2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Desenho","2019");
        this.listaFilmes.add(filme);

        filme = new Filme ("A Múmia","Terror","2015");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance","2017");
        listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2016");
        listaFilmes.add(filme);

    }
}