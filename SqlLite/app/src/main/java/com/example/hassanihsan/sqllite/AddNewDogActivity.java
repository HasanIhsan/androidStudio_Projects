package com.example.hassanihsan.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewDogActivity  extends Activity implements OnClickListener {

    private EditText uGraduateNameEditText;
    private EditText uGraduateUniIdEditText;
    private EditText uGraduateGpaEditText;
    private Button cancelButton;
    private Button saveButton;

    private ArrayList<Dog> DogArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dog);

        uGraduateNameEditText = (EditText) findViewById(R.id.insertNewDog_name_editText);



        saveButton = (Button) findViewById(R.id.insertNewDog_save_button);
        saveButton.setOnClickListener(this);

        DogArrayList = new ArrayList<Dog>();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.insertNewDog_save_button){
            // Get the values provided by the user via the UI
            String providedUgraduateName = uGraduateNameEditText.getText().toString();


            // Pass above values to the setter methods in POJO class
            Dog undergraduateDetailsPojoObj = new Dog();
            undergraduateDetailsPojoObj.setuGraduateName(providedUgraduateName);


            // Add an undergraduate with his all details to a ArrayList
            DogArrayList.add(undergraduateDetailsPojoObj);

            // Inserting undergraduate details to the database is doing in a separate method
            insertUndergraduate(undergraduateDetailsPojoObj);

            // Release from the existing UI and go back to the previous UI
            setContentView(R.layout.activity_dog_list_actitivy);
        }
    }

    public void insertUndergraduate(Dog paraUndergraduateDetailsPojoObj){

        // First we have to open our DbHelper class by creating a new object of that
        AndroidOpenDbHelper androidOpenDbHelperObj = new AndroidOpenDbHelper(this);

        // Then we need to get a writable SQLite database, because we are going to insert some values
        // SQLiteDatabase has methods to create, delete, execute SQL commands, and perform other common database management tasks.
        SQLiteDatabase sqliteDatabase = androidOpenDbHelperObj.getWritableDatabase();

        // ContentValues class is used to store a set of values that the ContentResolver can process.
        ContentValues contentValues = new ContentValues();

        // Get values from the POJO class and passing them to the ContentValues class
        contentValues.put(AndroidOpenDbHelper.COLUMN_NAME_UNDERGRADUATE_NAME, paraUndergraduateDetailsPojoObj.getuGraduateName());

        // Now we can insert the data in to relevant table
        // I am going pass the id value, which is going to change because of our insert method, to a long variable to show in Toast
        long affectedColumnId = sqliteDatabase.insert(AndroidOpenDbHelper.TABLE_NAME_GPA, null, contentValues);

        // It is a good practice to close the database connections after you have done with it
        sqliteDatabase.close();

        // I am not going to do the retrieve part in this post. So this is just a notification for satisfaction ;-)
        Toast.makeText(this, "Values inserted column ID is :" + affectedColumnId, Toast.LENGTH_SHORT).show();

    }
}