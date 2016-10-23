package br.com.cristiana.pizzaria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class PizzariaActivity extends AppCompatActivity {

    RadioGroup rdgSabores;
    CheckBox ckbBorda;
    Spinner spFormaPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaria);

        rdgSabores = (RadioGroup) findViewById(R.id.rbgSabores);
        ckbBorda = (CheckBox) findViewById(R.id.ckbBorda);
        spFormaPagamento = (Spinner) findViewById(R.id.spFormaPagamento);

        //O evento ChangeListener verifica toda vez que for clicado o check
        rdgSabores.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //os parametros corresponde ao radiogrupo existente e o id correspondente ao item
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rbt_queijo){
                    ckbBorda.setEnabled(false);
                    ckbBorda.setChecked(false);
                } else {
                    ckbBorda.setEnabled(true);
                }
            }
        });

    }

    public void calcular(View v){

        int saborId = rdgSabores.getCheckedRadioButtonId();
        int valorSelecionado = spFormaPagamento.getSelectedItemPosition();

        String texto = spFormaPagamento.getSelectedItem().toString();

        double valor;
        if (saborId == R.id.rbt_queijo){
            valor = 10.00;
        }else if (saborId == R.id.rbtCalabresa) {
            valor = 15.00;
        } else {
            valor = 20.00;
        }

        if (ckbBorda.isChecked()){
            valor += 5.0;
        }

        Toast msg = Toast.makeText(this, getString(R.string.app_valor) + " " + valor + " "+ texto, Toast.LENGTH_SHORT);
        msg.show();
    }
}
