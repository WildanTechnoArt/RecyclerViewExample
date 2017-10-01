package android.cianjur.developer.net.recyclerviewexample;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> arrayList;
    private ArrayList<Integer> memeList;

    public RecyclerViewAdapter(ArrayList<String> arrayList, ArrayList<Integer> memeList){
        this.arrayList = arrayList;
        this.memeList = memeList;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView JudulMeme, SubMeme;
        private ImageView Meme;
        private RelativeLayout ItemList;

        public ViewHolder(View itemView) {
            super(itemView);
            JudulMeme = itemView.findViewById(R.id.memetitle);
            SubMeme = itemView.findViewById(R.id.sub_meme);
            Meme = itemView.findViewById(R.id.meme);
            ItemList = itemView.findViewById(R.id.item_list);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Memasukan Nilai/Value Pada View-View Yang Telah Dibuat
        final String Nama = arrayList.get(position);
        holder.JudulMeme.setText(Nama);
        holder.SubMeme.setText("Gambar Meme Ke: "+position);
        holder.Meme.setImageResource(memeList.get(position));
        holder.JudulMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(Nama);
            }
        });
        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Nama Saya: "+Nama, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void remove(String item){
        int position = arrayList.indexOf(item);
        arrayList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return arrayList.size();
    }

}
