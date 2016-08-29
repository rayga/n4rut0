package com.google.android.gms.wallet;

import java.util.ArrayList;
import java.util.Arrays;

public final class PaymentInstrumentType {
    public static final int AMEX = 3;
    public static final int CHROME_PROXY_CARD_TYPE = 2;
    public static final int DISCOVER = 4;
    public static final int JCB = 5;
    public static final int MASTER_CARD = 2;
    public static final int VISA = 1;

    public static ArrayList<Integer> getAll() {
        Integer[] numArr = new Integer[JCB];
        numArr[0] = Integer.valueOf(VISA);
        numArr[VISA] = Integer.valueOf(MASTER_CARD);
        numArr[MASTER_CARD] = Integer.valueOf(AMEX);
        numArr[AMEX] = Integer.valueOf(DISCOVER);
        numArr[DISCOVER] = Integer.valueOf(JCB);
        return new ArrayList(Arrays.asList(numArr));
    }
}
