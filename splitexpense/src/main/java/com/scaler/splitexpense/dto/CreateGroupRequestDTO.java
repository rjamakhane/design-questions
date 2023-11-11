package com.scaler.splitexpense.dto;

import com.scaler.splitexpense.models.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateGroupRequestDTO {
    private String name;
    private Long createdBy;
    private List<Long> membersIds = new ArrayList<>();
}
