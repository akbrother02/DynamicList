package loadingdata.ashish.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AtomPayListAdapter extends ArrayAdapter<AtomPayment> {

    private List<AtomPayment> items;
    private int layoutResourceId;
    private Context context;

    public AtomPayListAdapter(Context context, int layoutResourceId, List<AtomPayment> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AtomPaymentHolder holder = null;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        holder = new AtomPaymentHolder();
        holder.atomPayment = items.get(position);
        holder.name = (TextView) row.findViewById(R.id.name);
        holder.address = (TextView) row.findViewById(R.id.address);
        holder.spinner = (TextView) row.findViewById(R.id.spinner);

        row.setTag(holder);

        setupItem(holder);
        return row;
    }

    private void setupItem(AtomPaymentHolder holder) {
        holder.name.setText(holder.atomPayment.getName());
        holder.address.setText(holder.atomPayment.getAddress());
        holder.spinner.setText(holder.atomPayment.getSpinner());
    }

    public static class AtomPaymentHolder {
        AtomPayment atomPayment;
        TextView name;
        TextView address;
        TextView spinner;
    }
}
