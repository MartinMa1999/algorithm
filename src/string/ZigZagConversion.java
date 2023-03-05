package string;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        test.convert(new String("laiofferzhenniub"), 5);
    }

    public String convert(String input, int nRows) {
        if (input == null || input.length() == 0 || nRows == 1) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        int num = 2 + (nRows - 2) * 2;
        for(int i = 0; i < nRows; i++){
            int k = 0;
            while(k * num + i < input.length()){
                sb.append(input.charAt(k * num + i));
                if(i > 0 && i < nRows - 1 && (k + 1) * num - i < input.length()){
                    sb.append(input.charAt((k + 1) * num - i));
                }
                k++;
            }
        }
        return sb.toString();
    }
}
