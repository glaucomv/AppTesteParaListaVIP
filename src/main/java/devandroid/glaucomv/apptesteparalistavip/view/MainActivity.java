package devandroid.glaucomv.apptesteparalistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.glaucomv.apptesteparalistavip.R;
import devandroid.glaucomv.apptesteparalistavip.controller.PessoaController;
import devandroid.glaucomv.apptesteparalistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor listateste;
    public static final String NOME_PREFERENCES = "pref_testelistavip";

    PessoaController controller;

    Pessoa pessoa;

    String dadosPessoa;

    EditText editTextNome;
    EditText editTextSobrenome;
    EditText editTextParentesco;
    EditText editTextTelefone;

    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        listateste = preferences.edit();

        controller = new PessoaController();

        pessoa = new Pessoa();
        pessoa.setNome(preferences.getString("Nome",""));
        pessoa.setSobrenome(preferences.getString("Sobrenome",""));
        pessoa.setParentesco(preferences.getString("Parentesco",""));
        pessoa.setTelefone(preferences.getString("Telefone",""));

        editTextNome = findViewById(R.id.editTextNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextParentesco = findViewById(R.id.editTextParentesco);
        editTextTelefone = findViewById(R.id.editTextTelefone);

        editTextNome.setText(pessoa.getNome());
        editTextSobrenome.setText(pessoa.getSobrenome());
        editTextParentesco.setText(pessoa.getParentesco());
        editTextTelefone.setText(pessoa.getTelefone());

        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextNome.setText("");
                editTextSobrenome.setText("");
                editTextParentesco.setText("");
                editTextTelefone.setText("");

                listateste.clear();
                listateste.apply();

                controller.limpar();

            }
        });

        buttonFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Volte Sempre!!!", Toast.LENGTH_LONG).show();
            finish();
            controller.finalizar();
        });
        buttonSalvar.setOnClickListener(view -> {

            pessoa.setNome(editTextNome.getText().toString());
            pessoa.setSobrenome(editTextSobrenome.getText().toString());
            pessoa.setParentesco(editTextParentesco.getText().toString());
            pessoa.setTelefone(editTextTelefone.getText().toString());

            Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_LONG).show();

            listateste.putString("Nome",pessoa.getNome());
            listateste.putString("Sobrenome",pessoa.getSobrenome());
            listateste.putString("Parentesco",pessoa.getParentesco());
            listateste.putString("Telefone",pessoa.getTelefone());
            listateste.apply();

            controller.salvar(pessoa);
        });

        dadosPessoa = pessoa.getNome();
        dadosPessoa = pessoa.getSobrenome();
        dadosPessoa = pessoa.getParentesco();
        dadosPessoa = pessoa.getTelefone();

        Log.i("POOAndroid", pessoa.toString());

    }
}