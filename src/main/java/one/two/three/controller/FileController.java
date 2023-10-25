package one.two.three.controller;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/25 11:03
 * @Version: 1.0
 */
@Controller
@RequestMapping("/file")
//@MultipartConfig(location = "C:\\Users\\admin\\Desktop\\file", maxFileSize = 1024 * 1024L, maxRequestSize = 1024L, fileSizeThreshold = 1024)
public class FileController {

    @GetMapping("/upload")
    public String getFileUpload() {
        return "file-upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(MultipartHttpServletRequest request,
                                   @RequestParam("file") MultipartFile file,
                                   Model model) {
        // 使用 MultipartHttpServletRequest 对象访问解析后的文件和请求参数
        if (!file.isEmpty()) {
            // 处理上传的文件
            // file.getInputStream() 可以获取文件的输入流
            // file.getOriginalFilename() 可以获取文件的原始文件名
        }

        // 处理其他请求参数
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");

        // 处理业务逻辑
        model.addAttribute("successText", "上传成功！");
        return "redirect:/success";
    }
}
