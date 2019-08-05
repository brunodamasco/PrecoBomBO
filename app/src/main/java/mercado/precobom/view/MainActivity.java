package mercado.precobom.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import mercado.precobom.R;
import mercado.precobom.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void salvar(View v){
        control.salvarAction();
    }

    public void limpar(View v){
        control.limparAction();
    }
}
