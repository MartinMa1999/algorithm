package bitOpeartion;

class GetHexadecimal {
    public static void main(String[] args) {
        System.out.println(GetHexadecimal.method2(15));
    }
    public static String getItMethod1(int x){
        if(x == 0){
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while(x / 16 != 0){
            int tmp = x % 16;
            if(tmp < 10){
                sb.append((char)(tmp + '0'));
            }
            else {
                sb.append((char)(tmp - 10 + 'a'));
            }
            x = x / 16;
        }
        if(x < 10){
            sb.append((char)(x + '0'));
        }
        else {
            sb.append((char)(x - 10 + 'a'));
        }
        char[] array = new char[sb.length()];
        for(int i = 0; i < array.length; i++){
            array[i] = sb.charAt(sb.length() - i - 1);
        }
        return String.valueOf(array);
    }

    public static String method2(int x){
        if(x == 0){
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 28; i >= 0; i -= 4){
            int tmp = (x >> i) & 0b1111;//因为算了8次，所以结果一定是个8位的东西
            if(tmp < 10){
                sb.append((char) (tmp + '0'));
            }
            else{
                sb.append((char) (tmp - 10 + 'a'));
            }
        }
        return sb.toString();
    }
}
