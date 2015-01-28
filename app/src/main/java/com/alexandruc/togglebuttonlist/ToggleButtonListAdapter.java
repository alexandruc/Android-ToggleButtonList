package com.alexandruc.togglebuttonlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleButtonListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ToggleButtonListAdapter(Context context, String[] values) {
        super(context, R.layout.activity_main, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.settings_text);
        ToggleButton toggleButton = (ToggleButton) rowView.findViewById(R.id.toggle_button);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            private final String[] values = getContext().getResources().getStringArray(R.array.Strings);

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), values[position] + " checked", Toast.LENGTH_LONG).show();
            }
        });

        textView.setText(values[position]);

        return rowView;
    }
}
