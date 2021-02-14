/*
Je n'ai pas eu assez de temps pour créer le dao et sauvegarder dans la base de données
jai donc recupérer les données du serveur puis afficher
il manque la partie sauvegarde
*/

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
private List<Contacts> mesContacts;
private MyAdapter monAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_item);

        recyclerView=(RecyclerView)findViewById(R.id.myRecyclerView);
//appel des contacts pour affichage
        getContacts();
    }

    private void getContacts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) 
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Contacts>> call = api.getContacts();

        call.enqueue(new Callback<List<Contacts>>() {
            @Override
            public void onResponse(Call<List<Contacts>> call, Response<List<Contacts>> response) {
                mesContacts = response.body();

              
                monAdapter=new MyAdapter(mesContacts);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(monAdapter);
            }

            @Override
            public void onFailure(Call<List<Contacts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
