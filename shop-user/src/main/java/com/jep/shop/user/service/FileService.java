package com.jep.shop.user.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author enping.jep
 * @date 2025/1/1 22:46
 **/
public interface FileService {

    String uploadUserImg(MultipartFile file);
}
