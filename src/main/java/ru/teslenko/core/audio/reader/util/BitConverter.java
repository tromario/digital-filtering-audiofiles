package ru.teslenko.core.audio.reader.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BitConverter {

    public static int toInt8(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        return buffer.get();
    }

    public static int toInt16(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        return buffer.getShort();
    }

    public static int toInt32(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        return buffer.getInt();
    }

}
