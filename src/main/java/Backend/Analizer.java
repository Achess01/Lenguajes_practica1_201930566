package Backend;

import java.util.ArrayList;

public class Analizer {
        private ArrayList<Token> tokens = new ArrayList<>();
        public String analize(String data){
                data = data.trim();
                data = data + " ";
                String text = "";
                Boolean id = false, number = false, symbol = false, decimal = false;
                for (int i = 0; i < data.length(); i++) {
                        char chr = data.charAt(i);
                        if(chr == (char)32 || chr == (char)10){
                                TokenType tkType;
                                if(id){
                                        tkType = TokenType.ID;
                                }
                                else if(decimal && number){
                                        tkType = TokenType.DECIMAL;
                                }
                                else if(number){
                                        tkType = TokenType.ENTERO;
                                }
                                else if(symbol){
                                        tkType = TokenType.SIMBOLO;
                                }
                                else{
                                        text = "";
                                        continue;
                                }
                                number = false;
                                decimal = false;
                                symbol = false;
                                id = false;
                                tokens.add(new Token(tkType, text));
                                text = "";
                        }
                        else{
                                text += chr;
                                int value = (int)chr;
                                if(value >= 65 && value <= 90 || value >= 97 && value <= 122){
                                        if(!id && !number && !symbol && !decimal){
                                                id = true;
                                        }
                                        else if(!id){
                                                tokens.add(new Token(TokenType.ERROR, text));
                                                text = "";
                                                number = false;
                                                decimal = false;
                                                symbol = false;
                                                id = false;
                                        }
                                }
                                else if (value >= 48 && value <= 57){
                                        if(!id && !symbol){
                                                number = true;
                                        }
                                        else if(!id && !number){
                                                tokens.add(new Token(TokenType.ERROR, text));
                                                text = "";
                                                number = false;
                                                decimal = false;
                                                symbol = false;
                                                id = false;
                                        }
                                }
                                else if (value == 46){
                                        if(!decimal && number){
                                                decimal = true;
                                                number = false;
                                        }
                                        else {
                                                tokens.add(new Token(TokenType.ERROR, text));
                                                text = "";
                                                number = false;
                                                decimal = false;
                                                symbol = false;
                                                id = false;
                                        }
                                }
                                else if(value == 91 || value == 93 ||
                                value == 123 || value == 125 || value == 44 || value == 59){
                                        if(!id && !number && !decimal || !symbol){
                                                symbol = true;
                                        }
                                        else if(!symbol){
                                                tokens.add(new Token(TokenType.ERROR, text));
                                                text = "";
                                                number = false;
                                                decimal = false;
                                                symbol = false;
                                                id = false;
                                        }
                                }
                                else{
                                        tokens.add(new Token(TokenType.ERROR, text));
                                        text = "";
                                        number = false;
                                        decimal = false;
                                        symbol = false;
                                        id = false;
                                }
                        }
                }
                return show();
        }

        private String show(){
                String textResponse = "";
                for (int i = 0; i < tokens.size(); i++) {
                        textResponse += tokens.get(i).toString() + "\n";
                }
                return textResponse;
        }
}
