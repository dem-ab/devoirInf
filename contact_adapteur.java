public  class MyItemAdapter extends RecyclerView.Adapter<MyViewHolder> {
   List<contacts> mescontacts;

    public MyItemAdapter(List<contacts> contacts) {
        this.mescontacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_main,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.display(mescontacts.get(position));
    }

    @Override
    public int getcontactsCount() {
        return mescontacts.size();
    }
}

