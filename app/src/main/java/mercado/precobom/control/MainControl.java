package mercado.precobom.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mercado.precobom.R;
import mercado.precobom.model.Produto;
import mercado.precobom.model.ProdutoBO;

public class MainControl {
    private Activity activity;
    private EditText editNome;
    private EditText editValor;
    private EditText editParcela;
    private EditText editJuros;
    private TextView tvResultado;
    private LinearLayout layoutResultado;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editValor = activity.findViewById(R.id.editValor);
        editParcela = activity.findViewById(R.id.editParcela);
        editJuros = activity.findViewById(R.id.editJuros);
        tvResultado = activity.findViewById(R.id.tvResultado);
        layoutResultado = activity.findViewById(R.id.layoutRes);
    }

    public void salvarAction(){
        Produto p = new Produto();
        p.setNome(editNome.getText().toString());
        p.setValor(editValor.getText().toString());
        p.setParcela(editParcela.getText().toString());
        p.setJuros(editJuros.getText().toString());


        if (p.getNome().isEmpty()){
            editNome.setError("Digite o nome corretamente");
            editNome.requestFocus();
            return;
        }

        if (!ProdutoBO.validaValor(p)){
            editValor.setError(activity.getString(R.string.valor_invalido));
            Toast.makeText(activity, R.string.valor_invalido, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaParcela(p)){
            editParcela.setError(activity.getString(R.string.valor_invalido_parcela));
            Toast.makeText(activity, R.string.valor_invalido_parcela, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaJuros(p)){
            editJuros.setError(activity.getString(R.string.valor_invalido_juros));
            Toast.makeText(activity, R.string.valor_invalido_juros, Toast.LENGTH_SHORT).show();
            return;
        }

        ProdutoBO pBO = new ProdutoBO(p);

        // Saída Estática
        tvResultado.setText(pBO.toString());

        /*// Saída Dinâmica
        TextView tvNewResultado = new TextView(activity);
        tvNewResultado.setText(pBO.toString());
        layoutResultado.addView(tvNewResultado);*/
    }

    public void limparForm(){
        editNome.setText("");
        editValor.setText("");
        editParcela.setText("");
        editJuros.setText("");
        editNome.requestFocus();
    }

    public void limparAction(){
        limparForm();
        tvResultado.setText("");
        layoutResultado.removeAllViews();
    }
}
