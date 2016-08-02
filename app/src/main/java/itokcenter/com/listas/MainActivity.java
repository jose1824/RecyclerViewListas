package itokcenter.com.listas;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLista;
    RecyclerAdapter recyclerAdapter;
    private List<ItemRC> listaRC = new ArrayList<ItemRC>();

    private CoordinatorLayout coordinatorLayout;
    private TextInputLayout textInputLayout;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewLista = (RecyclerView) findViewById(R.id.main_recycler1);
/*
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Andy"));
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Facebook"));
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Google"));
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Youtube"));
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Twitter"));
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Apple"));
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, "Microsoft"));
*/
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerViewLista.setLayoutManager(layoutManager);

        recyclerAdapter = new RecyclerAdapter(listaRC, MainActivity.this);
        recyclerViewLista.setAdapter(recyclerAdapter);
        //-----------------------------------------------------------------------------------------
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_cooordinator);
        textInputLayout = (TextInputLayout) findViewById(R.id.main_til_nombre);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.main_swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                recyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_solo_mas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_agregar) {
            agregarLista();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void agregarLista() {
        listaRC.add(new ItemRC(R.mipmap.ic_launcher, textInputLayout.getEditText().getText().toString()));
        recyclerAdapter.notifyDataSetChanged();
        textInputLayout.getEditText().setText("");
        Snackbar.make(coordinatorLayout, "Se ha agregado " + textInputLayout.getEditText().getText().toString(), Snackbar.LENGTH_LONG)
                .setAction("Actualizar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recyclerAdapter.notifyDataSetChanged();
                    }
                })
                .setActionTextColor(Color.MAGENTA)
                .show();
    }
}
