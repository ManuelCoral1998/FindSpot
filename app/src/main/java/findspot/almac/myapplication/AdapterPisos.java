package findspot.almac.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import findspot.almac.myapplication.model.Edificio;
import findspot.almac.myapplication.model.Mesa;
import findspot.almac.myapplication.model.Piso;

public class AdapterPisos extends BaseAdapter {

    private Context context;
    private ArrayList<Piso> listaMesas;

    public AdapterPisos(Context context, ArrayList<Piso> listItems) {
        this.context = context;
        this.listaMesas = listItems;
    }

    @Override
    public int getCount() {
        return listaMesas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMesas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Piso piso = (Piso) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.renglon_pisos, null);
        ImageView logo = (ImageView) convertView.findViewById(R.id.logo_proyecto_renglon_mesas);
        TextView nombre_piso = (TextView) convertView.findViewById(R.id.nombre_piso);
        TextView mesasDisponibles = (TextView) convertView.findViewById(R.id.mesas_disponibles_renglon);

        logo.setImageResource(R.drawable.silla);
        nombre_piso.setText("Piso "+ piso.getNombrePiso());
        mesasDisponibles.setText("Mesas Disponibles: " +piso.getMesasDisponibles());

        return convertView;
    }

}
