package com.jep.shop.user.service.impl;

import com.jep.shop.user.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author enping.jep
 * @date 2025/1/1 23:10
 **/
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Override
    public String uploadUserImg(MultipartFile file) {
        return "";
    }
}
