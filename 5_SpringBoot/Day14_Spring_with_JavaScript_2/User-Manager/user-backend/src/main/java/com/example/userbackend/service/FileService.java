package com.example.userbackend.service;

import com.example.userbackend.exception.BadRequestException;
import com.example.userbackend.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    // Định nghĩa root path cho folder chứa ảnh (có tên là "uploads")
    private Path rootPath = Paths.get("uploads");

    // Gọi phương thức createFolder (để tạo folder "uploads") ngay khi khởi tạo đối tượng FileService
    public FileService() {
        createFolder(rootPath.toString());
    }

    // Tạo folder theo đường dẫn
    private void createFolder(String path) {
        File file = new File(path); // tạo đối tượng File từ đường dẫn
        if (!file.exists()) { // nếu file chưa tồn tại thì tạo mới
            file.mkdirs(); // "mkdirs" = "make directories"
        }
    }


    // Kiểm tra thông tin file gửi lên (tên file, định dạng file, dung lượng tối đa)
    private void validateFile(MultipartFile file) {
        // Kiểm tra tên file
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isEmpty()) {
            throw new BadRequestException("file name không được để trống");
        }

        // Kiểm tra định dạng file (jpg, png, jpeg)
        String fileExtension = getFileExtensiton(fileName);
        if (!checkFileExtension(fileExtension)) {
            throw new BadRequestException("file không đúng định dạng");
        }

        // Kiểm tra dung lượng file (<= 2MB)
        double fileSize = (double) (file.getSize() / 1_048_576); // phương thức getSize() lấy ra số bytes
        if (fileSize > 2) {
            throw new BadRequestException("file không được vượt quá 2MB");
        }
    }

    // Trích xuất file extension từ tên file
    private String getFileExtensiton(String fileName) {
        int lastIndexOfStop = fileName.lastIndexOf("."); // tìm index của ký tự '.' cuối cùng
        return fileName.substring(lastIndexOfStop + 1); // trả về substring tính từ sau ký tự '.' đến hết chuỗi
    }

    // Kiểm tra xem file extension có hợp lệ không (thuộc một trong 3 định dạng "png", "jpg", "jpeg")
    private boolean checkFileExtension(String fileExtension) {
        List<String> extensions = new ArrayList<>(List.of("png", "jpg", "jpeg"));
        return extensions.contains(fileExtension.toLowerCase());
    }


    // Upload file vào folder ở server, upload xong thì trả về đường dẫn api để xem file
    public String uploadFile(int id, MultipartFile file) {
        // Kiểm tra file cần upload
        validateFile(file);

        // Tạo folder có tên là userId, nằm bên trong folder "uploads"
        Path userPath = rootPath.resolve(String.valueOf(id)); // phương thức "resolve" dùng để nối path
        createFolder(userPath.toString());

        // Tạo target file
        String fileId = String.valueOf(Instant.now().getEpochSecond()); // phương thức getEpochSecond() của đối tượng Instant trả về số giây tính từ ngày 01.01.1970 đến thời điểm hiện tại, dùng chính thông tin này gán cho fileId để có biết file được upload vào thời điểm nào
        Path filePath = userPath.resolve(fileId);
        File targetFile = filePath.toFile(); // hoặc: File targetFile = new File(filePath);

        // Đưa dữ liệu của file cần upload vào target file
        try (OutputStream os = new FileOutputStream(targetFile)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload file");
        }

        // Trả về đường dẫn api để xem file
        return "/api/v1/users/" + id + "/files/" + fileId;
    }


    // Xem nội dung file
    public byte[] readFile(int id, String fileId) {
        Path userPath = rootPath.resolve(String.valueOf(id)); // đường dẫn đến sub-folder ứng với userId
        Path filePath = userPath.resolve(fileId); // đường dẫn đến file

        // Nếu folder hoặc file không tồn tại thì throw exception
        if (!userPath.toFile().exists() || !filePath.toFile().exists()) {
            throw new NotFoundException("File không tồn tại");
        }

        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi đọc file");
        }
    }


    // Lấy danh sách files của một user
    public List<String> getFiles(int id) {
        Path userPath = rootPath.resolve(String.valueOf(id)); // đường dẫn đến sub-folder ứng với userId

        // Nếu folder không tồn tại (user chưa upload ảnh nào) thì trả về list rỗng
        if (!userPath.toFile().exists()) {
            return new ArrayList<>();
        }

        File userDir = userPath.toFile();
        File[] files = userDir.listFiles(); // list ra các files nằm trong folder của user tương ứng (userDir) rồi đưa vào File array

        return Arrays.stream(files)
                .map(File::getName)// duyệt qua từng file trong mảng, lấy ra file name
                .sorted(Comparator.reverseOrder())// sắp xếp file name theo thứ tự giảm dần
                .map(fileName -> "/api/v1/users/" + id + "/files/" + fileName) // tạo đường dẫn api để xem file
                .collect(Collectors.toList()); // convert từ stream sang list
    }


    // Xóa file
    public void deleteFile(int id, String fileId) {
        Path userPath = rootPath.resolve(String.valueOf(id)); // đường dẫn đến sub-folder ứng với userId
        Path filePath = userPath.resolve(fileId); // đường dẫn đến file

        // Nếu folder hoặc file không tồn tại thì throw exception
        if (!userPath.toFile().exists() || !filePath.toFile().exists()) {
            throw new NotFoundException("File không tồn tại");
        }

        if (!filePath.toFile().delete()) { // Gọi phương thức delete() để xóa file, nếu xóa không thành công thì trả về false và throw exception
            throw new RuntimeException("Lỗi khi xóa file");
        }
    }
}