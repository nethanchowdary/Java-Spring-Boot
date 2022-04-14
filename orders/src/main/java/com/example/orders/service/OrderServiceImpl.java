package com.example.orders.service;

import com.example.orders.dao.AttachmentRepository;
import com.example.orders.dao.INoteRepository;
import com.example.orders.dao.IOrderRepository;
import com.example.orders.dto.User;
import com.example.orders.dto.UserOrderDetails;
import com.example.orders.entity.Attachment;
import com.example.orders.entity.Note;
import com.example.orders.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Validated
@Service
public class OrderServiceImpl {
    @Autowired
    private INoteRepository iNoteRepository;
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    public Order buyNotes(@NotNull @Min(1) Long buyerId, @NotNull Set<Long> noteIds) {
        Order order =new Order();
        order.setBuyerId(buyerId);
        order.setNoteIds(noteIds);
        return orderRepository.save(order);
    }

    public Note addNotes(@NotNull @Valid Note note) {
        return iNoteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return iNoteRepository.findAll();
    }

    public UserOrderDetails findUsersDetailsWithNotes(@NotNull @Min(1) Long buyerId) {
        String url ="http://localhost:9500/users/getUserById/"+buyerId;
        User user= restTemplate.getForObject(url,User.class);
        UserOrderDetails details= new UserOrderDetails();
        details.setFirstName(user.getFirstName());
        details.setLastName(user.getLastName());
        details.setAddress(user.getAddress());
        List<Order> orderList=orderRepository.findAll();
        Set<Long>itemIds=orderList.stream().filter(order -> order.getBuyerId().equals(buyerId))
                .flatMap(order->order.getNoteIds().stream()).collect(Collectors.toSet());
        details.setNotesTitle(itemIds.stream().map(id-> iNoteRepository.findById(id))
                .map(item -> item.get().getNoteName()).collect(Collectors.toList()));
        details.setUserId(buyerId);

        return details;

    }

    public String readText() throws IOException {
        File resource = new ClassPathResource("test.json").getFile();
        return new String(Files.readAllBytes(resource.toPath()));
    }


    private AttachmentRepository attachmentRepository;

    public OrderServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            return attachmentRepository.save(attachment);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
}
