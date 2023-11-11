package com.scaler.splitexpense.controllers;

import com.scaler.splitexpense.dto.CreateGroupRequestDTO;
import com.scaler.splitexpense.models.Group;
import com.scaler.splitexpense.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;

    public Group createGroup(CreateGroupRequestDTO request){
        return groupService.createGroup(request);
    }
}
