package com.example.activityLifeCycleAndState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_SHOPPING_ITEM_REQUEST = 1;
    private int currentShoppingListRow = 0;
    private TextView currentShoppingList;
    private String[] shoppingListArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shoppingListArray = new String[10];

        // restore the state
        if (savedInstanceState != null) {
            shoppingListArray = savedInstanceState.getStringArray("shoppingListArray");
            currentShoppingListRow = savedInstanceState.getInt("currentShoppingListRow");

            for (int row = 0; row < shoppingListArray.length; row++) {
                currentShoppingList = getCurrentShoppingListTxtView(row);
                currentShoppingList.setText(shoppingListArray[row]);
            }
        }
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, ShoppingItem.class);
        startActivityForResult(intent, ADD_SHOPPING_ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_SHOPPING_ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra("shoppingItem");

                if (currentShoppingListRow > 9) {
                    currentShoppingListRow = 0;
                }

                currentShoppingList = getCurrentShoppingListTxtView(currentShoppingListRow);

                if (currentShoppingList != null) {
                    currentShoppingList.setText(item);
                    shoppingListArray[currentShoppingListRow] = item;
                    ++currentShoppingListRow;
                }
            }
        }
    }

    private TextView getCurrentShoppingListTxtView(int currentShoppingListRow) {
        switch (currentShoppingListRow) {
            case 0:
                return findViewById(R.id.list_1);
            case 1:
                return findViewById(R.id.list_2);
            case 2:
                return findViewById(R.id.list_3);
            case 3:
                return findViewById(R.id.list_4);
            case 4:
                return findViewById(R.id.list_5);
            case 5:
                return findViewById(R.id.list_6);
            case 6:
                return findViewById(R.id.list_7);
            case 7:
                return findViewById(R.id.list_8);
            case 8:
                return findViewById(R.id.list_9);
            case 9:
                return findViewById(R.id.list_10);
        }

        return null;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArray("shoppingListArray", shoppingListArray);
        outState.putInt("currentShoppingListRow", currentShoppingListRow);
    }
}