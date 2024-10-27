package com.example.mycitizeninfoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mycitizeninfoapp.R;
import com.example.mycitizeninfoapp.model.Person;

import java.util.List;

public class PersonAdapter  extends ArrayAdapter<Person> {
    public PersonAdapter(Context context, List<Person> persons) {
        super(context,0, persons);
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_person, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.person_name);
        nameTextView.setText(person.getName());

        return convertView;
    }
}
