package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_item);
    }


    public void addItemToShoppingList(View view) {
        Button shoppingItemBtn = findViewById(view.getId());

        String shoppingItem = shoppingItemBtn.getText().toString();

        // send data back to MainActivity
        Intent replyIntent = new Intent(this, MainActivity.class);
        replyIntent.putExtra("shoppingItem", shoppingItem);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}