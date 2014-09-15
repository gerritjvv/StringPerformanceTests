package util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

@SuppressWarnings("restriction")
public class StringUtils {

    public static final Unsafe UNSAFE = loadUnsafe();
    public static final long STRING_VALUE_FIELD_OFFSET;
    public static final long STRING_OFFSET_FIELD_OFFSET;
    public static final long STRING_COUNT_FIELD_OFFSET;

    private static Unsafe loadUnsafe() {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            return (Unsafe) unsafeField.get(null);

        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    private static long getFieldOffset(String fieldName) {
        try {
            return UNSAFE.objectFieldOffset(String.class
                    .getDeclaredField(fieldName));
        } catch (NoSuchFieldException e) {
            return -1;
        } catch (SecurityException e) {
            return -1;
        }
    }

    static {
        STRING_VALUE_FIELD_OFFSET = getFieldOffset("value");
        STRING_OFFSET_FIELD_OFFSET = getFieldOffset("offset");
        STRING_COUNT_FIELD_OFFSET = getFieldOffset("count");
    }

    public static final String noCopyStringFromChars(char[] chars) {
        String string = new String();
        UNSAFE.putObject(string, STRING_VALUE_FIELD_OFFSET, chars);
        return string;
    }

    public static final char[] toCharArray(String string) {
        return (char[]) UNSAFE.getObject(string, STRING_VALUE_FIELD_OFFSET);
    }

}