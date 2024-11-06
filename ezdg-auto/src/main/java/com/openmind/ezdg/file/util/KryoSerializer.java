package com.openmind.ezdg.file.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import org.springframework.data.redis.core.RedisTemplate;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class KryoSerializer {
    private static final Kryo kryo = new Kryo();

    static {
        kryo.register(List.class); // 리스트 타입 등록
        kryo.register(ArrayList.class);
        kryo.register(MongoBsonValueDto.class); // MongoBsonValueDto 클래스 등록
    }

//    // 직렬화 메서드
//    public static byte[] serialize(List<List<MongoBsonValueDto>> data) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Output output = new Output(byteArrayOutputStream);
//        kryo.writeObject(output, data); // 중첩된 리스트 구조를 직렬화
//        output.close();
//        return byteArrayOutputStream.toByteArray();
//    }
//
//    // 역직렬화 메서드
//    public static List<List<MongoBsonValueDto>> deserialize(byte[] data) {
//        Input input = new Input(new ByteArrayInputStream(data));
//        return kryo.readObject(input, List.class); // 중첩된 리스트 구조로 역직렬화
//    }
// 단일 List<MongoBsonValueDto> 직렬화 메서드
public static byte[] serialize(List<MongoBsonValueDto> data) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Output output = new Output(byteArrayOutputStream);
    kryo.writeObject(output, data);  // 단일 리스트 구조를 직렬화
    output.close();
    return byteArrayOutputStream.toByteArray();
}

    // 단일 List<MongoBsonValueDto> 역직렬화 메서드
    public static List<MongoBsonValueDto> deserialize(byte[] data) {
        Input input = new Input(new ByteArrayInputStream(data));
        return kryo.readObject(input, ArrayList.class);  // 단일 리스트 구조로 역직렬화
    }
}
