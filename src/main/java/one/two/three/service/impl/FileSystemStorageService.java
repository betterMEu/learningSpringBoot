package one.two.three.service.impl;


import one.two.three.exp.StorageException;
import one.two.three.exp.ext.StorageFileNotFoundException;
import one.two.three.properties.StorageProperties;
import one.two.three.service.StorageService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/30 9:10
 * @Version: 1.0
 */
@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    public FileSystemStorageService(StorageProperties storageProperties) {
        if (storageProperties.getLocation().trim().isEmpty()) {
            throw new StorageException("请设置文件上传位置！");
        }

        this.rootLocation = Paths.get(storageProperties.getLocation());
    }

    @Override
    public void init() {
        try {
            Files.createFile(this.rootLocation);
        } catch (IOException e) {
            throw new StorageException("初始化" + this.rootLocation.getFileName() + "目录失败", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                throw new StorageException("上传文件不能为空");
            }
            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(Objects.requireNonNull(file.getOriginalFilename())))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation)) {
                throw new StorageException("不可将文件存储在设置的目录外！");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (IOException io) {
            throw new StorageException("保存文件失败：", io);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException io) {
            throw new StorageException("读取存储文件失败：", io);
        }
    }

    @Override
    public Path load(String filename) {
        return this.rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("读取文件失败: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("读取文件失败: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
