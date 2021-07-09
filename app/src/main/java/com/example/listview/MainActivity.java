package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int [] imageId ={R.drawable.depredador,R.drawable.fondo,R.drawable.github,R.drawable.lluvia,R.drawable.signo,R.drawable.sol};
        String[] name = {"depredador","fondo","github","lluvia","signo","sol"};
        String[]lastmesage ={"hola","como","esta","el","dia","pepe perez"};
        String[] lastmsgtime={"8:40","2:12","7:08","3:23","9:09","10:45"};
        String[] telefono={"681678","267822","37862786","676785","756746","54324"};
        String[] country={"brasil","españa","india","filipinas","argentina","bolivia"};
        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i=0; i<imageId.length;i++){
            User user = new User(name[i],lastmesage[i],lastmsgtime[i],telefono[i],country[i],imageId[i]);
            userArrayList.add(user);
        }
        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intento = new Intent(MainActivity.this,UserActivity.class);
                intento.putExtra("name",name);
                intento.putExtra("phone",telefono);
                intento.putExtra("country",country);
                intento.putExtra("imageid",imageId);
                startActivity(intento);
            }
        });
    }
}