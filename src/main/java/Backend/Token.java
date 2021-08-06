package Backend;

public class Token {
    TokenType type;
    String text;

    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return type.getType() + " : '" + text + '\'';
    }
}
