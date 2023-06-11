package devandroid.glaucomv.apptesteparalistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.glaucomv.apptesteparalistavip.R;
import devandroid.glaucomv.apptesteparalistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

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

        pessoa = new Pessoa();
        pessoa.setNome("Marco");
        pessoa.setSobrenome("Maddo");
        pessoa.setParentesco("Pai");
        pessoa.setTelefone("21985655847");

        editTextNome = findViewById(R.id.editTextNome);
        editTextSobrenome = findViewById(R.id.editTextSobrenome);
        editTextParentesco = findViewById(R.id.editTextParentesco);
        editTextTelefone = findViewById(R.id.editTextTelefone);

        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);

        editTextNome.setText(pessoa.getNome());
        editTextSobrenome.setText(pessoa.getSobrenome());
        editTextParentesco.setText(pessoa.getParentesco());
        editTextTelefone.setText(pessoa.getTelefone());

        buttonLimpar.setOnClickListener(view -> {
            editTextNome.setText("");
            editTextSobrenome.setText("");
            editTextParentesco.setText("");
            editTextTelefone.setText("");
        });
        buttonFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Volte Sempre!!!", Toast.LENGTH_LONG).show();
            finish();
        });
        buttonSalvar.setOnClickListener(view -> {

            pessoa.setNome(editTextNome.getText().toString());
            pessoa.setSobrenome(editTextSobrenome.getText().toString());
            pessoa.setParentesco(editTextParentesco.getText().toString());
            pessoa.setTelefone(editTextTelefone.getText().toString());

            Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_LONG).show();

        });

        dadosPessoa = pessoa.getNome();
        dadosPessoa = pessoa.getSobrenome();
        dadosPessoa = pessoa.getParentesco();
        dadosPessoa = pessoa.getTelefone();

        Log.i("POOAndroid", pessoa.toString());

    }
}