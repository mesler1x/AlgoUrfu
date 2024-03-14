package firstLR.three;

public class MyBigInteger {
    private static final int SIZE = 80000;

    private static final int MIN_LENGTH_FOR_KARATSUBA = 4;

    private final int numbersSize;

    private boolean isNegative;

    private int[] array = new int[SIZE];

    public MyBigInteger(String string) {
        int counter = 1;
        if (string.charAt(0) == '-')
            isNegative = true;
        else{
            array[string.length() - 1] = string.charAt(0) - '0';
        }

        for (int i = 1; i < string.length(); i++){
            counter++;
            if ((string.charAt(i) < '0' || '9' < string.charAt(i)))
                throw new Error();
            array[string.length() - 1 - i] = string.charAt(i) - '0';
        }
        this.numbersSize = counter;
    }

    private MyBigInteger(int[] array, int size, boolean isNegative) {
        this.array = array;
        this.numbersSize = size;
        this.isNegative = isNegative;
    }

    public String toString(){
        int len = 0;
        StringBuilder sb = new StringBuilder(len);
        len = SIZE;
        if (isNegative)
            sb.append('-');

        while (len > 1 && (array[len - 2] == 0)){
            len--;
        }
        for (int i = len - 2; i >= 0; i--)
            sb.append((char) (array[i] + '0'));

        if (len == 1){
            sb = new StringBuilder();
            sb.append("0");
            return sb.toString();
        }
        return sb.toString();
    }

    public static MyBigInteger add(MyBigInteger a, MyBigInteger b){
        if (a.isNegative == b.isNegative)
            return MyBigInteger.addWithoutDifferentSigns(a,b);
        else
            return MyBigInteger.subtractWithoutIdenticalSigns(a,b);
    }

    public static MyBigInteger subtract(MyBigInteger a, MyBigInteger b){
        b.isNegative = !b.isNegative;
        if (a.isNegative == b.isNegative)
            return MyBigInteger.addWithoutDifferentSigns(a,b);
        else
            return MyBigInteger.subtractWithoutIdenticalSigns(a,b);
    }



    private static MyBigInteger addWithoutDifferentSigns(MyBigInteger a, MyBigInteger b){
        boolean isNegativ = false;
        if (!(a.array.length == SIZE && b.array.length == SIZE))
            throw new Error();
        int[] res = new int[SIZE];
        int carry = 0;
        for (int i = 0; i < SIZE - 1; i++){
            carry+= a.array[i] + b.array[i];
            res[i] = carry % 10;
            carry/= 10;
        }
        if (a.isNegative)
            isNegativ = true;
        if (carry != 0)
            throw new Error();
        int d = getLen(res);
        return new MyBigInteger(res,d, isNegativ);
    }

    private static MyBigInteger subtractWithoutIdenticalSigns(MyBigInteger a, MyBigInteger b) {
        int cmp = compare(a.array, b.array);
        if (cmp < 0)
            return subtractWithoutSign(b, a);
        else if (cmp > 0)
            return subtractWithoutSign(a, b);
        else
            return new MyBigInteger("0");
    }

    private static MyBigInteger subtractWithoutSign(MyBigInteger a , MyBigInteger b){
        if (!(a.array.length == SIZE && b.array.length == SIZE))
            throw new Error();
        int[] res = new int[SIZE];
        int carry = 0;
        for (int i = 0; i < SIZE - 1; i++){
            carry+= a.array[i] - b.array[i] + 10;
            res[i] = carry % 10;
            carry/= 10;
            carry--;
        }
        if (carry != 0)
            throw new Error();
        int d = getLen(res);
        return new MyBigInteger(res,d, a.isNegative);
    }

    private static int getLen(int[] a){
        int len = SIZE;
        while (len > 1 && a[len - 1] == 0)
            len--;
        return len;
    }

    private static int compare(int[] a, int[] b){
        if (!(a.length == SIZE && b.length == SIZE))
            throw new Error();
        for (int i = SIZE - 2; i>=0; i--){
            if (a[i] != b[i])
                return a[i] - b[i];
        }
        return 0;
    }
}
