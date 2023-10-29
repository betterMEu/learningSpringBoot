package one.two.three.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/25 11:03
 * @Version: 1.0
 */
@Controller
@RequestMapping("/file")
public class FileController {

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
