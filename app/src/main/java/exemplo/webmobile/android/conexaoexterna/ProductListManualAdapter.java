package exemplo.webmobile.android.conexaoexterna;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wasabi on 2/2/2017.
 */

public class ProductListManualAdapter extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<UserList> userLists;

    public ProductListManualAdapter(Activity activity, ArrayList<UserList> userLists) {
        this.activity = activity;
        this.userLists = userLists;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return userLists.size();
    }

    @Override
    public Object getItem(int position) {
        return userLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userLists.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        v = inflater.inflate(R.layout.item_listuser, null);
        TextView txt_name = (TextView) v.findViewById(R.id.txt_name);
        TextView txt_id = (TextView) v.findViewById(R.id.txt_id);
        TextView txt_tel = (TextView) v.findViewById(R.id.txt_tel);
        TextView txt_email = (TextView) v.findViewById(R.id.txt_email);

        UserList userList = userLists.get(position);
        txt_name.setText(userList.getNome());
        txt_id.setText(userList.getId()+"");
        txt_tel.setText(userList.getTelefone());
        txt_email.setText(userList.getEmail());


        return v;
    }
}
