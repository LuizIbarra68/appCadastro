package com.ibarra.appcadastro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etTelefone, etEmail;
    private CheckBox cbCaminhada, cbCorrida;
    private RadioButton rbFeminino, rbMasculino;
    private Button btnSalvar;

    private Spinner spinnerEstado, spinnerCidade;
    private ArrayAdapter adapter;
    private String[] listaCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


        spinnerCidade = (Spinner) findViewById(R.id.spCidade);
        spinnerEstado = (Spinner) findViewById(R.id.spEstado);

        listaCidades = new String[]{ getResources().getString(R.string.selecioneEstado) };
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listaCidades);
        spinnerCidade.setAdapter(adapter);

        spinnerCidade.setEnabled(false);

        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                carregarCidades();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void carregarCidades(){
        String[] AC = {
                getResources().getString(R.string.selecione), "Rio Branco"};
         String[] RS = {getResources().getString(R.string.selecione), "Alvorada",
                "Canoas", "Capão da Canoa", "Porto Alegre", "Viamão"};
          String[] SC = { getResources().getString(R.string.selecione), "Blumenau", "Florianopolis",
                "Passo de Torres", "Praia Grande"};
          String[] PR = { getResources().getString(R.string.selecione), "Curitiba", "Foz do Iguaçu",
                "Maringa"};

        int posicao = spinnerEstado.getSelectedItemPosition();

        switch (posicao){
            case 0:
                spinnerCidade.setEnabled(false);
                listaCidades = new String[]{
                        getResources().getString(R.string.selecioneEstado)};

                break;
            case 16:
                spinnerCidade.setEnabled(true);
                listaCidades = PR;

                break;
                case 21:
                spinnerCidade.setEnabled(true);
                listaCidades = RS;

                break;
                case 24:
                spinnerCidade.setEnabled(true);
                listaCidades = SC;

                break;
            case 1:
                spinnerCidade.setEnabled(true);
                listaCidades = AC;
                break;

             default:
                 spinnerCidade.setEnabled(true);
                 listaCidades = new String[]{
                         getResources().getString(R.string.selecione)
                 };
                 break;

        }

        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listaCidades);
        spinnerCidade.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_formulario, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( item.getItemId() == R.id.menu_sair ){
            finish();
        }
        if ( item.getItemId() == R.id._menu_limpar ){
            // implementar o limpar();
        }
        return super.onOptionsItemSelected(item);
    }

    private void limpar(){

    }
}
