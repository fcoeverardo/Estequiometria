package quimica.ufc.br.estequiometria.parser;

/**
 * TODO: Add a class header comment!
 */
public class CodeConverter {

    public static String convert(int code) {
        if(code >=0 && code <= 9) {
            return String.valueOf(code);
        } else {
            switch(code){
                case 1000:
                    return "Na";
                case 2000:
                    return "Cl";
                case 3000:
                    return "H";
                case 4000:
                    return "N";
                case 5000:
                    return "O";
                case 6000:
                    return "(";
                case 7000:
                    return ")";
                case 8000:
                    return ".";
                case 9000:
                    return "C";
                case 10000:
                    return "Pb";
                case 11000:
                    return "Br";
                case 12000:
                    return "K";
                case 13000:
                    return "Ca";
                case 14000:
                    return "He";
                default:
                    break;
            }
        }
        return "";
    }
}