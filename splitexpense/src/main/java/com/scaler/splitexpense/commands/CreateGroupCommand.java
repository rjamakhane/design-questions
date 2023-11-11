package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.GroupController;
import com.scaler.splitexpense.dto.CreateGroupRequestDTO;
import com.scaler.splitexpense.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command{

    private GroupController groupController;
    @Override
    public boolean matches(String input) {
        if(getCommand(input).equals(CommandKeys.CREATE_GROUP)){
            return  true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create group command");
        List<String> tokens = getTokens(input);
        List<Long> memberIds = Arrays.stream(tokens.get(3).split(",")).map(Long::valueOf).toList();
        CreateGroupRequestDTO createGroupRequestDTO = CreateGroupRequestDTO.builder()
                .name(tokens.get(1))
                .createdBy(Long.valueOf(tokens.get(2)))
                .membersIds(memberIds)
                .build();
        Group group = groupController.createGroup(createGroupRequestDTO);
        System.out.println("Created group with id: " + group.getId());
    }
}
