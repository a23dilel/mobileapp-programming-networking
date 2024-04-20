package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    // Grab URL from API and store in a variable
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new JsonFile(this, this).execute(JSON_FILE);

        // JSONTask does checking if JSON_URL is validate, network and then active the function onPostExecute().
        new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public void onPostExecute(String json) {

        // Check if JSON is not NULL
        try {
            // Take JSON-data and turn into an array
            JSONArray arr = new JSONArray(json);

            // Take a Mountain class which can hold of arrays
            ArrayList<Mountain> mountains = new ArrayList<>();

            // Each object get string of specific name and add each name on constructor from mountains.
            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject object = arr.getJSONObject(i);

                String id = object.getString("ID");
                String name = object.getString("name");
                String type = object.getString("type");
                String location = object.getString("location");
                int size = object.getInt("size");
                int cost = object.getInt("cost");

                mountains.add(new Mountain(id, name, type, location, size, cost));
            }

            // RecyclerView grab recycler_view from activity_main.xml so att kan print data on the layout.
            RecyclerView recyclerView = findViewById(R.id.recycler_view);

            // Before showing data on the layout, must have an adapter which can bind data (mountains) and print out on the linear layout.
            adapter = new RecyclerViewAdapter(this, mountains);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // After that adapter send a message about data has changed.
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            Log.e("MainActivity==>","E:"+e.getMessage());
        }
    }
}
