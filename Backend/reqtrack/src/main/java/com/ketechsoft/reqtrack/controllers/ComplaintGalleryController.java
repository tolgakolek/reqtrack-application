package com.ketechsoft.reqtrack.controllers;

import com.ketechsoft.reqtrack.constants.Mappings;
import com.ketechsoft.reqtrack.dtos.ComplaintGalleryDto;
import com.ketechsoft.reqtrack.models.ComplaintGallery;
import com.ketechsoft.reqtrack.services.ComplaintGalleryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Mappings.COMPLAINT_GALLERY_PATH)
@Api(description = "Complaint Gallery APIs")
public class ComplaintGalleryController {

    private final ComplaintGalleryService complaintGalleryService;

    @PostMapping("/{complaintID}")
    public void addComplaintGallery(@RequestBody List<ComplaintGalleryDto> complaintGalleryDTOList, @PathVariable(name = "complaintID") long complaintID) {
        complaintGalleryService.addGallery(complaintID, complaintGalleryDTOList);
    }

    @GetMapping("/complaintID")
    public ResponseEntity<List<ComplaintGallery>> getComplaintGallery(@PathVariable(name = "complaintID") long complaintID) {
        return ResponseEntity.ok(complaintGalleryService.getAllByComplaintId(complaintID));
    }
}
