package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper;
    private SQLiteDatabase database;

    private ListView listView;
    private Button saladsCategoryBtn, soupsCategoryBtn, hotCategoryBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        saladsCategoryBtn = findViewById(R.id.saladsCategoryBtn);
        soupsCategoryBtn = findViewById(R.id.soupsCategoryBtn);
        hotCategoryBtn = findViewById(R.id.hotCategoryBtn);

        helper = new DBHelper(getApplicationContext());
        try {
            database = helper.getWritableDatabase();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        saladsCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> recipes = new ArrayList<>();
                HashMap<String, String> recipe;

                Cursor cursor = database.rawQuery("SELECT * FROM recipes WHERE category = 1", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    recipe = new HashMap<>();
                    recipe.put("recipeName", cursor.getString(1));
                    recipe.put("recipeCategory", cursor.getString(2));
                    recipes.add(recipe);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        recipes,
                        android.R.layout.simple_list_item_2,
                        new String[]{"recipeName", "recipeCategory"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

                listView.setAdapter(adapter);
            }
        });

        soupsCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> recipes = new ArrayList<>();
                HashMap<String, String> recipe;

                Cursor cursor = database.rawQuery("SELECT * FROM recipes WHERE category = 2", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    recipe = new HashMap<>();
                    recipe.put("recipeName", cursor.getString(1));
                    recipe.put("recipeCategory", cursor.getString(2));
                    recipes.add(recipe);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        recipes,
                        android.R.layout.simple_list_item_2,
                        new String[]{"recipeName", "recipeCategory"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

                listView.setAdapter(adapter);
            }
        });

        hotCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> recipes = new ArrayList<>();
                HashMap<String, String> recipe;

                Cursor cursor = database.rawQuery("SELECT * FROM recipes WHERE category = 3", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    recipe = new HashMap<>();
                    recipe.put("recipeName", cursor.getString(1));
                    recipe.put("recipeCategory", cursor.getString(2));
                    recipes.add(recipe);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        recipes,
                        android.R.layout.simple_list_item_2,
                        new String[]{"recipeName", "recipeCategory"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

                listView.setAdapter(adapter);
            }
        });
    }
}