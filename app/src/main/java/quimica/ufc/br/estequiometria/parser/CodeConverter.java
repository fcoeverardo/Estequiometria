package quimica.ufc.br.estequiometria.parser;

import android.util.Log;

import java.util.HashMap;

/**
 * TODO: Add a class header comment!
 */
public class CodeConverter {

    public static String convert(int code) {
        if (code >= 0 && code <= 9) {
            return String.valueOf(code);
        } else {
            switch (code) {
                case 1001:
                    return "H";
                case 1002:
                    return "He";

                case 1003:
                    return "Li";
                case 1004:
                    return "Be";
                case 1005:
                    return "B";
                case 1006:
                    return "C";
                case 1007:
                    return "N";
                case 1008:
                    return "O";
                case 1009:
                    return "F";
                case 1010:
                    return "Ne";

                case 1011:
                    return "Na";
                case 1012:
                    return "Mg";
                case 1013:
                    return "Al";
                case 1014:
                    return "Si";
                case 1015:
                    return "P";
                case 1016:
                    return "S";
                case 1017:
                    return "Cl";
                case 1018:
                    return "Ar";

                case 1019:
                    return "K";
                case 1020:
                    return "Ca";
                case 1021:
                    return "Sc";
                case 1022:
                    return "Ti";
                case 1023:
                    return "V";
                case 1024:
                    return "Cr";
                case 1025:
                    return "Mn";
                case 1026:
                    return "Fe";
                case 1027:
                    return "Co";
                case 1028:
                    return "Ni";
                case 1029:
                    return "Cu";
                case 1030:
                    return "Zn";
                case 1031:
                    return "Ga";
                case 1032:
                    return "Ge";
                case 1033:
                    return "As";
                case 1034:
                    return "Se";
                case 1035:
                    return "Br";
                case 1036:
                    return "Kr";

                case 1037:
                    return "Rb";
                case 1038:
                    return "Sr";
                case 1039:
                    return "Y";
                case 1040:
                    return "Zr";
                case 1041:
                    return "Nb";
                case 1042:
                    return "Mo";
                case 1043:
                    return "Tc";
                case 1044:
                    return "Ru";
                case 1045:
                    return "Rh";
                case 1046:
                    return "Pd";
                case 1047:
                    return "Ag";
                case 1048:
                    return "Cd";
                case 1049:
                    return "In";
                case 1050:
                    return "Sn";
                case 1051:
                    return "Sb";
                case 1052:
                    return "Te";
                case 1053:
                    return "I";
                case 1054:
                    return "Xe";

                case 1055:
                    return "Cs";
                case 1056:
                    return "Ba";
                case 1057:
                    return "La";
                case 1058:
                    return "Ce";
                case 1059:
                    return "Pr";
                case 1060:
                    return "Nd";
                case 1061:
                    return "Pm";
                case 1062:
                    return "Sm";
                case 1063:
                    return "Eu";
                case 1064:
                    return "Gd";
                case 1065:
                    return "Tb";
                case 1066:
                    return "Dy";
                case 1067:
                    return "Ho";
                case 1068:
                    return "Er";
                case 1069:
                    return "Tm";
                case 1070:
                    return "Yb";
                case 1071:
                    return "Lu";
                case 1072:
                    return "Hf";
                case 1073:
                    return "Ta";
                case 1074:
                    return "W";
                case 1075:
                    return "Re";
                case 1076:
                    return "Os";
                case 1077:
                    return "Ir";
                case 1078:
                    return "Pt";
                case 1079:
                    return "Au";
                case 1080:
                    return "Hg";
                case 1081:
                    return "Tl";
                case 1082:
                    return "Pb";
                case 1083:
                    return "Bi";
                case 1084:
                    return "Po";
                case 1085:
                    return "At";
                case 1086:
                    return "Rn";

                case 1087:
                    return "Fr";
                case 1088:
                    return "Ra";
                case 1089:
                    return "Ac";
                case 1090:
                    return "Th";
                case 1091:
                    return "Pa";
                case 1092:
                    return "U";
                case 1093:
                    return "Np";
                case 1094:
                    return "Pu";
                case 1095:
                    return "Am";
                case 1096:
                    return "Cm";
                case 1097:
                    return "Bk";
                case 1098:
                    return "Cf";
                case 1099:
                    return "Es";
                case 1100:
                    return "Fm";
                case 1101:
                    return "Md";
                case 1102:
                    return "No";
                case 1103:
                    return "Lr";
                case 1104:
                    return "Rf";
                case 1105:
                    return "Db";
                case 1106:
                    return "Sg";
                case 1107:
                    return "Bh";
                case 1108:
                    return "Hs";
                case 1109:
                    return "Mt";
                case 1110:
                    return "Ds";
                case 1111:
                    return "Rg";
                case 1112:
                    return "Cn";
                case 1113:
                    return "Uut";
                case 1114:
                    return "Fl";
                case 1115:
                    return "Uup";
                case 1116:
                    return "Lv";
                case 1117:
                    return "Uus";
                case 1118:
                    return "Uuo";

                case 6000:
                    return "(";
                case 7000:
                    return ")";
                case 8000:
                    return ".";
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


/*
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
                case 29000:
                    return "Sc";
                case 30000:
                    return "Ti";
                case 31000:
                    return "Ti";
                case 32000:
                    return "Ti";
                default:
                    break;
            }
        }
        return "";
    }
}*/