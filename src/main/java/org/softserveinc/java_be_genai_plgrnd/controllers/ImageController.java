package org.softserveinc.java_be_genai_plgrnd.controllers;

import java.util.UUID;

import org.softserveinc.java_be_genai_plgrnd.services.ImageStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Tag(name = "Image", description = "Images API")
@RestController
@RequestMapping(path = "/api/images", produces = APPLICATION_JSON_VALUE)
@Validated
public class ImageController {

    private final ImageStorageService imageStorageService;

    public ImageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @Operation(summary = "Get image by ID")
    @GetMapping("/{imageId}")
    public ResponseEntity<String> getImage(@PathVariable UUID imageId) {
        return imageStorageService.getBase64ImageById(imageId)
            .map(image -> new ResponseEntity<>(image, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
