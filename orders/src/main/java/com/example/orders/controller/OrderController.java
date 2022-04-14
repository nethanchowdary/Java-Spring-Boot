package com.example.orders.controller;

import com.example.orders.dto.ResponseData;
import com.example.orders.dto.UserOrderDetails;
import com.example.orders.entity.Attachment;
import com.example.orders.entity.Note;
import com.example.orders.entity.Order;
import com.example.orders.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl service;


    @PostMapping("/notes")
    public ResponseEntity<?> createNote(@RequestParam("files") MultipartFile files, @RequestParam("note") String note){
        if(note!=null){
            System.out.println("note json "+note);
        }
        if(files!=null){
            System.out.println("files "+files);
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping("/buyNotes/{customerId}")
    public Order makeOrder (@PathVariable Long customerId,@RequestBody Set<Long> itemIds) {
        return service.buyNotes(customerId,itemIds);
    }
    @PostMapping("/addNotes")
    public Note addNotes (@RequestBody Note note){
        return service.addNotes(note);
    }
    @GetMapping("/findAllNotes")
    public List<Note> findAllNotes(){
        return service.findAllNotes();
    }

    @GetMapping("/getNotesDetails/{custId}")
    public UserOrderDetails getOrderDetailsById(@PathVariable Long custId){
        return service.findUsersDetailsWithNotes(custId);
    }

    @GetMapping("/textFromDocumernt")
    public String getTextFromTheDocument() throws IOException {
        return service.readText();
    }


    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Attachment attachment = null;
        String downloadURl = "";
        attachment = service.saveAttachment(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = service.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
}
