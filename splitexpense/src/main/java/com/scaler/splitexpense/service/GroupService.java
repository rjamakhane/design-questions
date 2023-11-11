package com.scaler.splitexpense.service;

import com.scaler.splitexpense.dto.CreateGroupRequestDTO;
import com.scaler.splitexpense.models.Group;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository groupRepository;
    private UserService userService;

    public Group createGroup(CreateGroupRequestDTO request){
        User createBy = userService.getUser(request.getCreatedBy());
        List<User> memebers = userService.getUsers(request.getMembersIds());
        Group group = Group.builder().name(request.getName()).createdBy(createBy).members(memebers).admins(List.of(createBy)).build();
        return groupRepository.save(group);
    }
}
