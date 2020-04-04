/**
 * @author Cay Horstmann
 * @version 1.10 1997-07-01
 */

class HelloNative {
    public static native void greeting();

    static {
        System.loadLibrary("HelloNative");
    }
}


