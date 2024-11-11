package com.openmind.ezdg.file.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileUtil {

    @Value("${path.temp-file-path}")
    private String filePath;

    public boolean saveFileToTempPath(MultipartFile file) {
        if(file.isEmpty()) return false;

        String originFileName = file.getOriginalFilename();

        //File saveFile = new File(getFullPath(originFileName));
        // 중복 경로 문제 해결
        File saveFile = new File(filePath, originFileName);

        log.info("saving file full path = {}", saveFile.getAbsolutePath());

        try {
            file.transferTo(saveFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("파일 저장에 실패하였습니다.");
        }
    }

    public String getFullPath(String fileName) {
        return filePath + fileName;
    }

    public MultipartFile readFileFromTempPath(String fileName) {
        File file = new File(getFullPath(fileName));
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            return new CustomMultipartFile(file.getName(), file.getName(), content);
        } catch (IOException e) {
            throw new RuntimeException("파일을 찾거나 읽는 데 실패했습니다: " + fileName, e);
        }
    }

    public boolean deleteFileFromTempPath(String fileName) {
        File file = new File(getFullPath(fileName));
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                log.info("파일이 성공적으로 삭제되었습니다: {}", fileName);
            } else {
                log.warn("파일 삭제에 실패했습니다: {}", fileName);
            }
            return deleted;
        } else {
            log.warn("파일이 존재하지 않습니다: {}", fileName);
            return false;
        }
    }

    private static class CustomMultipartFile implements MultipartFile {
        private final String name;
        private final String originFilename;
        private final byte[] content;

        public CustomMultipartFile(String name, String originFilename, byte[] content) {
            this.name = name;
            this.originFilename = originFilename;
            this.content = content;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getOriginalFilename() {
            return originFilename;
        }

        @Override
        public String getContentType() {
            return "application/octet-stream"; // MIME 타입 설정
        }

        @Override
        public boolean isEmpty() {
            return content.length == 0;
        }

        @Override
        public long getSize() {
            return content.length;
        }

        @Override
        public byte[] getBytes() {
            return content;
        }

        @Override
        public InputStream getInputStream() {
            return new ByteArrayInputStream(content);
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException {
            try (InputStream in = getInputStream()) {
                Files.copy(in, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
