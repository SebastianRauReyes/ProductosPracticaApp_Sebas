package com.rau.sebastian.productospracticaapp_sebas.adapters;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rau.sebastian.productospracticaapp_sebas.R;
import com.rau.sebastian.productospracticaapp_sebas.activities.DashboardActivity;
import com.rau.sebastian.productospracticaapp_sebas.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private static final String TAG = DashboardActivity.class.getSimpleName();

    private List<Product> products;

    public ProductAdapter(List<Product> products){

        this.products = products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productname;
        public TextView productprice;
        public TextView productdesc;
        public Button favoriteButton;
        public Button trashButton;


        public ViewHolder(View itemView) {
            super(itemView);
            productname = itemView.findViewById(R.id.product_name_text);
            productprice = itemView.findViewById(R.id.product_price_text);
            productdesc = itemView.findViewById(R.id.product_description_text);
            favoriteButton = itemView.findViewById(R.id.add_favorite);
            trashButton = itemView.findViewById(R.id.add_trash);

        }
    }


    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder holder, final int position) {
        final Product product = this.products.get(position);
        holder.productname.setText(product.getProductname());
        String price = "$ "+product.getProductprice();
        holder.productprice.setText(price);
        holder.productdesc.setText(product.getProductdesc());


        holder.favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.favoriteButton.getContext(), product.getProductname() +" Added to Favorites", Toast.LENGTH_SHORT).show();
            }
        });

        holder.trashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.trashButton.getContext(), product.getProductname() +" Archived", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }


}
