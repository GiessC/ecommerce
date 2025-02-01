package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.exceptions.FileDeleterException;

public interface IFileDeleter {
    public void delete(FileRequest request) throws FileDeleterException;
}
