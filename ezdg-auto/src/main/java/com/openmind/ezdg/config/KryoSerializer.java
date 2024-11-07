package com.openmind.ezdg.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class KryoSerializer<T> implements RedisSerializer<T> {
    private final Kryo kryo;
    private final Class<T> type;

    public KryoSerializer(Class<T> type) {
        this.kryo = new Kryo();
        this.kryo.register(type); // 필요한 타입을 등록
        this.type = type; // 제네릭 타입 저장
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeObject(output, t);
            output.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new SerializationException("Kryo serialization failed", e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             Input input = new Input(bais)) {
            return kryo.readObject(input, type);  // 타입 명확히 지정
        } catch (Exception e) {
            throw new SerializationException("Kryo deserialization failed", e);
        }
    }
}
