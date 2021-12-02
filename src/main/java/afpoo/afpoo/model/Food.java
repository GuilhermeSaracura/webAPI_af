package afpoo.afpoo.model;

public class Food {
    
    private int codigo;
    private String name;
    private String type;
    private String link;
    private String descrição;
    private String img;

    public Food() {
    }

    public Food(int codigo, String name, String type, String link, String descrição, String img) {
        this.codigo = codigo;
        this.name = name;
        this.type= type;
        this.link = link;
        this.descrição = descrição;
        this.img = img;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}