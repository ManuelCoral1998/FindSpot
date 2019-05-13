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

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Edificio> listaEdifcios;

    public Adapter(Context context, ArrayList<Edificio> listItems) {
        this.context = context;
        this.listaEdifcios = listItems;
    }

    @Override
    public int getCount() {
        return listaEdifcios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEdifcios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Edificio edificio = (Edificio) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.renglon_edificos, null);
        ImageView logo = (ImageView) convertView.findViewById(R.id.logo_proyecto_renglon);
        TextView nombre_piso = (TextView) convertView.findViewById(R.id.nombre_edificio);
        TextView mesasTotales = (TextView) convertView.findViewById(R.id.mesas_totales);
        TextView mesasDisponibles = (TextView) convertView.findViewById(R.id.mesas_disponibles);

        logo.setImageResource(R.drawable.edificios_3d);
        nombre_piso.setText("Edificio "+ edificio.getNombreEdificio());
        mesasDisponibles.setText("Mesas Disponibles: " +edificio.getcantidadMesasDisponibles());
        mesasTotales.setText("Mesas Totales: "+edificio.getCantidadMesas());

        return convertView;
    }

}
