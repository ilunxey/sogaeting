package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TileActivity extends AppCompatActivity {

    private TextView tvTileTitle;
    private TextView tvTileDescription;
    private Button btnGoResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile);

        tvTileTitle = findViewById(R.id.tvTileTitle);
        tvTileDescription = findViewById(R.id.tvTileDescription);
        btnGoResult = findViewById(R.id.btnGoResult);

        // MainActivity에서 보낸 현재 칸 번호 받기
        Intent receivedIntent = getIntent();
        int position = receivedIntent.getIntExtra("position", 0);

        String title = TileInfoProvider.getTitle(position);
        String desc = TileInfoProvider.getDescription(position);

        tvTileTitle.setText(title);
        tvTileDescription.setText(desc);

        TemiController.speakForTile(position, desc);

        btnGoResult.setOnClickListener(v -> {
            Intent goResult = new Intent(TileActivity.this, ResultActivity.class);
            goResult.putExtra("position", position);
            startActivity(goResult);
        });

    }
}
