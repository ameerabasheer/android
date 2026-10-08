package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gridview.R;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    int[] images = {
            R.drawable.bike,
            R.drawable.bus,
            R.drawable.car,
            R.drawable.ship,
            R.drawable.plain,
            R.drawable.train
    };

    String[] names = {
            "Bike",
            "Bus",
            "Car",
            "Ship",
            "Plane",
            "Train"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        ImageAdapter adapter = new ImageAdapter(this, images);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        showAlertDialog(position);
                    }
                }
        );
    }

    private void showAlertDialog(int position) {

        ImageView imageView =
                new ImageView(MainActivity.this);

        imageView.setImageResource(images[position]);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);

        builder.setTitle(names[position]);

        builder.setMessage(
                "You selected " + names[position]
        );

        builder.setIcon(images[position]);

        builder.setView(imageView);

        builder.setPositiveButton("OK", null);

        builder.show();
    }
}

