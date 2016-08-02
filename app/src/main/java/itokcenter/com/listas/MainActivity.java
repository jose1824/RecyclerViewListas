package itokcenter.com.listas;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLista;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewLista = (RecyclerView) findViewById(R.id.main_recycler1);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_cooordinator);
        Button btnPresiona= (Button)findViewById(R.id.main_btn1);


        recyclerViewLista.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewLista.setLayoutManager(layoutManager);
        //recyclerViewLista.setAdapter();

        btnPresiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Bienvenido", Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
