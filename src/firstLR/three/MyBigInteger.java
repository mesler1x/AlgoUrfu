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

    public static MyBigInteger multiplyKaratsuba(MyBigInteger a, MyBigInteger b) {
        if (a.numbersSize <= MIN_LENGTH_FOR_KARATSUBA && b.numbersSize <= MIN_LENGTH_FOR_KARATSUBA){
            return multiplySimple(a,b);
        }
        else {
            var m = Math.max(a.numbersSize, b.numbersSize);
            int m2 = (m / 2) + (m % 2);

            SplitBigNumber aParts = MyBigInteger.splitBigNumber(a,m2);
            SplitBigNumber bParts = MyBigInteger.splitBigNumber(b,m2);

            MyBigInteger sumOfAParts = MyBigInteger.add(aParts.part1, aParts.part2);
            MyBigInteger sumOfBParts = MyBigInteger.add(bParts.part1, bParts.part2);
            MyBigInteger abComacd = multiplyKaratsuba(sumOfAParts,sumOfBParts);


            MyBigInteger ac = multiplyKaratsuba(aParts.part1, bParts.part1);
            MyBigInteger bd = multiplyKaratsuba(aParts.part2, bParts.part2);
            MyBigInteger sumOfMiddleTerms = subtract(subtract(abComacd, bd), ac);

            MyBigInteger z1 = MyBigInteger.normalize(ac, m2 * 2);
            MyBigInteger z2 = MyBigInteger.normalize(sumOfMiddleTerms, m2);

            var d = MyBigInteger.add(z1, z2);
            return MyBigInteger.add(d, bd);
        }
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

    private static MyBigInteger multiplySimple(MyBigInteger a, MyBigInteger b){
        if (!(a.array.length == SIZE && b.array.length == SIZE))
            throw new Error();
        int[] res = new int[SIZE];
        if (a.numbersSize == 0 || b.numbersSize == 0)
            return new MyBigInteger(res,0,false);
        for (int ia = 0; ia < a.numbersSize; ia++){
            int carry = 0;
            for (int ib = 0; ib < b.numbersSize; ib++){
                carry += res[ia + ib] + a.array[ia] * b.array[ib];
                res[ia + ib] = carry % 10;
                carry /= 10;
            }
            if (carry > 0){
                if (!(carry <= 10))
                    throw new Error();
                if (!(res[ia + b.numbersSize] == 0))
                    throw new Error();
                res[ia + b.numbersSize] = carry;
            }
        }
        int d = getLen(res);
        return new MyBigInteger(res, d, false);
    }

    private static MyBigInteger normalize(MyBigInteger a, int zeroCount){
        for (int i = 0; a.numbersSize > i; i++){
            a.array[a.numbersSize - 1 - i + zeroCount] = a.array[a.numbersSize - 1 - i];
            a.array[a.numbersSize - 1 - i] = 0;
        }
        return a;
    }

    private static SplitBigNumber splitBigNumber(MyBigInteger a, int middle){
        int[] res1 = new int[SIZE];
        int[] res2 = new int[SIZE];
        var i = a.numbersSize - 1;
        while (i >= middle){
            res1[i - middle] = a.array[i];
            i--;
        }
        while (i >= 0){
            res2[i] = a.array[i];
            i--;
        }
        var len = getLen(res1);
        var len2 = getLen(res2);
        var d = new MyBigInteger(res1, len, false);
        var c = new MyBigInteger(res2, len2, false);
        return new SplitBigNumber(d,c);
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
