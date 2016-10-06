package dam.isi.frsf.utn.edu.ar.laboratorio04;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;

public class DepartamentoAdapter extends ArrayAdapter<Departamento>  {
    private LayoutInflater inflater;
    private Context contexto;
    private Departamento dpto;

    public DepartamentoAdapter(Context contexto, List<Departamento> items) {
        super(contexto, R.layout.fila, items);
        inflater = LayoutInflater.from(contexto);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DecimalFormat df = new DecimalFormat("#.##");
        View row = convertView;

        if (row == null) row = inflater.inflate(R.layout.fila, parent, false);

        dpto = this.getItem(position);


        TextView txtCiudad = (TextView) row.findViewById(R.id.ciudad);
        txtCiudad.setText(this.getItem(position).getCiudad().getNombre());
        TextView txtDescripcion = (TextView) row.findViewById(R.id.descripcion);
        txtDescripcion.setText("Unico!! " + this.getItem(position).getDescripcion());
        TextView txtPrecio = (TextView) row.findViewById(R.id.precio);
        txtPrecio.setText("$" + (df.format(this.getItem(position).getPrecio())));
        TextView txtCapacidad = (TextView) row.findViewById(R.id.capacidadMax);
        txtCapacidad.setText(this.getItem(position).getCapacidadMaxima()+".");
        return (row);

    }

}
