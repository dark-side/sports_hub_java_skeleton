package org.softserveinc.java_be_genai_plgrnd.controllers;

import java.util.Base64;
import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.services.ImageStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Image", description = "Images API")
@RestController
@RequestMapping(path = "/api/images")
@Validated
public class ImageController {

    private final ImageStorageService imageStorageService;

    public ImageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @Operation(summary = "Get image by ID")
    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable UUID imageId) {
        return imageStorageService.getBase64ImageById(imageId)
            .map(base64Image -> {
                var cleanBase64 = base64Image;
                if (base64Image.contains(",")) {
                    cleanBase64 = base64Image.split(",")[1];
                }

                return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(Base64.getDecoder().decode(cleanBase64));
            })
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
