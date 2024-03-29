package org.lsh.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author lsh
 * @description:
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        // 创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('9');
        buffer.putShort((short) 4);

        // 取出
        buffer.flip();

        System.out.println();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());

    }
}
