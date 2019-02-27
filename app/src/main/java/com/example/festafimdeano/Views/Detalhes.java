package com.example.festafimdeano.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.festafimdeano.R;
import com.example.festafimdeano.Util.SecurityPrefences;
import com.example.festafimdeano.Contantes.FimDeAnoConstants;

public class Detalhes extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPrefences mSecurityPrefences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        // Desativa nome do Aplicativo no Topo.
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Mostrar icone no lugar de Texto
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        this.mSecurityPrefences = new SecurityPrefences(this);

        this.mViewHolder.check_participar = findViewById(R.id.checkParticipar);
        this.mViewHolder.check_participar.setOnClickListener(this);
        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.checkParticipar) {
            if (this.mViewHolder.check_participar.isChecked()) {
                this.mSecurityPrefences.storyString(FimDeAnoConstants.PRESENSE, FimDeAnoConstants.CONFIRMAR);
            } else {
                this.mSecurityPrefences.storyString(FimDeAnoConstants.PRESENSE, FimDeAnoConstants.NAOCONFIRMAR);

            }
        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(FimDeAnoConstants.PRESENSE);
            if (presence.equals(FimDeAnoConstants.CONFIRMAR)) {
                this.mViewHolder.check_participar.setChecked(true);
            } else {
                this.mViewHolder.check_participar.setChecked(false);
            }


        }

    }

    private static class ViewHolder {
        CheckBox check_participar;
    }
}
