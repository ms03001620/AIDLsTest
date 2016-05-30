// PersonAIDL.aidl
package baba88.com.aidlstest;

// Declare any non-default types here with import statements

interface PersonAIDL {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    int query(int no);
}
