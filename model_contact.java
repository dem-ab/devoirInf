@Entity(tableName = "contacts")
public class contacts extends Base {
	private String fnom;
    private String lnom;
    private String tel;
    private String email;

    public Item(String fnom, String lnom, String tel, String email, String adress) {
        this.fnom = fnom;
        this.lnom = lnom;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
    }

    public String getFnom() {
        return fnom;
    }

    public String getLnom() {
        return lnom;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    private String adress;



}
