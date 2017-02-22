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
                case 15000:
                    return "Li";
                case 16000:
                    return "Be";
                case 17000:
                    return "B";
                case 18000:
                    return "F";
                case 19000:
                    return "Mg";
                case 20000:
                    return "Al";
                case 21000:
                    return "Si";
                case 22000:
                    return "P";
                case 23000:
                    return "S";
                case 24000:
                    return "Li";
                case 25000:
                    return "Ne";
                case 26000:
                    return "Ar";
                case 27000:
                    return "[";
                case 28000:
                    return "]";
                default:
                    break;
            }
        }
        return "";
    }
}