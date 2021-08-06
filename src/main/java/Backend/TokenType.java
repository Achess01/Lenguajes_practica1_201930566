package Backend;

public enum TokenType {
    ID("Id"), ENTERO("Número entero"), DECIMAL("Número decimal"), SIMBOLO("Símbolo"),
    ERROR("Error");
    private String type;

    private TokenType(String type){
        this.type = type;
    }

    public String getType(){
        return  this.type;
    }
}
