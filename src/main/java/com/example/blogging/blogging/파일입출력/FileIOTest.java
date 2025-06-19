package com.example.blogging.blogging.파일입출력;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOTest {

    private static final String DIR = "/Users/eomjongheon/Desktop/iotest/";
    private static final String ORIGINAL_DIR = "original/";
    private static final String COPY_DIR = "copy/";
    private static final String FILE_NAME = "io_test_file.txt";

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        // 테스트 파일 생성
        createTestFile();

//        readAndWriteBytes();

        // 메모리 사용량 출력
        printHeapStatus();

        // 파일 복사 후 소요 시간 출력
        long endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + " ms");
    }

    // 1byte씩 읽고 쓰기
    // 1byte씩 읽고 쓸 때마다 시스템 콜이 발생하여 성능이 매우 저하됨
    private static void readAndWriteBytes() throws IOException {
        File file = new File(DIR + ORIGINAL_DIR + FILE_NAME);

        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(DIR + COPY_DIR + FILE_NAME)
        ) {
            byte[] bytes = new byte[1024 * 1024 * 100]; // 100MB
            while (fis.read(bytes) != -1) {
                fos.write(bytes);
            }
        }
    }

    private static void printHeapStatus() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();

        long used = heapUsage.getUsed();
        long committed = heapUsage.getCommitted();
        long max = heapUsage.getMax();

        System.out.println("Heap Memory Usage:");
        System.out.printf("  Used: %d bytes (%.2f MB)%n", used, used / (1024.0 * 1024));
        System.out.printf("  Committed: %d bytes (%.2f MB)%n", committed, committed / (1024.0 * 1024));
        System.out.printf("  Max: %d bytes (%.2f MB)%n", max, max / (1024.0 * 1024));
    }

    private static void createTestFile() {
        File testFile = new File(DIR + ORIGINAL_DIR + FILE_NAME);

        if (!Files.exists(testFile.toPath())) {
            System.out.println("테스트 파일 생성 중...");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
                char[] buffer = new char[BUFFER_SIZE * 8]; // 8KB 버퍼 (BUFFER_SIZE=1024)

                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = 'A';
                }

                long totalChars = (long) 1024 * 1024 * 1024; // 1GB = 1,073,741,824 bytes
                long written = 0;
                while (written < totalChars) {
                    long toWrite = Math.min(buffer.length, totalChars - written);
                    writer.write(buffer, 0, (int) toWrite);
                    written += toWrite;
                }
            } catch (IOException e) {
                System.err.println("파일 생성 중 오류 발생: " + e.getMessage());
            }

            System.out.println("테스트 파일 생성 완료");
        }
    }
}
