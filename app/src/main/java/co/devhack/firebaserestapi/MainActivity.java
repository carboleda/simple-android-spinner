package co.devhack.firebaserestapi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView tvCalorias;
    private List<String> lstNombresAlimentos;
    private List<Alimento> lstAlimentos;
    private AlimentoRepository alimentoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        alimentoRepository = new AlimentoRepositoryFirebase();
        lstNombresAlimentos = new ArrayList<>(0);
        lstAlimentos = new ArrayList<>(0);

        spinner = findViewById(R.id.spinner);
        tvCalorias = findViewById(R.id.tvCalorias);

        //Detectar cada vez que el usuaio cambie el item seleccionado en el spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Alimento alimento = lstAlimentos.get(position);
                tvCalorias.setText("Calorias: "+ String.valueOf(alimento.getCalorias()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Obtener el item seleccionado en el spinner
        //int position = spinner.getSelectedItemPosition();
        //Alimento alimento = lstAlimentos.get(position);

        cargarAlimentos();
    }

    private void cargarAlimentos() {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                alimentoRepository.getAllAlimentos(new Callback<List<Alimento>>() {
                    @Override
                    public void success(List<Alimento> result) {
                        lstAlimentos.clear();
                        lstAlimentos.addAll(result);

                        lstNombresAlimentos.clear();
                        for (Alimento alimento : lstAlimentos) {
                            lstNombresAlimentos.add(alimento.getNombre());
                        }
                    }

                    @Override
                    public void error(Exception error) {
                        error.printStackTrace();
                    }
                });
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                construirAdapter();
            }
        }.execute();
    }

    private void construirAdapter() {
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lstNombresAlimentos);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}
