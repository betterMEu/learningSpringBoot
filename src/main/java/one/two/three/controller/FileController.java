package one.two.three.controller;

import jakarta.annotation.Resource;
import one.two.three.exp.ext.StorageFileNotFoundException;
import one.two.three.service.StorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.stream.Collectors;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/25 11:03
 * @Version: 1.0
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Resource
    private StorageService storageService;


    //从StorageService中查找上传文件的当前列表，并将其加载到Thymeleaf模板中。它通过使用MvcUriComponentsBuilder计算到实际资源的链接。
    @GetMapping("/test")
    public String listUploadedFiles(Model model) {

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(
                                FileController.class,
                                "serveFile",
                                path.getFileName().toString()
                                ).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<org.springframework.core.io.Resource> serveFile(@PathVariable String filename) {

        org.springframework.core.io.Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }ok

    @PostMapping("/test")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "成功上传" + file.getOriginalFilename() + "!");

        return "redirect:/file/test";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }



    @GetMapping("/upload")
    public String getFileUpload() {
        return "file-upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file1") MultipartFile file1,
                                   @RequestParam("file2") MultipartFile file2,
                                   Model model) {
        // 使用 MultipartHttpServletRequest 对象访问解析后的文件和请求参数
        if (!file1.isEmpty()) {
            String f1 = "E:/" + file1.getOriginalFilename();

            try (InputStream inputStream = file1.getInputStream();
                 OutputStream outputStream = new FileOutputStream(f1)) {

                byte[] buffer = new byte[1024 * 10];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("文件保存成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // 处理其他请求参数
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");

        // 处理业务逻辑
        model.addAttribute("successText", "上传成功！");
        return "redirect:/success";
    }
}
