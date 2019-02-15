package com.example.festafimdeano.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.festafimdeano.Contantes.FimDeAnoConstants;
import com.example.festafimdeano.R;
import com.example.festafimdeano.Util.SecurityPrefences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  ViewHolder mViewHolder = new ViewHolder();
    private SecurityPrefences mSecurityPrefences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textDias = findViewById(R.id.dataHoje);
        this.mViewHolder.textRestantes = findViewById(R.id.diasRestantes);
        this.mViewHolder.buttonConfirmar = findViewById(R.id.button_confirmar);

        this.mViewHolder.buttonConfirmar.setOnClickListener(this);
        this.mSecurityPrefences =  new SecurityPrefences(this);

    }

    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onResume(){
        super.onResume();
        this.verifyPresence();
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirmar){

            String presence = this.mSecurityPrefences.getStoredString(FimDeAnoConstants.PRESENSE);

            //Logica do Botão
            Intent intent = new Intent(this,Detalhes.class);
            intent.putExtra(FimDeAnoConstants.PRESENSE,presence);
            startActivity(intent);
        }
    }
    private void verifyPresence(){
        String presence = this.mSecurityPrefences.getStoredString(FimDeAnoConstants.PRESENSE);

        if (presence.equals(""))
            this.mViewHolder.buttonConfirmar.setText(getString(R.string.nao_confirmado));

        else if (presence.equals(FimDeAnoConstants.CONFIRMAR))
            this.mViewHolder.buttonConfirmar.setText(getString(R.string.confirmado));

        else
            this.mViewHolder.buttonConfirmar.setText(R.string.nao);
        }

    private static class ViewHolder{
        TextView textDias;
        TextView textRestantes;
        Button buttonConfirmar;

    }
}
